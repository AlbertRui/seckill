### (二)Java高并发秒杀API之Service层 
 首先在编写`Service`层代码前,我们应该首先要知道这一层到底时干什么的,这里摘取来自`ITEYE`一位博主的原话
 > Service层主要负责业务模块的逻辑应用设计。同样是首先设计接口,再设计其实现的类,接着再Spring的配置文件中配置其实现的关联。这样我们就可以在应用中调用Service接口来进行业务处理。Service层的业务实现,具体要调用到已定义的DAO层的接口,封装Service层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性,程序显得非常简洁。  
 
 在项目中要降低耦合的话,分层是一种很好的概念,就是各层各司其职,尽量不做不相干的事,所以`Service`层的话顾名思义就是**业务逻辑**,处理程序中的一些业务逻辑,以及调用`DAO`层的代码,这里我们的`DAo`层就是连接数据库的那一层,调用关系可以这样表达:  
   View(页面)>Controller(控制层)>Service(业务逻辑)>Dao(数据访问)>Database(数据库)  
   + 首先还是接口的设计,设计Service秒杀商品的接口  ``SeckillService``
  首先建立`org.seckil.service`这个包,这个包里面存放`Service`相关的接口,然后建立[SeckillService.java](/src/main/java/org/seckill/service/SeckillService.java)接口文件
建立后接口之后我们要写实现类了,在写实现类的时候我们肯定会碰到一个这样的问题,你要向前端返回`json`数据的话,你是返回什么样的数据好?直接返回一个数字状态码或者时文字?这样设计肯定是不好的,所以我们应该向前段返回一个实体信息`json`,里面包含了一系列的信息,无论是哪种状态都应该可以应对,既然是与数据库字段无关的类,那就不是`PO`了,所以我们建立一个`DTO`数据传输类,关于常见的几种对象我的解释如下:
 + PO:   也就是我们在为每一张数据库表写一个实体的类
 + VO,   对某个页面或者展现层所需要的数据,封装成一个实体类
 + BO,   就是业务对象,我也不是很了解
 + DTO,  跟VO的概念有点混淆,也是相当于页面需要的数据封装成一个实体类
 + POJO, 简单的无规则java对象
 
 在`org.seckill`下建立`dto`包,然后建立[Exposer.java](/src/main/java/org/seckill/dto/Exposer.java),这个类是秒杀时数据库那边处理的结果的对象
然后我们给页面返回的数据应该是更加友好的封装数据,所以我们再在`org.seckill.dto`包下再建立[SeckillExecution.java](/src/main/java/org/seckill/dto/SeckillExecution.java)用来封装给页面的结果.

##### 定义秒杀中可能会出现的异常
  + 定义一个继承自RuntimeException的运行时异常,所有的子异常继承这个异常[SeckillException.java](/src/main/java/org/seckill/exception/SeckillException.java)
  + 首选可能会出现秒杀关闭后被秒杀情况,所以建立秒杀关闭异常[CloseSeckillException.java](/src/main/java/org/seckill/exception/CloseSeckillException.java),需要继承我们一开始写的基础异常 
  + 然后还有可能发生重复秒杀异常[RepeatSeckillException.java](/src/main/java/org/seckill/exception/RepeatSeckillException.java)
#### 实现`Service`接口: [SeckillServiceImpl.java](/src/main/java/org/seckill/service/impl/SeckillServiceImpl.java)
在这里我们捕获了运行时异常,这样做的原因就是`Spring`的事物默认就是发生了`RuntimeException`才会回滚,可以检测出来的异常是不会导致事物的回滚的,这样的目的就是你明知道这里会发生异常,所以你一定要进行处理.如果只是为了让编译通过的话,那捕获异常也没多意思,所以这里要注意事物的回滚.  
然后我们还发现这里存在硬编码的现象,就是返回各种字符常量,例如`秒杀成功`,`秒杀失败`等等,这些字符串时可以被重复使用的,而且这样维护起来也不方便,要到处去类里面寻找这样的字符串,所有我们使用枚举类来管理这样状态,在`org.seckill`包下建立`enums`包,专门放置枚举类,然后再建立[SeckillStatEnum](/src/main/java/org/seckill/enums/SeckillStateEnum.java)枚举类:
既然把这些改成了枚举,那么在[SeckillServiceImpl.java](/src/main/java/org/seckill/service/impl/SeckillServiceImpl.java)类中的`executeSeckill`方法中成功秒杀的返回值就应该修改为  
```java
return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
```
改了这里以后会发现会报错,因为在实体类那边构造函数可不是这样的,然后修改`SeckillExecution`类的构造函数,把`state`跟`stateInfo`的值设置从构造函数里面的`SeckillStatEnum`中取出值来设置：
````java

/*  秒杀成功返回的实体  */
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.successKilled = successKilled;
    }

    /*  秒杀失败返回的实体  */
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

````

####  下一步肯定要注入Service了
首先在类路径下`resources/spring`下建立[spring-service.xml](/src/main/resources/spring/spring-service.xml)文件,用来配置`Service层的相关代码`:

在这里开启了基于**注解**的事物,常见的事物操作有以下几种方法
 + 在Spring早期版本中是使用ProxyFactoryBean+XMl方式来配置事物.
 + 在Spring配置文件使用tx:advice+aop命名空间,好处就是一次配置永久生效,你无须去关心中间出的问题,不过出错了你很难找出来在哪里出了问题
 + 注解@Transactional的方式,注解可以在`方法定义`,`接口定义`,`类定义`,`public方法上`,但是不能注解在`private`,`final`,`static`等方法上,因为Spring的事物管理默认是使用Cglib动态代理的:
   - private方法因为访问权限限制,无法被子类覆盖
   - final方法无法被子类覆盖
   - static时类级别的方法,无法被子类覆盖
   - protected方法可以被子类覆盖,因此可以被动态字节码增强
##### 不能被Spring AOP事物增强的方法  
  | 序号 | 动态代理策略 |不能被事物增强的方法 |
  |:-----:| :-----: |:-----:|
  |  1    |基于接口的动态代理  |出了public以外的所有方法,并且 public static 的方法也不能被增强 |
  |   2   |基于Cglib的动态代理  | private,static,final的方法 |
  
然后你要在`Service`类上添加注解`@Service`,不用在接口上添加注解：
```java

@Service
public class SeckillServiceImpl implements SeckillService 
```
既然已经开启了基于注解的事物,那我们就去需要被事物的方法上加个注解`@Transactional`吧:
```java
@Transactional
    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException 
```
#### Service层的测试
写测试类,建立一个名为[SeckillServiceTest.java](/src/test/java/org/seckill/service/SeckillServiceTest.java)的测试类
测试的话如果每个方法测试都通过就说明通过,如果报错了话就仔细看下哪一步错了检查下  
### 上一篇  [(一)Java高并发秒杀API之业务分析与DAO层](../note/note1.md)

###  下一篇   [(三)Java高并发秒杀API之web层](../note/note3.md)
  
---

- [(四)Java高并发秒杀API之高并发优化](../note/note4.md)  

---

如果项目流程总结中有什么问题欢迎发`Issue`给我,或者您也可以直接联系我`ZR_sxlx@163.com`,感谢您的阅读
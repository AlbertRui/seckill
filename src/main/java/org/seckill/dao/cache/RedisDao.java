package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author AlbertRui
 * @date 2018-03-09 22:33
 */
@SuppressWarnings("JavaDoc")
public class RedisDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JedisPool jedisPool;

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    /**
     * redis操作步骤
     *
     * @param seckillId
     * @return
     */
    public Seckill getSeckill(Long seckillId) {
        try {
            try (Jedis jedis = jedisPool.getResource()) {
                String key = "seckill:" + seckillId;
                //并没有实现内部序列化操作
                //get->byte[]->反序列化：Object(seckill)
                //采用自定义序列化
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    //从缓存中获取到
                    //空对象
                    Seckill seckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    //seckill被反序列化
                    return seckill;
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return null;
    }

    /**
     * set Object(seckill) -> 序列化 -> byte[]
     *
     * @param seckill
     * @return
     */
    public String putSeckill(Seckill seckill) {
        try {
            try (Jedis jedis = jedisPool.getResource()) {
                String key = "seckill:" + seckill.getSeckillId();
                LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, buffer);
                return jedis.setex(key.getBytes(), 3600, bytes);
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return null;
    }

}

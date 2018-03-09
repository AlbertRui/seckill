var seckill = {
    //封装秒杀相关Ajax的URL
    URL: {
        now: function () {
            return '/seckill/time/now';
        }
    },
    
    //处理秒杀逻辑
    handlerSeckill:function () {
        
    },
    
    //验证手机号
    validatePhone: function (phone) {
        return (phone && phone.length === 11 && !isNaN(phone));
    },

    countDown: function (seckillId, nowTime, startTime, endTime) {
        //时间判断
        if (nowTime > endTime) {
            //秒杀结束
            $('#seckill-box').html('秒杀结束！！！');
        } else if (nowTime < startTime) {
            //秒杀未开始，计时事件绑定
            var killTime = new Date(startTime + 1000);
            $('#seckill-box').countdown(killTime, function (event) {
                //时间格式
                var timeFormate = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                $('#seckill-box').html(timeFormate);
            }).on('finish.countdown', function () {
                
            })
        } else {
            //秒杀开始
        }
    },

    //详情页秒杀逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //手机验证和登录，计时交互,在cookie中查找手机号
            var killPhone = $.cookie("killPhone");
            //验证手机号
            if (!seckill.validatePhone(killPhone)) {
                $("#killPhoneModal").modal({
                    show: true,//显示弹出层
                    backdrop: 'static',//禁止位置关闭
                    keyboard: false //禁止键盘事件
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneKey').val();
                    console.log('inputPhone:' + inputPhone);
                    if (seckill.validatePhone(inputPhone)) {
                        //电话写入cookie
                        $.cookie('killPhone', inputPhone, {expires: 7, path: '/seckill'});
                        //重新加载页面
                        window.location.reload();
                    } else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误！！！</label>').show(300);
                    }
                });
            }
            //已经登录,计时交互
            var seckillId = params["seckillId"];
            var startTime = params["startTime"];
            var endTime = params["endTime"];
            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];
                    //时间判断
                    seckill.countdown(seckillId, nowTime, startTime, endTime);
                } else {
                    console.log('result:' + result);
                }
            });
        }
    }
};
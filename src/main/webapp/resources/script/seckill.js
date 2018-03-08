var seckill = {
    //封装秒杀相关Ajax的URL
    URL: {},
    //验证手机号
    validatePhone: function (phone) {
        return (phone && phone.length === 11 && !isNaN(phone));
    },
    //详情页秒杀逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //手机验证和登录，计时交互,在cookie中查找手机号
            var killPhone = $.cookie("killPhone");
            var seckillId = params["seckillId"];
            var startTime = params["startTime"];
            var endTime = params["endTime"];
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
            //已经登录
        }
    }
};
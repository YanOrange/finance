<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="/js/html5.min.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>账户信息</legend>
        </fieldset>

        <form class="layui-form" action="">
            <input type="hidden" value="${company.id!''}" id="companyId">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">公司名称</label>
                    <div class="layui-input-block">
                        <div class="layui-form-mid">${company.name!''}</div>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-block">
                        <div class="layui-form-mid">${company.address!''}</div>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">联系方式</label>
                    <div class="layui-input-block">
                        <div class="layui-form-mid">${company.phone!''}</div>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">账户余额</label>
                    <div class="layui-input-block">
                        <div class="layui-form-mid" id="cost">${(company.cost/100!'')}</div>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" onclick="refresh();" href="javascript:;">余额修正</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
<script>
    function refresh(){
        var $companyId = $('#companyId');
        //prompt层
        layer.confirm('确认修正嘛？', {
            btn: ['确认','取消'] //按钮
        },  function () {
            $.ajax({
                url:'/ioRecord/refreshCost',
                type:'post',
                dataType:'json',
                success:function(res){
                    if (res.success){
                        var data = res.data;
                        var cost = data.cost/100;
                        $('#cost').html(cost);
                        layer.msg('已修正');
                    } else{
                        layer.msglayer.msg(res.msg, {icon: 2});
                    }
                }
            })

        });
    }
</script>

</html>

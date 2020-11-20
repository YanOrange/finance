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
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="/js/html5.min.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
    <style>
        .iconfont {
            font-family:"iconfont" !important;
            font-size:16px;
            font-style:normal;
            -webkit-font-smoothing: antialiased;
            -webkit-text-stroke-width: 0.2px;
            -moz-osx-font-smoothing: grayscale;
        }
    </style>
</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a><cite>导航元素</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">

                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input" autocomplete="off" placeholder="开始日" name="start" id="start">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input" autocomplete="off" placeholder="截止日" name="end" id="end"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off"
                                   class="layui-input"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header"> </div>
                <div class="layui-card-body ">
                    <table id="LAY_table_user" class="layui-table">

                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
</body>

<script>
    layui.use('laydate',
        function () {
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });

        });
</script>
<script>
    layui.use('table',function () {
        var table = layui.table;

    });
</script>
<script>
    /*操作数据*/

</script>
<script th:inline="none">
    /*数据查询*/

    $(function () {
        getAllWages();
    })

    /*获取全部文章*/
    function getAllWages() {
        layui.use('table',
            function () {
                var table = layui.table;
                table.render({
                    id: "checkboxTable",
                    url: '/wages/findWagesByUser',
                    elem: '#LAY_table_user',
                    page:true,
                    cols: [[
                        {checkbox: true},
                        {field: 'id', title: 'ID', width: 80},
                        {field: 'remark', title: '工资名称', sort: true, width: 120},
                        {field: 'wages',width:80, title: '固定工资', sort: true,templet:'<div>{{d.wages/100}}</div>'},
                        {field: 'achieveWages',width:80, title: '绩效工资', sort: true,templet:'<div>{{d.achieveWages/100}}</div>'},
                        {field: 'departmentAchievements', title: '部门绩效', sort: true, width: 150},
                        {field: 'achievements', title: '个人绩效', sort: true, width: 150},
                        {field: 'bonus', title: '奖金', sort: true, width: 150,templet:'<div>{{d.bonus/100}}</div>'},
                        {field: 'tax', title: '杂税', sort: true, width: 150,templet:'<div>{{d.tax/100}}</div>'},
                        {field: 'totalWages',width:80, title: '实发工资', sort: true,templet:'<div>{{d.totalWages/100}}</div>'},
                        {field: 'createTime', title: '创建时间', sort: true, width: 120},
                        {toolbar:'#barTeacher',title:'操作',width: 120}

                    ]]
                })

            });
    }



    /**
     * 判断字段是否为空
     * @param o
     * @returns {*}
     */
    function isNullFormat(o) {
        if (o) {
            return o;
        }else{
            return '暂无';
        }
    }

</script>

</html>
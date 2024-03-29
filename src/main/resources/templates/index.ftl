<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.2</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/css/theme2138.min.css">
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="/js/html5.min.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
    <script>
        // 是否开启刷新记忆tab功能
        // var is_remember = false;
    </script>
</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="/index.html">X-admin v2.2</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>
    <#--<ul class="layui-nav left fast-add" lay-filter="">-->
    <#--<li class="layui-nav-item">-->
    <#--<a href="javascript:;">+新增</a>-->
    <#--<dl class="layui-nav-child">-->
    <#--<!-- 二级菜单 &ndash;&gt;-->
    <#--<dd>-->
    <#--<a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">-->
    <#--<i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>-->
    <#--<dd>-->
    <#--<a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">-->
    <#--<i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>-->
    <#--<dd>-->
    <#--<a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">-->
    <#--<i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>-->
    <#--<dd>-->
    <#--<a onclick="xadmin.add_tab('在tab打开','member-list.html')">-->
    <#--<i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>-->
    <#--<dd>-->
    <#--<a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">-->
    <#--<i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>-->
    <#--</dl>-->
    <#--</li>-->
    <#--</ul>-->
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <#--<dd>-->
                <#--<a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>-->
                <dd>
                    <a href="/page/exit">切换帐号</a></dd>
                <dd>
                    <a href="/page/exit">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index">
            <a href="/">前台首页</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
<#--            <#if user.status==0>-->
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="个人管理">&#xe6b8;</i>
                        <cite>个人管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i></a>
                    <ul class="sub-menu">
                        <li>
                            <a onclick="xadmin.add_tab('个人信息','/page/person')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>个人信息</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('工资条','/page/personWages')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>工资条</cite></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="业务收支管理">&#xe6b8;</i>
                        <cite>业务收支管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i></a>
                    <ul class="sub-menu">
                        <li>
                            <a onclick="xadmin.add_tab('本人收支记录','/page/projectApply')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>本人收支记录</cite></a>
                        </li>
                    </ul>
                </li>
<#--            </#if>-->
            <#if user.status==3>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="财务管理">&#xe6b8;</i>
                        <cite>财务管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i></a>
                    <ul class="sub-menu">
                        <li>
                            <a onclick="xadmin.add_tab('公司账户','/page/companyInfo')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>公司账户</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('业务项目类别管理','/page/typeList')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>业务项目类别管理</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('报表管理','/page/reportList')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>报表管理</cite></a>
                        </li>
                        <li>
                            <a onclick="xadmin.add_tab('工资管理','/page/wagesList')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>工资管理</cite></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="审批管理">&#xe6b8;</i>
                        <cite>审批管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i></a>
                    <ul class="sub-menu">
                        <li>
                            <a onclick="xadmin.add_tab('业务收支审批','/page/masterEssayList')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>业务收支审批</cite></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont left-nav-li" lay-tips="部门管理">&#xe6b8;</i>
                        <cite>部门管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i></a>
                    <ul class="sub-menu">
                        <li>
                            <a onclick="xadmin.add_tab('部门管理','/page/deptList')">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>部门管理</cite></a>
                        </li>
                    </ul>
                </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="人员管理">&#xe6b8;</i>
                    <cite>人员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('人员管理','/page/adminList')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>部门管理</cite></a>
                    </li>
                </ul>
            </li>
            </#if>

        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home">
                <i class="layui-icon">&#xe68e;</i>我的桌面
            </li>
        </ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd>
            </dl>
        </div>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/page/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->

</body>

</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-header">
    <div class="layui-logo">标题</div>

    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                win
            </a>
            <dl class="layui-nav-child">
                <dd><a href="">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">注销</a></li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree " lay-filter="demo">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="javascript:;" href="javascript:;">基本元素<span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child">
                    <dd><a href="index">列表一</a></dd>
                    <dd><a href="index">列表二</a></dd>
                    <dd><a href="index">列表三</a></dd>
                    <dd><a href="index">超链接</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">解决方案</a>
                <dl class="layui-nav-child">
                    <dd><a href="index">列表一</a></dd>
                    <dd><a href="index">列表二</a></dd>
                    <dd><a href="index">超链接</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="index">云市场</a></li>
            <li class="layui-nav-item"><a href="index">发布商品</a></li>

            <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
        </ul>
    </div>
</div>
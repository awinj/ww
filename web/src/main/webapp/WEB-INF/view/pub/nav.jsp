<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="javascript:;" href="javascript:;">用户角色<span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child">
                    <dd><a href="/ww/auth/user/index">用户管理</a></dd>
                    <dd><a href="/ww/auth/role/index">角色管理</a></dd>
                    <dd><a href="/ww/auth/power/index">功能菜单</a></dd>
                    <%--<dd><a href="/ww/auth/power/index">权限分配</a></dd>--%>
                </dl>
            </li>
            <c:forEach items="${navs}" var="nav" >
                <li class="layui-nav-item ">
                    <a class="javascript:;" >${nav.currNode.powerName}<span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <c:forEach items="${nav.childrenNode}" var="node">
                            <dd>
                                <c:if test="${nav.hasChildren()}">
                                    <a class="javascript:;" >${nav.currNode.powerName}<span class="layui-nav-more"></span></a>
                                    <dl class="layui-nav-child">
                                        <c:forEach items="${nav.childrenNode}" var="node2th">
                                            <dd>
                                                <a href="${node2th.currNode.url}">${node2th.currNode.powerName}</a>
                                            </dd>
                                        </c:forEach>
                                    </dl>
                                </c:if>
                                <c:if test="${!nav.hasChildren()}">
                                    <a href="${node.currNode.url}">${node.currNode.powerName}</a>
                                </c:if>

                            </dd>
                        </c:forEach>
                    </dl>
                </li >
            </c:forEach>




            <li class="layui-nav-item" style="height: 30px; text-align: center"></li>
        </ul>
    </div>
</div>
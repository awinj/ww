<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-09-11
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<%--<link href="/ww/pub/css/bootstrap.min.css" rel="stylesheet">--%>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="/ww/pub/js/jquery-1.11.1.min.js" type="application/javascript"></script>
<!-- 包括所有已编译的插件 -->
<%--<script src="/ww/pub/js/bootstrap.min.js" type="application/javascript"></script>--%>

<link rel="stylesheet" href="/ww/pub/layui/css/layui.css">
<%--<link rel="stylesheet" href="/ww/pub/layui/css/admin.css">--%>
<script src="/ww/pub/layui/layui.js"></script>


<script>
    //加载tables数据，其中查询接口未query
    function loadtable(id, layfilter, cols) {
        layui.use(['table', 'element'], function () {
            var table = layui.table;
            //第一个实例
            table.render({
                elem: id,
                title: '用户',
                toolbar: 'default',
                url: 'query', //数据接口
                request: {
                    pageName: 'index', //页码的参数名称，默认：page
                    limitName: 'pageSize' //每页数据量的参数名，默认：limit
                },
                page: true, //开启分页
                cols: cols
            });
//            //监听导航点击
//            var element = layui.element;
//            element.on('nav(demo)',function (elem) {
//                console.log(elem); //得到当前点击的DOM对象
//            });

        });
    }

    //加载查询面板
    function loadquerypanl(id,cols) {
        var html='<div class="layui-form layui-card-header layuiadmin-card-header-auto" lay-filter="app-content-workorder"> <div class="layui-form-item">';

        if(cols!=null&&cols.length>0)
        {
            for(var i=0;i<cols.length;i++){
                var col=cols[i];
                if(col==null)
                    continue;
                html+=('<div class="layui-inline">');
                html+=('   <label class="layui-form-label">'+col.title+'</label>');
                html+=('   <div class="layui-input-block">');
                html+=('       <input name="'+col.field+'" class="layui-input" type="text" placeholder="请输入" autocomplete="off">');
                html+=('   </div>');
                html+=('</div>');
            }
        }
        html+=('<div class="layui-inline">');
        html+=('   <button class="layui-btn layuiadmin-btn-order" lay-filter="LAY-app-order-search" lay-submit=""> ');
        html+=('       <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>');
        html+=('   </button>');
        html+=('</div>');
        html+=('</div>');
        html+=('</div>');
        $(id).html(html);




    }
</script>


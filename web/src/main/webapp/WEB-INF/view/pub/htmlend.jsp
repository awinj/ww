<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-09-11
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<!-- 模态框（Modal） -->--%>
<%--<div class="modal fade" id="refModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                <%--<h4 class="modal-title" id="refTitle">模态框（Modal）标题</h4>--%>
            <%--</div>--%>
            <%--<div class="modal-body" id="refData">在这里添加一些文本</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                <%--<button type="button" class="btn btn-primary" id="refOK">确定</button>--%>
            <%--</div>--%>
        <%--</div><!-- /.modal-content -->--%>
    <%--</div><!-- /.modal -->--%>
<%--</div>--%>





<script src="/ww/pub/js/winref.js" type="application/javascript"></script>
<script type="application/javascript">
    var currpath=window.location.pathname;
//    currpath="index";
    $("  [href='"+currpath+"']").filter(".layui-nav-child a").addClass("layui-this");
</script>
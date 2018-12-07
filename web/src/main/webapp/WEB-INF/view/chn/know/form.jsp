<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formdiv" class="formdiv">
    <fieldset class="layui-elem-field layui-field-title">
        <legend>知识库</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item"><label class="layui-form-label">主键</label>
            <div class="layui-input-inline"><input name="pk_know" class="layui-input" type="text" placeholder="请输入主键"
                                                   value="" autocomplete="off" lay-verify="pk_know"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">标题</label>
            <div class="layui-input-inline"><input name="title" class="layui-input" type="text" placeholder="请输入标题"
                                                   value="" autocomplete="off" lay-verify="title"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">编号</label>
            <div class="layui-input-inline"><input name="code" class="layui-input" type="text" placeholder="请输入编号"
                                                   value="" autocomplete="off" lay-verify="code"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">作者</label>
            <div class="layui-input-inline"><input name="pk_author" class="layui-input" type="text" placeholder="请输入作者"
                                                   value="" autocomplete="off" lay-verify="pk_author"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">窑口</label>
            <div class="layui-input-inline"><input name="kilneye" class="layui-input" type="text" placeholder="请输入窑口"
                                                   value="" autocomplete="off" lay-verify="kilneye"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">年代</label>
            <div class="layui-input-inline"><input name="times" class="layui-input" type="text" placeholder="请输入年代"
                                                   value="" autocomplete="off" lay-verify="times"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">造型</label>
            <div class="layui-input-inline"><input name="model" class="layui-input" type="text" placeholder="请输入造型"
                                                   value="" autocomplete="off" lay-verify="model"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">期刊号</label>
            <div class="layui-input-inline"><input name="journalnum" class="layui-input" type="text"
                                                   placeholder="请输入期刊号" value="" autocomplete="off"
                                                   lay-verify="journalnum"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">简介</label>
            <div class="layui-input-inline"><input name="memo" class="layui-input" type="text" placeholder="请输入简介"
                                                   value="" autocomplete="off" lay-verify="memo"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">关键词</label>
            <div class="layui-input-inline"><input name="keyword" class="layui-input" type="text" placeholder="请输入关键词"
                                                   value="" autocomplete="off" lay-verify="keyword"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">系统关键词</label>
            <div class="layui-input-inline"><input name="syskeyword" class="layui-input" type="text"
                                                   placeholder="请输入系统关键词" value="" autocomplete="off"
                                                   lay-verify="syskeyword"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">单价</label>
            <div class="layui-input-inline"><input name="price" class="layui-input" type="text" placeholder="请输入单价"
                                                   value="" autocomplete="off" lay-verify="price"/></div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline"><label class="layui-form-label">修改人</label>
                <div class="layui-input-inline"><input name="modifier" class="layui-input" type="text"
                                                       placeholder="请输入修改人" value="" autocomplete="off"
                                                       lay-verify="modifier"/></div>
            </div>
            <div class="layui-inline"><label class="layui-form-label">修改时间</label>
                <div class="layui-input-inline"><input name="modifyTime" class="layui-input" type="text"
                                                       placeholder="yyyy-MM-dd" value="" autocomplete="off"
                                                       lay-verify="nullOrDate"/></div>
            </div>
        </div>
        <div class="layui-form-item bodydata">
            <table class="layui-hide" id="bodydata_table" lay-filter="bodydata"></table>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block ">
                <button class="layui-btn" lay-submit lay-filter="form_save">保存</button>
                <button type="button" class="layui-btn layui-btn-primary" lay-filter="form_close"
                        onclick="closelayer()">取消
                </button>
            </div>
        </div>
    </form>
</div>
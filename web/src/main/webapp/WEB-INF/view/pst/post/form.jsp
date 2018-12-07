<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formdiv" class="formdiv">
    <fieldset class="layui-elem-field layui-field-title">
        <legend>互动交流</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item"><label class="layui-form-label">主键</label>
            <div class="layui-input-inline"><input name="pk_post" class="layui-input" type="text" placeholder="请输入主键"
                                                   value="" autocomplete="off" lay-verify="pk_post"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">主题</label>
            <div class="layui-input-inline"><input name="title" class="layui-input" type="text" placeholder="请输入主题"
                                                   value="" autocomplete="off" lay-verify="title"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">内容</label>
            <div class="layui-input-inline"><input name="content" class="layui-input" type="text" placeholder="请输入内容"
                                                   value="" autocomplete="off" lay-verify="content"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">图片</label>
            <div class="layui-input-inline"><input name="photo" class="layui-input" type="text" placeholder="请输入图片"
                                                   value="" autocomplete="off" lay-verify="photo"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">图片位置</label>
            <div class="layui-input-inline"><input name="photoposi" class="layui-input" type="text"
                                                   placeholder="请输入图片位置" value="" autocomplete="off"
                                                   lay-verify="photoposi"/></div>
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
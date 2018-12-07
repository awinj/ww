<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-11-07
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formdiv" class="formdiv">
    <fieldset class="layui-elem-field layui-field-title">
        <legend>作者</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item layui-hide"><label class="layui-form-label">主键</label>
            <div class="layui-input-inline"><input name="pk_author" class="layui-input" type="text" placeholder="请输入主键"
                                                   value="" autocomplete="off" lay-verify="pk_author"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">名称</label>
            <div class="layui-input-inline"><input name="name" class="layui-input" type="text" placeholder="请输入名称"
                                                   value="" autocomplete="off" lay-verify="name"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">备案号</label>
            <div class="layui-input-inline"><input name="record" class="layui-input" type="text" placeholder="请输入备案号"
                                                   value="" autocomplete="off" lay-verify="record"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">地址</label>
            <div class="layui-input-inline"><input name="address" class="layui-input" type="text" placeholder="请输入地址"
                                                   value="" autocomplete="off" lay-verify="address"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline"><input name="cantact" class="layui-input" type="text" placeholder="请输入联系方式"
                                                   value="" autocomplete="off" lay-verify="cantact"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">官网地址</label>
            <div class="layui-input-inline"><input name="url" class="layui-input" type="text" placeholder="请输入官网地址"
                                                   value="" autocomplete="off" lay-verify="url"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline"><input name="email" class="layui-input" type="text" placeholder="请输入邮箱"
                                                   value="" autocomplete="off" lay-verify="email"/></div>
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

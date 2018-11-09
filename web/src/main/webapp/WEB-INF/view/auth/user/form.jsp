<%--
  Created by IntelliJ IDEA.
  User: aWin
  Date: 2018-11-07
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="display: none" id="formdiv">
    <form class="layui-form" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-top: 15px">主键</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="pk_user" class="layui-input" type="text" placeholder="请输入主键" value=""
                           autocomplete="off" lay-verify="pk_user"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">用户编码</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="userCode" class="layui-input" type="text" placeholder="请输入用户编码" value=""
                           autocomplete="off" lay-verify="userCode"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">用户名</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="userName" class="layui-input" type="text" placeholder="请输入用户名" value=""
                           autocomplete="off" lay-verify="userName"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">密码</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="password" class="layui-input" type="text" placeholder="请输入密码" value=""
                           autocomplete="off" lay-verify="password"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">是否锁定</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="isLocked" class="layui-input" type="text" placeholder="请输入是否锁定" value=""
                           autocomplete="off" lay-verify="isLocked"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">手机</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="telephone" class="layui-input" type="text" placeholder="请输入手机" value=""
                           autocomplete="off" lay-verify="telephone"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">邮箱</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="email" class="layui-input" type="text" placeholder="请输入邮箱" value="" autocomplete="off"
                           lay-verify="email"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">性别</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="sex" class="layui-input" type="text" placeholder="请输入性别" value="" autocomplete="off"
                           lay-verify="sex"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">城市</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="city" class="layui-input" type="text" placeholder="请输入城市" value="" autocomplete="off"
                           lay-verify="city"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">签名</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="sign" class="layui-input" type="text" placeholder="请输入签名" value="" autocomplete="off"
                           lay-verify="sign"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">分数</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="score" class="layui-input" type="text" placeholder="请输入分数" value="" autocomplete="off"
                           lay-verify="score"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">创建人</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="creator" class="layui-input" type="text" placeholder="请输入创建人" value=""
                           autocomplete="off" lay-verify="creator"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">创建时间</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="creationTime" class="layui-input" type="text" placeholder="请输入创建时间" value=""
                           autocomplete="off" lay-verify="creationTime"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">修改人</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="modifier" class="layui-input" type="text" placeholder="请输入修改人" value=""
                           autocomplete="off" lay-verify="modifier"/>
                </div>
                <label class="layui-form-label" style="margin-top: 15px">修改时间</label>
                <div class="layui-input-inline" style="margin-top: 15px">
                    <input name="modifyTime" class="layui-input" type="text" placeholder="请输入修改时间" value=""
                           autocomplete="off" lay-verify="modifyTime"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="form_save">保存</button>
                <button type="button" class="layui-btn layui-btn-primary" lay-filter="form_close" onclick="closelayer()">取消</button>
            </div>
        </div>
    </form>
</div>

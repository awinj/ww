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
        <legend>用户信息</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item layui-hide">
            <label class="layui-form-label ">主键</label>
            <div class="layui-input-block ">
                <input name="pk_user" class="layui-input" type="text" placeholder="请输入主键" value=""
                       autocomplete="off" lay-verify="pk_user"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户编码</label>
            <div class="layui-input-block">
                <input name="userCode" class="layui-input" type="text" placeholder="请输入用户编码" value=""
                       autocomplete="off" lay-verify="required"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input name="userName" class="layui-input" type="text" placeholder="请输入用户名" value=""
                       autocomplete="off" lay-verify="required"/>
            </div>
        </div>
        <div class="layui-form-item layui-hide">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input name="password" class="layui-input" type="text" placeholder="请输入密码" value=""
                       autocomplete="off" lay-verify="password"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input name="sex" title="男" type="radio" checked="" value="男" />
                <input name="sex" title="女" type="radio" value="女" />

            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">手机</label>
                <div class="layui-input-inline">
                    <input name="telephone" class="layui-input" type="text" placeholder="请输入手机" value=""
                           autocomplete="off" lay-verify="phone"/>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <input name="email" class="layui-input" type="text" placeholder="请输入邮箱" value="" autocomplete="off"
                           lay-verify="email"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">城市</label>
                <div class="layui-input-inline">
                    <input name="city" class="layui-input" type="text" placeholder="请输入城市" value="" autocomplete="off"
                           lay-verify="city"/>
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">签名</label>
            <div class="layui-input-block">
                <textarea name="sign" class="layui-textarea" type="text" placeholder="请输入签名" value="" autocomplete="off"
                       lay-verify="sign">
                </textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">已锁定</label>
            <div class="layui-input-inline">
                <input name="isLocked" type="checkbox" lay-skin="switch" lay-text="是|否" value="Y">
            </div>
        </div>
        <div class="layui-form-item layui-hide">
            <label class="layui-form-label">分数</label>
            <div class="layui-input-inline">
                <input name="score" class="layui-input" type="text" placeholder="请输入分数" value="0" autocomplete="off"
                       lay-verify="nullOrNumber"/>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">创建人</label>
                <div class="layui-input-inline">
                    <input name="creator" class="layui-input" type="text" placeholder="请输入创建人" value=""
                           autocomplete="off" lay-verify="creator"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">创建时间</label>
                <div class="layui-input-inline">
                    <input name="creationTime" class="layui-input" type="text" placeholder="yyyy-MM-dd" value=""
                           autocomplete="off" lay-verify="nullOrDate"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">修改人</label>
                <div class="layui-input-inline">
                    <input name="modifier" class="layui-input" type="text" placeholder="请输入修改人" value=""
                           autocomplete="off" lay-verify="modifier"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">修改时间</label>
                <div class="layui-input-inline">
                    <input name="modifyTime" class="layui-input" type="text" placeholder="yyyy-MM-dd" value=""
                           autocomplete="off" lay-verify="nullOrDate"/>
                </div>
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


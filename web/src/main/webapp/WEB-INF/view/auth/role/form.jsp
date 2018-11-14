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
        <legend>角色信息</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item layui-hide">
            <label class="layui-form-label ">主键</label>
            <div class="layui-input-block ">
                <input name="pk_role" class="layui-input" type="text" placeholder="请输入主键" value=""
                       autocomplete="off" lay-verify="pk_user"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色编码</label>
            <div class="layui-input-inline">
                <input name="roleCode" class="layui-input" type="text" placeholder="请输入角色编码" value=""
                       autocomplete="off" lay-verify="required"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-inline">
                <input name="roleName" class="layui-input" type="text" placeholder="请输入角色名称" value=""
                       autocomplete="off" lay-verify="required"/>
            </div>
        </div>
        <div class="layui-form-item layui-hide">
            <label class="layui-form-label">角色类型</label>
            <div class="layui-input-inline">
                <select name="roleType">
                    <option value="">请选择省</option>
                    <option value="角色权限" selected="">角色权限</option>
                    <option value="按钮权限">按钮权限</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <input name="memo" class="layui-input" type="text" placeholder="请输入备注" value="" autocomplete="off"
                           lay-verify="memo"/>
                </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">是否启用</label>
            <div class="layui-input-inline">
                <input name="enable" type="checkbox" lay-skin="switch" lay-text="是|否" value="Y">
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


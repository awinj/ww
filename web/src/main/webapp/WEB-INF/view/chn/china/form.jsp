<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formdiv" class="formdiv">
    <fieldset class="layui-elem-field layui-field-title">
        <legend>藏品管理</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item layui-hide"><label class="layui-form-label">主键</label>
            <div class="layui-input-inline"><input name="pk_china" class="layui-input" type="text" placeholder="请输入主键"
                                                   value="" autocomplete="off" lay-verify="pk_china"/></div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-inline"><label class="layui-form-label">标题</label>
                <div class="layui-input-inline"><input name="title" class="layui-input" type="text" placeholder="请输入标题"
                                                       value="" autocomplete="off" lay-verify="title"/></div>
            </div>

            <div class="layui-form-inline"><label class="layui-form-label">编号</label>
                <div class="layui-input-inline"><input name="code" class="layui-input" type="text" placeholder="请输入编号"
                                                       value="" autocomplete="off" lay-verify="code"/></div>
            </div>
            <div class="layui-form-inline"><label class="layui-form-label">作者</label>
                <div class="layui-input-inline"><input name="pk_author" class="layui-input" type="text"
                                                       placeholder="请输入作者"
                                                       value="" autocomplete="off" lay-verify="pk_author"/></div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-form-inline"><label class="layui-form-label">窑口</label>
                <div class="layui-input-inline"><input name="kilneye" class="layui-input" type="text"
                                                       placeholder="请输入窑口"
                                                       value="" autocomplete="off" lay-verify="kilneye"/></div>
            </div>
            <div class="layui-form-inline"><label class="layui-form-label">年代</label>
                <div class="layui-input-inline"><input name="times" class="layui-input" type="text" placeholder="请输入年代"
                                                       value="" autocomplete="off" lay-verify="times"/></div>
            </div>

            <div class="layui-form-inline"><label class="layui-form-label">造型</label>
                <div class="layui-input-inline"><input name="model" class="layui-input" type="text" placeholder="请输入造型"
                                                       value="" autocomplete="off" lay-verify="model"/></div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-inline"><label class="layui-form-label">单价</label>
                <div class="layui-input-inline"><input name="price" class="layui-input" type="text" placeholder="请输入单价"
                                                       value="" autocomplete="off" lay-verify="price"/></div>
            </div>
            <div class="layui-form-inline"><label class="layui-form-label">数量</label>
                <div class="layui-input-inline"><input name="num" class="layui-input" type="text" placeholder="请输入数量"
                                                       value="" autocomplete="off" lay-verify="num"/></div>
            </div>

            <div class="layui-form-inline"><label class="layui-form-label">关键词</label>
                <div class="layui-input-inline"><input name="keyword" class="layui-input" style="width:300px"
                                                       type="text" placeholder="请输入关键词"
                                                       value="" autocomplete="off" lay-verify="keyword"/></div>
            </div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">简介</label>
            <div class="layui-input-block"><textarea name="memo" class="layui-textarea" type="text" placeholder="请输入简介"
                                                     value="" autocomplete="off"
                                                     lay-verify="memo"></textarea></div>

        </div>

        <div class="layui-form-item layui-hide"><label class="layui-form-label">系统关键词</label>
            <div class="layui-input-inline"><input name="syskeyword" class="layui-input" type="text"
                                                   placeholder="请输入系统关键词" value="" autocomplete="off"
                                                   lay-verify="syskeyword"/></div>
        </div>

        <div class="layui-form-item layui-hide">
            <div class="layui-inline">
                <label class="layui-form-label">创建人</label>
                <div class="layui-input-inline">
                    <input name="creator" disabled="disabled" class="layui-input" type="text" placeholder="请输入创建人"
                           value=""
                           autocomplete="off" lay-verify="creator" ref="user"/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">创建时间</label>
                <div class="layui-input-inline">
                    <input name="creationTime" disabled="disabled" class="layui-input" type="text" value=""
                           autocomplete="off" lay-verify="nullOrDate"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-hide">
            <div class="layui-inline"><label class="layui-form-label">修改人</label>
                <div class="layui-input-inline"><input name="modifier" disabled="disabled" class="layui-input"
                                                       type="text"
                                                       value="" autocomplete="off" ref="user"
                                                       lay-verify="modifier"/></div>
            </div>
            <div class="layui-inline"><label class="layui-form-label">修改时间</label>
                <div class="layui-input-inline"><input name="modifyTime" disabled="disabled" class="layui-input"
                                                       type="text"
                                                       value="" autocomplete="off"
                                                       lay-verify="nullOrDate"/></div>
            </div>
        </div>
        <div class="layui-form-item bodydata">
            <table class="layui-table" id="bodydata_table"    lay-filter="bodydata">
                <thead>
                <tr>
                    <th lay-data="{field:'pk_resource',hide:true}">pk_resource</th>
                    <th lay-data="{field:'permtype'}">是否收费</th>
                    <th lay-data="{field:'title' ,edit:'text'}">标题</th>
                    <th lay-data="{field:'secourcetype'}">资源类型</th>
                    <th lay-data="{field:'content',edit:'text'}">内容</th>
                    <th lay-data="{field:'price',edit:'text'}">积分</th>
                    <th lay-data="{field:'orderno', sort: true,edit:'text'}">顺序号</th>
                    <th lay-data="{field:'billtype',hide:true}">billtype</th>
                    <th lay-data="{field:'pk_china',hide:true}">pk_china</th>
                    <th lay-data="{field:'pk_know', hide: true}">pk_know</th>
                </tr>
                </thead>
            </table>
        </div>

        <script id="permtype" type="text/html">

            <select class="layui-input" name="permtype" >
                <option value="0">免费</option>
                <option value="1">积分</option>
            </select>
            <%--<input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.id == 10003 ? 'checked' : '' }}>--%>
        </script>

        <script id="secourcetype" type="text/html">
            <select class="layui-input" name="secourcetype" >
                <option value="0">文字</option>
                <option value="1">图片</option>
                <option value="2">视频</option>
            </select>

        </script>

        <%--<div style="padding-left: 50px;margin-top: 10px">--%>
            <%--<table class="layui-table">--%>
                <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th width="10" onclick="addrow(this)">+</th>--%>
                    <%--<th>是否收费</th>--%>
                    <%--<th>标题</th>--%>
                    <%--<th>资源类型</th>--%>
                    <%--<th>内容</th>--%>
                    <%--<th>积分</th>--%>
                    <%--<th>顺序号</th>--%>
                <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>
                <%--<template>--%>
                    <%--<td>-</td>--%>
                    <%--<td><select class="layui-input" name="permtype">--%>
                        <%--<option value="0">免费</option>--%>
                        <%--<option value="1">积分</option>--%>
                    <%--</select></td>--%>
                    <%--<td><input class="layui-input" name="title" value=""></td>--%>
                    <%--<td><select class="layui-input" name="secourcetype">--%>
                        <%--<option value="0">文字</option>--%>
                        <%--<option value="1">图片</option>--%>
                        <%--<option value="2">视频</option>--%>
                    <%--</select></td>--%>
                    <%--<td><input class="layui-input" name="content" value=""></td>--%>
                    <%--<td><input class="layui-input" name="price" value=""></td>--%>
                    <%--<td><input class="layui-input" name="orderno" value=""></td>--%>
                <%--</template>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
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

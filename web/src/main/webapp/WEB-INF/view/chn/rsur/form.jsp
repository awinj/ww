<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formdiv" class="formdiv">
    <fieldset class="layui-elem-field layui-field-title">
        <legend>资源</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item"><label class="layui-form-label">主键</label>
            <div class="layui-input-inline"><input name="pk_resource" class="layui-input" type="text"
                                                   placeholder="请输入主键" value="" autocomplete="off"
                                                   lay-verify="pk_resource"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">权限类型</label>
            <div class="layui-input-inline"><input name="permtype" class="layui-input" type="text" placeholder="请输入权限类型"
                                                   value="" autocomplete="off" lay-verify="permtype"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">资源类型</label>
            <div class="layui-input-inline"><input name="secourcetype" class="layui-input" type="text"
                                                   placeholder="请输入资源类型" value="" autocomplete="off"
                                                   lay-verify="secourcetype"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">标题</label>
            <div class="layui-input-inline"><input name="title" class="layui-input" type="text" placeholder="请输入标题"
                                                   value="" autocomplete="off" lay-verify="title"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">内容</label>
            <div class="layui-input-inline"><input name="content" class="layui-input" type="text" placeholder="请输入内容"
                                                   value="" autocomplete="off" lay-verify="content"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">单价</label>
            <div class="layui-input-inline"><input name="price" class="layui-input" type="text" placeholder="请输入单价"
                                                   value="" autocomplete="off" lay-verify="price"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">排序号</label>
            <div class="layui-input-inline"><input name="orderno" class="layui-input" type="text" placeholder="请输入排序号"
                                                   value="" autocomplete="off" lay-verify="orderno"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">数量</label>
            <div class="layui-input-inline"><input name="billtype" class="layui-input" type="text" placeholder="请输入数量"
                                                   value="" autocomplete="off" lay-verify="billtype"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">所属陶瓷</label>
            <div class="layui-input-inline"><input name="pk_china" class="layui-input" type="text" placeholder="请输入所属陶瓷"
                                                   value="" autocomplete="off" lay-verify="pk_china"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">所属知识</label>
            <div class="layui-input-inline"><input name="pk_know" class="layui-input" type="text" placeholder="请输入所属知识"
                                                   value="" autocomplete="off" lay-verify="pk_know"/></div>
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
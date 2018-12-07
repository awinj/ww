<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="formdiv" class="formdiv">
    <fieldset class="layui-elem-field layui-field-title">
        <legend>订单</legend>
    </fieldset>
    <form class="layui-form winadmin" id="formpanl" action="" lay-filter="form_filter">
        <div class="layui-form-item"><label class="layui-form-label">主键</label>
            <div class="layui-input-inline"><input name="pk_order" class="layui-input" type="text" placeholder="请输入主键"
                                                   value="" autocomplete="off" lay-verify="pk_order"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">标题</label>
            <div class="layui-input-inline"><input name="title" class="layui-input" type="text" placeholder="请输入标题"
                                                   value="" autocomplete="off" lay-verify="title"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">备注</label>
            <div class="layui-input-inline"><input name="memeo" class="layui-input" type="text" placeholder="请输入备注"
                                                   value="" autocomplete="off" lay-verify="memeo"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">总金额</label>
            <div class="layui-input-inline"><input name="amount" class="layui-input" type="text" placeholder="请输入总金额"
                                                   value="" autocomplete="off" lay-verify="amount"/></div>
        </div>
        <div class="layui-form-item"><label class="layui-form-label">订单状态</label>
            <div class="layui-input-inline"><input name="state" class="layui-input" type="text" placeholder="请输入订单状态"
                                                   value="" autocomplete="off" lay-verify="state"/></div>
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
/**
 * Created by aWin on 2018-10-11.
 */

/**
 * onclick='selectAll(this)'
 * @param obj checkbox实例  ,点击全选/全消 name相同的checkbox
 */
function selectAll(obj) {
    var name=obj.name;
    var inputtype=obj.type;
    var checked=obj.checked;
    $("input[name='"+name+"']:"+inputtype).prop("checked",checked);
}



function httpPost(url,jsonStr,reqDataType)
{
    var ret=null;
    if(reqDataType==null)
        reqDataType='json';
    $.ajax({
        url:url,
        type:'post',
        dataType:reqDataType,
        contentType:'application/json;charset=UTF-8',
        data:jsonStr,
        async:false,//同步
        success:function (result) {
            ret= result;
        },
        error:function (result) {
            layer.msg("网络异常");
        }
    });
    return ret;
}




//加载tables数据，其中查询接口必须为query
function loadTable(id, layfilter, cols) {
    layui.use(['table', 'element','form'], function () {
        var table = layui.table;
        var form = layui.form;
        var element = layui.element;
        //第一个实例
        var tableinstance=table.render({
            id:'data_table',
            elem: id,
            title: '用户',
            toolbar: '#toolbar',
            url: 'query', //数据接口
            request: {
                pageName: 'index', //页码的参数名称，默认：page
                limitName: 'pageSize' //每页数据量的参数名，默认：limit
            },
            page: true, //开启分页
            cols: cols
        });

        //监听行单击事件（双击事件为：rowDouble，单击事件为row）
        table.on('rowDouble('+layfilter+')', function(obj){
            var selectedData = obj.data;
            // setFormValue(selectedData);
            doUpdate(selectedData);
        });



        table.on('toolbar('+layfilter+')', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    doAdd();
                    break;
                case 'update':
                    var selectedData = checkStatus.data;
                    if(selectedData==null||selectedData.length!=1)
                    {
                        layer.alert('请选中一条数据修改', {icon: 0});
                        return ;
                    }
                    doUpdate(selectedData[0]);
                    break;
                case 'delete':
                    var datas = checkStatus.data;
                    if(datas==null||datas.length<1)
                    {
                        layer.alert('请至少选中一条数据', {icon: 0});
                        return ;
                    }
                    var aggvo=[];
                    for(var index in datas)
                    {
                        aggvo.push({
                            parentVO:datas[index]
                        })
                    }
                    doDelete(aggvo);
                    table.reload('data_table');
                    break;
                default : doElse(obj.event,checkStatus.data);
            };
        });

        table.exportFile(tableinstance.config.id, 1); //data 为该实例中的任意数量的数据


        form.on('submit(data_search)', function(data){
            var field = data.field;
            //执行重载
            table.reload('data_table',{
                    where: {condition: JSON.stringify(field)}
                }
            );

        });
        //监听提交
        form.on('submit(form_save)', function(data){
            doSave(data.field);
            closelayer();
            table.reload("data_table");
            return false;
        });

        form.on('radio',function (data) {
            console.log(data.elem); //得到radio原始DOM对象
            console.log(data.value); //被点击的radio的value值
        })


        form.verify({
            nullOrNumber: function(value, item){ //value：表单的值、item：表单的DOM对象  ^[0-9]*$
                if(value!="") {
                    if (!new RegExp("^[0-9]*$").test(value) )
                        return "必须为数字";
                }
            },
            
            nullOrPhone:function (value,item) {   //^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$
                if(value!="") {
                    if (!new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$").test(value) )
                        return "手机号格式不正确";
                }
            },

            nullOrEmail:function (value,item) {
                if(value!="") {
                    if (!new RegExp("^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$").test(value))
                        return "邮箱格式不正确";
                }
            },

            nullOrDate:function (value,item) {
                if(value!="") {
                    if (!new RegExp("^\\d{4}-\\d{1,2}-\\d{1,2}").test(value))
                        return "日期格式不正确";
                }
            },
           
        });



    });
}

//加载查询面板
function loadQueryPanl(id,cols) {
    var html='<div class="layui-form layui-card-header layuiadmin-card-header-auto" lay-filter="app-content-ww"> <div class="layui-form-item">';

    if(cols!=null&&cols.length>0)
    {
        for(var i=0;i<cols.length;i++){
            var col=cols[i];
            if(col==null)
                continue;
            html+=('<div class="layui-inline">');
            html+=('   <label class="layui-form-label">'+col.title+'</label>');
            html+=('   <div class="layui-input-block">');
            html+=('       <input name="'+col.field+'" class="layui-input" type="text" placeholder="请输入" autocomplete="off">');
            html+=('   </div>');
            html+=('</div>');
        }
    }
    html+=('<div class="layui-inline">');
    html+=('   <button class="layui-btn layuiadmin-btn-order" lay-filter="data_search" lay-submit=""> ');
    html+=('       <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>');
    html+=('   </button>');
    html+=('</div>');
    html+=('</div>');
    html+=('</div>');
    $(id).html(html);

}




function doDelete(selectedPks) {

}




function doAdd() {
    clearForm("#formdiv");//清空表单
    layer.open({
        type:1,
        content: $('#formdiv'),
        area:  '60%',
    });
}


function doUpdate(selectedData) {
    clearForm("#formdiv");//清空表单
    setFormValue(selectedData);
    layer.open({
        type:1,
        content: $('#formdiv'),
        area:  '60%',
    });
}

//增删改查之外的按钮事件。
function doElse(event,data) {

}

function clearForm(id) {
    $(id + " input").not(":radio").not(":checkbox").val("");//清空表单,排除radio，否则导致radio取值取不了
}


function setFormValue(data){
    layui.use(['form'], function () {
        var form = layui.form;
        form.val("form_filter", data);
    });

}


function closelayer() {
    layer.closeAll();
}





function nodeExtend(obj) {
    var id=obj.id;
    $("#"+id+" ul").toggle();
}
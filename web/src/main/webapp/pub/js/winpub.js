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
            toolbar: 'default',
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
                    var data = checkStatus.data;
                    doDelete(null,data);
                    break;
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
            // layer.msg(JSON.stringify(data.field));
            doSave(data.field);
            layer.close(1);
            return false;
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




function doDelete(title,selectedData) {
    layer.alert(JSON.stringify(selectedData));
}




function doAdd() {
    $("#formdiv input").val("");//清空表单
    layer.open({
        type:1,
        content: $('#formdiv'),
        area:  '60%',
    });
}


function doUpdate(selectedData) {
    setFormValue(selectedData);
    layer.open({
        type:1,
        content: $('#formdiv'),
        area:  '60%',
    });
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
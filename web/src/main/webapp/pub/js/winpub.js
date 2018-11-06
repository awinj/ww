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
            var data = obj.data;
            // layer.alert(JSON.stringify(data), {
            //     title: '当前行数据：'
            // });
            //标注选中样式
            // obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');

            doUpdate(data);
        });

        table.on('toolbar('+layfilter+')', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    // var data = checkStatus.data;
                    // layer.alert(JSON.stringify(data));
                    doAdd();
                    break;
                case 'update':
                    var data = checkStatus.data;
                    doUpdate(data);
                    break;
                case 'delete':
                    var data = checkStatus.data;
                    doDelete(null,data);
                    break;
            };
        });

        table.exportFile(tableinstance.config.id, 1); //data 为该实例中的任意数量的数据

        var form = layui.form;

        form.on('submit(LAY-app-order-search)', function(data){
            var field = data.field;
            //执行重载
            table.reload('data_table',
                {
                    where: {condition: JSON.stringify(field)}
                }
            );

        });
//            //监听导航点击
//            var element = layui.element;
//            element.on('nav(demo)',function (elem) {
//                console.log(elem); //得到当前点击的DOM对象
//            });

    });
}

//加载查询面板
function loadQueryPanl(id,cols) {
    var html='<div class="layui-form layui-card-header layuiadmin-card-header-auto" lay-filter="app-content-workorder"> <div class="layui-form-item">';

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
    html+=('   <button class="layui-btn layuiadmin-btn-order" lay-filter="LAY-app-order-search" lay-submit=""> ');
    html+=('       <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>');
    html+=('   </button>');
    html+=('</div>');
    html+=('</div>');
    html+=('</div>');
    $(id).html(html);

}


function createForm(fields) {
    var html='<div id="#formdiv" >';
    html+='<form class="layui-form" id="#formpanl" action="">';

    if(fields!=null&&fields.length>0)
    {
        var showCount=fields.length; //显示的字段数量。用于决定采用哪种布局
        if(showCount/3<3)
        {
            for(var i=0;i<fields.length;i++)
            {
                var field=fields[i];
                html+='<div class="layui-form-item">';
                html+='     <div class="layui-inline" >';
                html+='         <label class="layui-form-label">'+field.title+'</label>';
                html+='         <div class="layui-input-inline">';
                html+='             <input name="'+field.field+'" class="layui-input" type="text" placeholder="请输入'+field.title+'" autocomplete="off" lay-verify="'+field.field+'">';
                html+='         </div>';
                html+='     </div>';
                html+='</div>';
            }
        }
        else
        {
            html+='<div class="layui-form-item">';
            html+='     <div class="layui-inline">';
            for(var i=0;i<fields.length;i++)
            {
                var field=fields[i];
                html+='         <label class="layui-form-label" style="margin-top: 15px">'+field.title+'</label>';
                html+='         <div class="layui-input-inline" style="margin-top: 15px">';
                html+='             <input name="'+field.field+'" class="layui-input" type="text" placeholder="请输入'+field.title+'" autocomplete="off" lay-verify="'+field.field+'">';
                html+='         </div>';
            }
            html+='     </div>';
            html+='</div>';
        }
    }
    else
    {
        html+="模板加载出错"
    }


    html+='</form>';
    html+='</div>';


return html;

}


function createForm(fields,selectedData) {
    var html='<div id="#formdiv" >';
    html+='<form class="layui-form" id="#formpanl" action="">';

    if(fields!=null&&fields.length>0)
    {
        var showCount=fields.length; //显示的字段数量。用于决定采用哪种布局
        if(showCount/3<3)
        {
            for(var i=0;i<fields.length;i++)
            {
                var field=fields[i];
                html+='<div class="layui-form-item">';
                html+='     <div class="layui-inline" >';
                html+='         <label class="layui-form-label">'+field.title+'</label>';
                html+='         <div class="layui-input-inline">';
                html+='             <input name="'+field.field+'" class="layui-input" type="text" placeholder="请输入'+field.title+'" autocomplete="off" lay-verify="'+field.field+'">';
                html+='         </div>';
                html+='     </div>';
                html+='</div>';
            }
        }
        else
        {
            html+='<div class="layui-form-item">';
            html+='     <div class="layui-inline">';
            for(var i=0;i<fields.length;i++)
            {
                var field=fields[i];
                html+='         <label class="layui-form-label" style="margin-top: 15px">'+field.title+'</label>';
                html+='         <div class="layui-input-inline" style="margin-top: 15px">';
                html+='             <input name="'+field.field+'" class="layui-input" type="text" placeholder="请输入'+field.title+'" autocomplete="off" lay-verify="'+field.field+'">';
                html+='         </div>';
            }
            html+='     </div>';
            html+='</div>';
        }
    }
    else
    {
        html+="模板加载出错"
    }


    html+='</form>';
    html+='</div>';


    return html;

}


function doDelete(title,selectedData) {
    layer.alert(JSON.stringify(selectedData));
}

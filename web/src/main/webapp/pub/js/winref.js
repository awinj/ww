/**
 * Created by aWin on 2018-10-11.
 */
/**
 *
 * @param dispfield 用于显示的字段
 * @param pkfield 存储pk值的隐藏字段
 * @param ismuti 是否多选
 * @param refdata{
        theadData:[],
        tbodyData:[],
        title:'',
    }
 */
function bootstrapRefdoc(dispfield,pkfield,refdata,isMuti){

    refdata = {
        theadData: ["pk","编码", '名称'],
        tbodyData: [["pk1","01", "德启"], ["pk2","02", "德启"]],
        title: '公司目录',
    };

    var thisObj = $(dispfield);
    console.log(thisObj);
    var selectedVals=$(pkfield).val();//获取选中的值
    if(selectedVals.indexOf(",")<0)  //将selectedVals转化为数组
        selectedVals=[selectedVals];
    else
        selectedVals=selectedVals.split(",");
    $("#refTitle").html(refdata.title);
    var str  = "<table class='table table-hover'>" ;
    str+="<thead><tr>" ;
    var inputtype='radio';
    var hiddenSelectAll="hidden='hidden'";
    if(refdata.theadData!=null)
    {
        if(isMuti)//如果是多选，将类型设置为checkbox,并且全选框不隐藏
        {
            inputtype='checkbox';
            hiddenSelectAll="";
        }
        str+="<th><input id='selecAll' type='"+inputtype+"' name='refchk' "+hiddenSelectAll+" value='"+refdata.theadData[0]+"' onclick='selectAll(this)'></th>";
        for(var headindex=1 ; headindex<refdata.theadData.length;headindex++)
        {
            str+="<th>"+refdata.theadData[headindex]+"</th>" ;
        }
    }
    str+="</tr></thead>" ;
    str+="<tbody>" ;
    if(refdata.tbodyData!=null)
    {
        for(var bodydata in refdata.tbodyData)
        {
            var ischecked="";
//                if(selectedVals.indexOf(refdata.tbodyData[bodydata][0])>=0)
            if($.inArray(refdata.tbodyData[bodydata][0],selectedVals)>=0)//将已选择的数据勾选上
            {
                ischecked="checked='checked'";
            }
            str+="<tr><td><input type='"+inputtype+"' name='refchk' value='"+refdata.tbodyData[bodydata][0]+"' "+ischecked+"' ></td>";
            for(var bodyfield=1; bodyfield< refdata.tbodyData[bodydata].length;bodyfield++)
            {
                str+="<td>"+refdata.tbodyData[bodydata][bodyfield]+"</td>";
            }
            str+="</tr>";
        }
    }
    str+="</tbody></table>";
    $("#refData").html(str);
    $("#refModal").modal("show");
    //点击确定，将弹出框关闭，并且将选中的数据返回到字段上
    $("#refOK").click(function () {
        var selectPks=new Array();
        var selectNames=new Array();
        $("input[name='refchk']:checked").each(function () {
            var eleid=$(this).prop("id");
            if(eleid!='selecAll')
            {
                selectPks.push($(this).val());
                if($(this).parent()!=null&&$(this).parent().next()!=null)
                    selectNames.push($(this).parent().next().html());
            }
        });
        $(dispfield).val(selectNames);//显示参照框的第一个字段
        $(pkfield).val(selectPks);//隐藏的pk值为checkbox的value
        $("#refModal").modal("hide");
    })
}


/**
 *
 * @param dispfield 用于显示的字段
 * @param pkfield 存储pk值的隐藏字段
 * @param ismuti 是否多选
 * @param refdata{
        theadData:[],
        tbodyData:[],
        title:'',
    }
 */
function layuiRefdoc(dispfield,pkfield,refdata,isMuti) {
    refdata = {
        theadData: ["pk","编码", '名称'],
        tbodyData: [["pk1","01", "德启"], ["pk2","02", "德启"]],
        title: '公司目录',
    };
    var thisObj = $(dispfield);
    console.log(thisObj);
    var selectedVals=$(pkfield).val();//获取选中的值
    if(selectedVals.indexOf(",")<0)  //将selectedVals转化为数组
        selectedVals=[selectedVals];
    else
        selectedVals=selectedVals.split(",");
    $("#refTitle").html(refdata.title);
    var str  = "<table class='layui-table'>" ;
    str+="<thead><tr>" ;
    var inputtype='radio';
    var hiddenSelectAll="hidden='hidden'";
    if(refdata.theadData!=null)
    {
        if(isMuti)//如果是多选，将类型设置为checkbox,并且全选框不隐藏
        {
            inputtype='checkbox';
            hiddenSelectAll="";
        }
        str+="<th><input id='selecAll' type='"+inputtype+"' name='refchk' "+hiddenSelectAll+" value='"+refdata.theadData[0]+"' onclick='selectAll(this)'></th>";
        for(var headindex=1 ; headindex<refdata.theadData.length;headindex++)
        {
            str+="<th>"+refdata.theadData[headindex]+"</th>" ;
        }
    }
    str+="</tr></thead>" ;
    str+="<tbody>" ;
    if(refdata.tbodyData!=null)
    {
        for(var bodydata in refdata.tbodyData)
        {
            var ischecked="";
//                if(selectedVals.indexOf(refdata.tbodyData[bodydata][0])>=0)
            if($.inArray(refdata.tbodyData[bodydata][0],selectedVals)>=0)//将已选择的数据勾选上
            {
                ischecked="checked='checked'";
            }
            str+="<tr><td><input type='"+inputtype+"' name='refchk' value='"+refdata.tbodyData[bodydata][0]+"' "+ischecked+"' ></td>";
            for(var bodyfield=1; bodyfield< refdata.tbodyData[bodydata].length;bodyfield++)
            {
                str+="<td>"+refdata.tbodyData[bodydata][bodyfield]+"</td>";
            }
            str+="</tr>";
        }
    }
    str+="</tbody></table>";

    layer.open({
        title:refdata.title,
        content: str,
        yes: function(index, layero){
            var selectPks=new Array();
            var selectNames=new Array();
            $("input[name='refchk']:checked").each(function () {
                var eleid=$(this).prop("id");
                if(eleid!='selecAll')
                {
                    selectPks.push($(this).val());
                    if($(this).parent()!=null&&$(this).parent().next()!=null)
                        selectNames.push($(this).parent().next().html());
                }
            });
            $(dispfield).val(selectNames);//显示参照框的第一个字段
            $(pkfield).val(selectPks);//隐藏的pk值为checkbox的value
            layer.close(index); //如果设定了yes回调，需进行手工关闭
        }
    });



    // //点击确定，将弹出框关闭，并且将选中的数据返回到字段上
    // $("#refOK").click(function () {
    //     var selectPks=new Array();
    //     var selectNames=new Array();
    //     $("input[name='refchk']:checked").each(function () {
    //         var eleid=$(this).prop("id");
    //         if(eleid!='selecAll')
    //         {
    //             selectPks.push($(this).val());
    //             if($(this).parent()!=null&&$(this).parent().next()!=null)
    //                 selectNames.push($(this).parent().next().html());
    //         }
    //     });
    //     $(dispfield).val(selectNames);//显示参照框的第一个字段
    //     $(pkfield).val(selectPks);//隐藏的pk值为checkbox的value
    //     $("#refModal").modal("hide");



}


// function getHtml(refdata) {
//     var str  = "<table class='table table-hover'>" ;
//     str+="<thead><tr>" ;
//     var inputtype='radio';
//     var hiddenSelectAll="hidden='hidden'";
//     if(refdata.theadData!=null)
//     {
//         if(isMuti)//如果是多选，将类型设置为checkbox,并且全选框不隐藏
//         {
//             inputtype='checkbox';
//             hiddenSelectAll="";
//         }
//         str+="<th><input id='selecAll' type='"+inputtype+"' name='refchk' "+hiddenSelectAll+" value='"+refdata.theadData[0]+"' onclick='selectAll(this)'></th>";
//         for(var headindex=1 ; headindex<refdata.theadData.length;headindex++)
//         {
//             str+="<th>"+refdata.theadData[headindex]+"</th>" ;
//         }
//     }
//     str+="</tr></thead>" ;
//     str+="<tbody>" ;
//     if(refdata.tbodyData!=null)
//     {
//         for(var bodydata in refdata.tbodyData)
//         {
//             var ischecked="";
// //                if(selectedVals.indexOf(refdata.tbodyData[bodydata][0])>=0)
//             if($.inArray(refdata.tbodyData[bodydata][0],selectedVals)>=0)//将已选择的数据勾选上
//             {
//                 ischecked="checked='checked'";
//             }
//             str+="<tr><td><input type='"+inputtype+"' name='refchk' value='"+refdata.tbodyData[bodydata][0]+"' "+ischecked+"' ></td>";
//             for(var bodyfield=1; bodyfield< refdata.tbodyData[bodydata].length;bodyfield++)
//             {
//                 str+="<td>"+refdata.tbodyData[bodydata][bodyfield]+"</td>";
//             }
//             str+="</tr>";
//         }
//     }
//     str+="</tbody></table>";
//     return str;
//
// }
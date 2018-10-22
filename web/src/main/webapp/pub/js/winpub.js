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
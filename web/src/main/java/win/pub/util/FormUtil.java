package win.pub.util;

import awin.bean.SuperVO;

import java.util.*;

/**
 * Created by aWin on 2018-11-15.
 *
 * @Description:
 */
public class FormUtil {
    public static void main(String[] args) {

        String json = "[{'field': 'pk_role', 'title': '主键','type':'key'},\n" +
                "{'field': 'roleCode', 'title': '角色编码','type':'text'},\n" +
                "{'field': 'roleName', 'title': '角色名称','type':'text'},\n" +
                "{'field': 'roleType', 'title': '角色类型','type':'text'},\n" +
                "{'field': 'memo', 'title': '备注','type':'text'},\n" +
                "{'field': 'enable', 'title': '是否锁定','type':'boolean'},\n" +
                "{'field': 'creator', 'title': '创建人','type':'text'},\n" +
                "{'field': 'creationTime', 'title': '创建时间','type':'time'},\n" +
                "{'field': 'modifier', 'title': '修改人','type':'text'},\n" +
                "{'field': 'modifyTime', 'title': '修改时间','type':'time'},\n" +
                "{'field': 'ts', 'title': '时间戳','type':'time'},\n" +
                "{'field': 'dr', 'title': '删除标志','type':'boolean'}]\n";
        System.out.print(createHtml("角色", json));
    }

    public static String createHtml(String title, String json) {

        Map<String, String>[] mapArr = JsonUtil.jsonToBean(json, Map[].class);
        List<String> specil = Arrays.asList("creator", "creationTime", "modifier", "modifyTime", "ts", "dr");

        StringBuilder html = new StringBuilder("<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>");
        html.append("<div id=\"formdiv\" class=\"formdiv\">");
        html.append("<fieldset class=\"layui-elem-field layui-field-title\">");
        html.append("<legend>" + title + "</legend>");
        html.append("</fieldset>");


        html.append("<form class=\"layui-form winadmin\" id=\"formpanl\" action=\"\" lay-filter=\"form_filter\">");

        String fieldName = "";
        String fieldtitle = "";
        String fieldType = "";
        String hidden = "";
        String placeholder = "";
        String verify = "";
        for (int i = 0; i < mapArr.length; i++) {
            fieldName = mapArr[i].get("field");
            fieldtitle = mapArr[i].get("title");
            fieldType = mapArr[i].get("type");
            hidden = "";
            if ("key".equals(fieldType)) {
                hidden = " layui-hide";
            }
            if ("time".equals(fieldType)) {
                placeholder = "yyyy-MM-dd";
            } else {
                placeholder = "请输入" + fieldtitle;
            }

            if ("time".equals(fieldType)) {
                verify = "nullOrDate";
            } else if ("number".equals(fieldType)) {
                verify = "nullOrNumber";
            } else {
                verify = fieldName;
            }
            if (!specil.contains(fieldName)) {
                html.append(" <div class=\"layui-form-item\" " + hidden + ">");
                html.append("<label class=\"layui-form-label\">" + fieldtitle + "</label>");
                html.append("<div class=\"layui-input-inline\">");
                if("boolean".equals(fieldType))
                    html.append("<input name=\""+fieldName+"\" type=\"checkbox\" lay-skin=\"switch\" lay-text=\"是|否\" value=\"Y\">");
                else
                    html.append("<input name=\"" + fieldName + "\" class=\"layui-input\" type=\"text\" placeholder=\"" + placeholder + "\" value=\"\" autocomplete=\"off\" lay-verify=\"" + verify + "\"/>");
                html.append("</div></div>");
            }

        }

        html.append("<div class=\"layui-form-item\">                                                                                     ");
        html.append("    <div class=\"layui-inline\">                                                                                    ");
        html.append("        <label class=\"layui-form-label\">修改人</label>                                                            ");
        html.append("        <div class=\"layui-input-inline\">                                                                          ");
        html.append("            <input name=\"modifier\" class=\"layui-input\" type=\"text\" placeholder=\"请输入修改人\" value=\"\"    ");
        html.append("                   autocomplete=\"off\" lay-verify=\"modifier\"/>                                                   ");
        html.append("        </div>                                                                                                      ");
        html.append("    </div>                                                                                                          ");
        html.append("    <div class=\"layui-inline\">                                                                                    ");
        html.append("        <label class=\"layui-form-label\">修改时间</label>                                                          ");
        html.append("        <div class=\"layui-input-inline\">                                                                          ");
        html.append("            <input name=\"modifyTime\" class=\"layui-input\" type=\"text\" placeholder=\"yyyy-MM-dd\" value=\"\"    ");
        html.append("                   autocomplete=\"off\" lay-verify=\"nullOrDate\"/>                                                 ");
        html.append("        </div>                                                                                                      ");
        html.append("    </div>                                                                                                          ");
        html.append("</div>                                                                                                              ");
        html.append("<div class=\"layui-form-item bodydata\">                                                                            ");
        html.append("    <table class=\"layui-hide\" id=\"bodydata_table\" lay-filter=\"bodydata\"></table>                              ");
        html.append("</div>                                                                                                              ");
        html.append("<div class=\"layui-form-item\">                                                                                     ");
        html.append("    <div class=\"layui-input-block \">                                                                              ");
        html.append("        <button class=\"layui-btn\" lay-submit lay-filter=\"form_save\">保存</button>                               ");
        html.append("        <button type=\"button\" class=\"layui-btn layui-btn-primary\" lay-filter=\"form_close\"                     ");
        html.append("                onclick=\"closelayer()\">取消                                                                       ");
        html.append("        </button>                                                                                                   ");
        html.append("    </div>                                                                                                          ");
        html.append("</div>                                                                                                              ");


        html.append("   </form></div>");

        return html.toString();
    }


}

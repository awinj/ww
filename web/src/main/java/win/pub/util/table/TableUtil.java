package win.pub.util.table;

import awin.bean.SuperVO;

import java.util.List;

/**
 * Created by aWin on 2018-11-25.
 *
 * @Description:
 */
public class TableUtil {

    public <T extends SuperVO> String  transHtml4Data(List<T> datas, IMapMeta map)
    {
        if(datas==null||datas.size()<1)
            return "";
        StringBuilder html=new StringBuilder();
        String[] fields=map.getFieldNames();
        String[] titles=map.getFieldDisplayNames();
        html.append("<table class='layui-table' style='margin-top:0px;'>");
        html.append("<thead><tr>");
        html.append("<th><input id='selecAll' type='checkbox' name='refchk'  onclick='selectAll(this)'></th>");
        for(int i=0;i<titles.length;i++)
        {
            html.append("<th>"+titles[i]+"</th>");
        }
        html.append("</tr></thead>" );
        html.append("<tbody>");
        for(T data : datas)
        {
            html.append("<tr><td><input type='checkbox' name='refchk' value='"+data.getPrimaryVal()+"' ></td>");
            for(int i=0;i<fields.length;i++)
            {
                html.append("<td>"+data.getAttrValue(fields[i])+"</td>");
            }
            html.append("</tr>");
        }
        html.append("</tbody></table>");

        html.append("<input class='table_ok' type='button' value='确认' />");
        html.append(        "    <input class='table_cancel' type='button' value='取消' onclick='closelayer()' >");
        return html.toString();
    }
}

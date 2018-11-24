package win.pub.util.tree;

import java.util.List;

/**
 * Created by aWin on 2018-11-24.
 *
 * @Description:
 */
public class TreeUtil {


    public String createTree4Data(List<ITree> datas)
    {
        TreeInitialize treeInitialize=new TreeInitialize();
        return createTreeHtml4Node(treeInitialize.trans2Tree(datas));
    }

    public String createTreeHtml4Node(List<TreeNode> trees)
    {
        if(trees==null||trees.size()<1)
            return "";
        StringBuilder html=new StringBuilder();
        html.append("<div class='wintree' >");
        html.append(createULHtml(trees));
        html.append("</div>");
        return  html.toString();
    }


    private StringBuilder createULHtml(List<TreeNode> nodes)
    {
        StringBuilder html=new StringBuilder();
        html.append("<ul >");
        for(TreeNode node :nodes)
        {
            html.append("<li class='node'>");
            if(node.hasChildren())
            {
                html.append("<div ><div class='extend'><span>+</span></div><input type='checkbox' value='"+node.id()+"'><label>");
                html.append(node.getContent()).append("</label></div>");
                html.append(createULHtml(node.getChildrenNode()));
                html.append("</li>");
            }
            else
            {
                html.append("<input type='checkbox' value='"+node.id()+"'><label>"+node.getContent()+"</label></li>");
            }
        }
        html.append("</ul>");
        return html;
    }
}

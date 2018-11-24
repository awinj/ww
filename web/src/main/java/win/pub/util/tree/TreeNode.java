package win.pub.util.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aWin on 2018-11-24.
 */
public class TreeNode<T extends ITree> {

    private T currNode;

    private TreeNode<T> parentNode;

    private List<TreeNode<T>> childrenNode;




    public TreeNode(T node)
    {
        this.currNode=node;
        childrenNode=new ArrayList<TreeNode<T>>();
    }

    public String id()
    {
        return currNode.id();
    }

    public String pid()
    {
        return parentNode.id();
    }

    public String route()
    {
        return currNode.route();
    }





    public T getCurrNode() {
        return currNode;
    }

    public void setCurrNode(T currNode) {
        this.currNode = currNode;
    }

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public void setChildrenNode(List<TreeNode<T>> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public List<TreeNode<T>> getChildrenNode() {
        return childrenNode;
    }

    public void addChild(TreeNode<T> data)
    {
        if(childrenNode==null)
            childrenNode=new ArrayList<TreeNode<T>>();
        childrenNode.add(data);
    }

    public boolean hasChildren()
    {
        return childrenNode==null||childrenNode.size()<1;
    }

    public String getContent()
    {
        return currNode.content();
    }
}

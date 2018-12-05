package win.pub.util.tree;

import awin.util.parse.ParseUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 初始化树,将具有数结构的一维表数据，转化为树结构的treeNode，
 *
 * @param <T>
 */
public class TreeInitialize<T extends ITree> {

    private HashMap<String, TreeNode<T>> trees = new HashMap<String, TreeNode<T>>();

    private HashMap<String, TreeNode<T>> map = new HashMap<String, TreeNode<T>>();


    public List<TreeNode<T>> trans2Tree(List<T> datas) {
        if (datas == null || datas.size() < 1)
            return null;
        for (T data : datas) {
            map.put(ParseUtil.parseString(data.route()) + ParseUtil.parseString(data.id()), new TreeNode<T>(data));
        }
        for (T data : datas) {
            String key = ParseUtil.parseString(data.route()) + ParseUtil.parseString(data.id());
            TreeNode<T> node = map.get(key);
            TreeNode<T> parentNode = map.get(ParseUtil.parseString(data.route()));
            //如果是根节点，直接放入map;可通过data.route()的值为空为根节点
            if (isNullOrEmpty(ParseUtil.parseString(data.route()))) {
                //在树中放如节点
                trees.put(ParseUtil.parseString(data.id()), node);
            } else if (parentNode != null) {
                parentNode.addChild(node);
                node.setParentNode(parentNode);
            } else {
                System.out.println("通过路" + node.route() + "由找不到父节点,故不加载到树中");
            }
        }
        return getTrees();
    }

    private boolean isRoot(T node) {
        String route = node.route();

        //路由,父id空视为根节点
        return isNullOrEmpty(route) && isNullOrEmpty(route);
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.length() < 1;
    }


    private List<TreeNode<T>> getTrees() {
        List<TreeNode<T>> forest = new ArrayList<TreeNode<T>>();
        forest.addAll(trees.values());
        return forest;
    }
}

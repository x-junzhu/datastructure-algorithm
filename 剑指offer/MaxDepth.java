package edu.fzu.lc2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-09-02 19:46
 */
public class MaxDepth {

    /**
     * BFS:层序遍历二叉树
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> q = new LinkedList<>();
        List<TreeNode> tmp;
        q.add(root);
        int count = 0;
        while (!q.isEmpty())
        {
            tmp = new LinkedList<>();
            for (TreeNode node: q)
            {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            q = tmp;
            count++;
        }
        return count;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

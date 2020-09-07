package edu.fzu.lc2;

import java.util.Stack;

public class AVLTree {

    /**
     * 判断以当前节点为根节点的子树是否是平衡二叉树
     * @param root 当前根节点
     * @return 是否是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode t = stack.pop();
            if(Math.abs(leftHeight(t) - rightHeight(t)) > 1) return false;
            if(t.left != null) stack.push(t.left);
            if(t.right != null) stack.push(t.right);
        }
        return true;

    }

    /**
     * 计算节点的高度
     * @param node 当前节点
     * @return 当前节点高度
     */
    public int height(TreeNode node)
    {
        return Math.max(node.left == null ? 0: height(node.left), node.right == null? 0: height(node.right)) + 1;
    }

    /**
     * 计算左子树的高度
     * @param node 当前节点
     * @return 当前节点左子树的高度
     */
    public int leftHeight(TreeNode node)
    {
        if(node.left == null) return 0;
        else return height(node.left);
    }

    /**
     * 计算右子树的高度
     * @param node 当前节点
     * @return 当前节点右子树高度
     */
    public int rightHeight(TreeNode node)
    {
        if(node.right == null) return 0;
        else return height(node.right);
    }
}

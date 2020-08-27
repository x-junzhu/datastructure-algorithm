package edu.fzu.lc;

import java.util.Stack;

/**
 * @author johnrambo
 * @create 2020-08-27 9:44
 */
public class ReBuildBinaryTree {

    /**
     * 1.使用前序遍历的第一个元素创建根节点
     * 2.创建一个栈，将根节点压入栈内
     * 3.初始化中序遍历下标为 0
     * 4.遍历前序遍历的每个元素，判断其上一个元素（即栈顶元素）是否
     *   等于中序遍历下标指向的元素
     *      4.1若上一个元素不等于中序遍历下标指向的元素，
     *      则将当前元素作为其上一个元素的左子节点，并将当前元素压入栈内
     *      4.2若上一个元素等于中序遍历下标指向的元素，则从栈内弹出一个元素，
     *      同时令中序遍历下标指向下一个元素，之后继续判断栈顶元素是否等于中序遍历下标
     *      指向的元素，若相等则重复该操作，直至栈为空或者元素不相等。
     *      然后令当前元素为最后一个想等元素的右节点。
     * 5.遍历结束，返回根节点
     * @param preorder 二叉树的前序遍历
     * @param inorder 二叉树的中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++)
        {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex])
            {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }
            else
            {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex])
                {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x)
    {
        val = x;
    }
}

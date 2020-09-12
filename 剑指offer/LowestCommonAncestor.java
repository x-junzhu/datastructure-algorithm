package edu.fzu.lc2;

public class LowestCommonAncestor {

    /**
     * 二叉排序树中p,q的最近公共祖先节点:
     * 因为是二叉搜索树所以可以根据节点值大小判断祖先节点
     * @param root 根节点
     * @param p 待求节点
     * @param q 待求节点
     * @return p和q的最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null)
        {
            if (p.val > root.val && q.val > root.val)
                root = root.right;
            else if (p.val < root.val && q.val < root.val) root = root.left;
            else break;
        }
        return root;
    }
}

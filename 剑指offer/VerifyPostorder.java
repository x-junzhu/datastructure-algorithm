package edu.fzu.lc2;

public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     * 判断输入的序列是否是二叉搜索树的后序遍历
     * @param postorder
     * @param left
     * @param right
     * @return
     */
    public boolean recur(int[] postorder, int left, int right)
    {
        if (left >= right) return true;

        int t = left;
        // 二叉树后序遍历根节点是最后一个
        int root = postorder[right];
        // 找到根节点左边第一个大于根节点的值, 其后的值都是右子树的(包括当前, 不包括最后一个)
        // 此时的t即为右子树的根节点
        while (postorder[t] < root) t++;

        int tmp = t;
        // 如果右子树的值存在比根节点小, 则返回false
        while (tmp < right)
        {
            if (postorder[tmp++] < root)
                return false;
        }
        // 递归查找左子树和右子树
        return recur(postorder, left, t - 1) && recur(postorder, t , right - 1);
    }
}

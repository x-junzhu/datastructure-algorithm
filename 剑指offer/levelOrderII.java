package edu.fzu.lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-08-30 16:12
 */
public class levelOrderII {

    /**
     * 广度优先遍历二叉树：每一层节点放在一个数组中
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> finalRes = new ArrayList<>();
        if (root == null) return finalRes;
        q.add(root);
        while (!q.isEmpty())
        {
            List<Integer> res = new ArrayList<>();
            int i = q.size();
            while ((i--) != 0)
            {
                TreeNode t = q.poll();
                res.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);

            }
            finalRes.add(res);
        }
        return finalRes;
    }
}

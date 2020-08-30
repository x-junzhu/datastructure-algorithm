package edu.fzu.lc;

import java.util.*;

/**
 * @author johnrambo
 * @create 2020-08-30 16:16
 */
public class LevelOrderIII {

    /**
     * BFS+倒序
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
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
            if (finalRes.size() % 2 == 1)
                Collections.reverse(res);
            finalRes.add(res);
        }
        return finalRes;
    }

    /**
     * BFS+双端队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> finalRes = new ArrayList<>();
        if (root == null) return finalRes;
        q.add(root);
        while (!q.isEmpty())
        {
            LinkedList<Integer> res = new LinkedList<>();
            int i = q.size();
            while ((i--) != 0)
            {
                TreeNode t = q.poll();
                if (finalRes.size() % 2 == 0) res.addLast(t.val);
                else res.addFirst(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            finalRes.add(res);
        }
        return finalRes;
    }
}

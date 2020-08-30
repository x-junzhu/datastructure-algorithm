package edu.fzu.lc;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-08-30 14:48
 */
public class LevelOrder {

    /**
     * 广度优先遍历二叉树
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty())
        {
            TreeNode t = q.poll();
            if (t.left != null) q.add(t.left);
            if (t.right != null) q.add(t.right);
            res.add(t.val);
        }
        int n = res.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = res.get(i);
        return arr;
    }
}

package edu.fzu.lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author johnrambo
 * @create 2020-08-31 11:12
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append("[");
        while (!q.isEmpty())
        {
            TreeNode t = q.poll();
            if (t != null)
            {
                sb.append(t.val + ",");
                q.add(t.left);
                q.add(t.right);
            }
            else
                sb.append("null,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] items = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(items[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty())
        {
            TreeNode t = q.poll();
            if (!items[i].equals("null")) {
                t.left = new TreeNode(Integer.parseInt(items[i]));
                q.add(t.left);
            }
            i++;
            if (!items[i].equals("null")) {
                t.right = new TreeNode(Integer.parseInt(items[i]));
                q.add(t.right);
            }
            i++;
        }
        return root;
    }
}

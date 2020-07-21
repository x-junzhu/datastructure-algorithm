package edu.fzu.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author johnrambo
 * @create 2020-07-18 15:42
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree bst = new BinarySortTree();

        for (int i = 0; i < arr.length; i++)
        {
            bst.createBinarySortTree(new Node(arr[i]));
        }

        System.out.println("中序遍历二叉树");
        bst.showBinarySortTree();

        bst.removeNode(2);
        System.out.println("删除后的二叉排序树");
        bst.showBinarySortTree();
        System.out.println("此时的根节点=" + bst.getRoot());
    }

}

class BinarySortTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    //构建二叉排序树
    public void createBinarySortTree(Node node)
    {
        if (this.root == null) this.root = node;
        else this.root.add(node);
    }

    //中序遍历二叉排序树
    public void showBinarySortTree()
    {
        if (this.root != null) this.root.infixOrder();
        else System.out.println("the root node is null");
    }

    /**
     * 1.返回以node为根节点的二叉排序树的最小节点的值
     * 2.删除以node为根节点二叉排序树的最小节点
     * @param node 传入的节点node(当做二叉树的根节点)
     * @return 以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightMin(Node node)
    {
        Node t = node;
        //循环的查找左子树
        while (t.left != null) t = node.left;
        //此时的target就指向了最小节点值
        removeNode(t.value);
        return t.value;
    }

    //删除节点
    public void removeNode(int value)
    {
        if (this.root == null) return;
        //target: 待删除节点
        Node target = this.root.search(value);
        if (target == null) return;
        //待删除节点是根节点
        if (this.root.left == null && this.root.right == null)
        {
            this.root = null;
            return;
        }
        //待删除节点的父节点
        Node parent = this.root.searchParent(value);
        //1.先考虑删除叶子节点
        if (target.left == null && target.right == null)
        {
            //判断target是parent的左节点还是右节点
            if (parent.left != null && parent.left.value == value) parent.left = null;
            else if (parent.right != null && parent.right.value == value)
                parent.right = null;
        }else if (target.left != null && target.right != null){
            //2.待删除的接待既有左子树又有右子树
            int minV = delRightMin(target.right);
            target.value = minV;

        }else{//3.如果待删除的节点只有左子树或者右子树
            //如果删除的节点只有左子树
            if (target.left != null) {
                //如果target是parent左子节点
                //此处在删除最后两个节点时,当先删除根节点时会出现parent为空的情况
                if (parent != null){
                    if (parent.left.value == value) parent.left = target.left;
                    else parent.right = target.left;
                }else root = target.left;
            }else{//待删除节点只有右子树
                if (parent != null) {
                    if (parent.left.value == value) parent.left = target.right;
                    else parent.right = target.right;
                }else root = target.right;
            }
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点
    public void add(Node node)
    {
        if (node == null) return;
        if (this.value > node.value) {
            if (this.left == null) this.left = node;
            else this.left.add(node);
        }
        else {
            if (this.right == null) this.right = node;
            else this.right.add(node);
        }
    }

    /**
     * 查询待删除节点
     * @param value 待删除节点的值
     * @return 待删除的节点
     */
    public Node search(int value)
    {
        if (this.value == value) return this;
        else if (this.value > value){
            if (this.left != null) return this.left.search(value);
            else return null;
        }else{
            if (this.right != null) return this.right.search(value);
            else return null;
        }
    }

    /**
     * 查询待删除节点的父节点
     * @param value 待删除节点的值
     * @return 待删除节点的父节点
     */
    public Node searchParent(int value)
    {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value))
            return this;
        else
        {
            if (this.left != null && this.value > value)
                return this.left.searchParent(value);
            else if (this.right != null && this.value <= value)
                return this.right.searchParent(value);
            else return null;
        }

    }

    //中序遍历
    public void infixOrder()
    {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }
}

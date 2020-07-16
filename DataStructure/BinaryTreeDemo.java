package edu.fzu.tree;

/**
 * @author johnrambo
 * @create 2020-07-16 16:55
 */
public class BinaryTreeDemo {

    //二叉树的前中后遍历-递归
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);

//        System.out.println("前序遍历:");
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历:");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历:");
//        binaryTree.postOrder();

        System.out.println("前序查找");
        HeroNode node = binaryTree.postOrderSearch(6);
        System.out.println(node);


    }
}

//定义一个二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder()
    {
        if (this.root != null) this.root.preOrder();
        else System.out.println("二叉树为空,无法遍历");
    }

    //中序遍历
    public void infixOrder()
    {
        if (this.root != null) this.root.infixOrder();
        else System.out.println("二叉树为空,无法遍历");
    }

    //后序遍历
    public void postOrder()
    {
        if (this.root != null) this.root.postOrder();
        else System.out.println("二叉树为空,无法遍历");
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no)
    {
        if (root != null) return this.root.preOrderById(no);
        else return null;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no)
    {
        if (this.root != null) return this.root.infixOrderById(no);
        else return null;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no)
    {
        if (this.root != null) return this.root.postOrderById(no);
        else return null;
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder()
    {
        //先输出父节点
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    //中序遍历
    public void infixOrder()
    {
        //递归向左子树遍历
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    //后序遍历
    public void postOrder()
    {
        if (this.left != null) this.left.postOrder();
        if (this.right != null) this.right.postOrder();
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderById(int no)
    {
        HeroNode res = null;
        if (this.no == no) return this;
        if (this.left != null) res = this.left.preOrderById(no);
        if (res != null) return res;
        if (this.right != null) res = this.right.preOrderById(no);
        return res;
    }

    //中序遍历查找
    public HeroNode infixOrderById(int no)
    {
        HeroNode res = null;
        if (this.left != null) res = this.left.infixOrderById(no);
        if (res != null) return res;
        if (this.no == no) return this;
        if (this.right != null) res = this.right.infixOrderById(no);
        return res;
    }

    //后序遍历查找
    public HeroNode postOrderById(int no)
    {
        HeroNode res = null;
        if (this.left != null) res = this.left.postOrderById(no);
        if (res != null) return res;
        if (this.right != null) res = this.right.postOrderById(no);
        if (res != null) return res;
        if (this.no == no) return this;
        else return null;
    }
}

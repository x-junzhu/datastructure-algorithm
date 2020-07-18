package edu.fzu.tree;

/**
 * @author johnrambo
 * @create 2020-07-17 13:45
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {
        //测试中序线索二叉树功能
        ThreadedBinaryTree tbt = new ThreadedBinaryTree();

        Node node1 = new Node(1, "tom");
        Node node2 = new Node(3, "jack");
        Node node3 = new Node(6, "smith");
        Node node4 = new Node(8, "marry");
        Node node5 = new Node(10, "king");
        Node node6 = new Node(14, "dim");

        //中序遍历: 8 3 10 1 14 6
        tbt.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        tbt.threadedNode(node1);
//        System.out.println(node5.getLeft());
//        System.out.println(node5.getRight());
        System.out.println("遍历中序线索二叉树:");
        tbt.threadedList();
    }
}

//定义一个线索化二叉树
class ThreadedBinaryTree{
    private Node root;

    //pre总是保留前一个节点
    private Node pre = null;

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 中序线索化二叉树
     * @param node
     */
    public void threadedNode(Node node)
    {
        if (node == null) return;

        //1.先线索化左子树
        threadedNode(node.getLeft());

        //2.然后线索化当前节点
        //2.1先处理当前节点的前驱节点
        if (node.getLeft() == null)
        {
            //左子树为空,则左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型
            node.setLeftType(1);
        }

        //2.2处理后继节点
        if (pre != null && pre.getRight() == null)
        {
            //让后继节点指向当前节点
            pre.setRight(node);
            //修改前驱节点右指针类型
            pre.setRightType(1);
        }
        //每次处理一个节点后,让当前节点是下一个节点的前驱节点
        pre = node;

        //3.最后线索化右子树
        threadedNode(node.getRight());
    }

    //遍历中序线索二叉树
    public void threadedList()
    {
        //定义一个存储当前遍历的节点
        Node node = root;
        while (node != null)
        {
            //循环找出leftType=1的节点,后面会随着遍历的变化而变化
            //说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType() == 0) node = node.getLeft();
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针 指向的是后继节点,就一直输出
            while (node.getRightType() == 1)
            {
                node = node.getRight();
                System.out.println(node);
            }
            //当前节点的后继节点rightType!=1时
            node = node.getRight();
        }
    }

}


class Node{
    private int no;
    private String name;
    private Node left;
    private Node right;

    //leftType=0表示指向左子树,1指向前驱节点
    private int leftType;
    //rightType=0表示指向右子树,1指向后继节点
    private int rightType;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}


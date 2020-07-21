package edu.fzu.avl;

/**
 * @author johnrambo
 * @create 2020-07-20 16:21
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};//测试左旋转
//        int[] arr = {10, 12, 8, 9, 7, 6};//测试右旋转
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建一个AVL树
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++)
            avlTree.createBinarySortTree(new Node(arr[i]));

        System.out.println("中序遍历");
        avlTree.showBinarySortTree();

        System.out.println("在平衡处理后···");
        System.out.println("AVL树的高度=" + avlTree.getRoot().height());
        System.out.println("AVL左子树的高度=" + avlTree.getRoot().leftHeight());
        System.out.println("AVL右子树的高度=" + avlTree.getRoot().rightHeight());

        System.out.println("当前的根节点=" + avlTree.getRoot());
        System.out.println("根节点的左节点=" + avlTree.getRoot().left);
        System.out.println("根节点的右节点=" + avlTree.getRoot().right);
    }
}

class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    //添加节点的方法
    public void createBinarySortTree(Node node)
    {
        if (root == null) root = node;
        else root.add(node);
    }

    //中序遍历
    public void showBinarySortTree()
    {
        if (root != null) root.infixOrder();
        else System.out.println("the root node is null");
    }

    //查找待删除的节点
    public Node search(int value)
    {
        if (root == null) return null;
        else return root.search(value);
    }

    //查找待删除节点的父节点
    public Node searchParent(int value)
    {
        if (root == null) return null;
        else return root.searchParent(value);
    }

    /**
     * 1.返回以node为根节点的二叉排序树的最小节点的值
     * 2.删除以node为根节点二叉排序树的最小节点
     * @param node 传入的节点node(当做二叉树的根节点)
     * @return 以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node)
    {
        Node target = node;
        //循环的查找左子树
        while (target.left != null) target = target.left;
        //此时的target就指向了最小节点值
        delNode(target.value);//删除最小节点
        return target.value;
    }

    //删除节点
    public void delNode(int value)
    {
        if (root == null) return;
        else
        {
            Node targetNode = search(value);
            if (targetNode == null) return;
            //如果我们发现targetNode没有父节点
            if (root.left == null && root.right == null)
            {
                root = null;
                return;
            }
            //查找targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null)
            {
                //判断targetNode是父节点的左边还是右边
                if (parent.left != null && parent.left.value == value) parent.left = null;
                else if (parent.right != null && parent.right.value == value)
                    parent.right = null;
            }else if (targetNode.left != null && targetNode.right != null) {
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            }else {//删除只有一颗子树的节点
                //如果要删除的节点有左子节点
                //这里是修改一个bug,当删除的节点只有root和一个左或右
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果targetNode是parent左子节点
                        if (parent.left.value == value) parent.left = targetNode.left;
                        else parent.right = targetNode.left;
                    } else {
                        root = targetNode.left;
                    }
                }else{//要删除的节点有右子节点
                    if (parent != null) {
                        if (parent.left.value == value) parent.left = targetNode.right;
                        else parent.right = targetNode.right;
                    }else root = targetNode.right;
                }
            }
        }
    }

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //返回左子树的高度
    public int leftHeight()
    {
        if (left == null) return 0;
        else return left.height();
    }

    //返回右子树的高度
    public int rightHeight()
    {
        if (right == null) return 0;
        else return right.height();
    }

    /**
     * 以当前节点为根节点树的高度
     * @return
     */
    public int height()
    {
        return Math.max(left == null? 0: left.height(), right == null? 0 :right.height()) + 1;
    }

    /**
     * 找到要删除的节点
     * @param value 待删除节点的值
     * @return 待删除的节点
     */
    public Node search(int value)
    {
        if (value == this.value) return this;
        else if (value < this.value)
        {
            if (this.left == null) return null;
            return this.left.search(value);
        }
        else {
            //待查找的值大于等于当前节点的值,则递归向右查找
            if (this.right == null) return null;
            return this.right.search(value);
        }
    }

    /**
     * 查找待删除节点的父节点
     * @param value 待删除的节点值
     * @return 待删除节点的父节点
     */
    public Node searchParent(int value)
    {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value))
            return this;
        else
        {
            //如果查找的节点小于当前节点的值, 并且当前节点的左子节点不为空
            if (value < this.value && this.left != null)
                return this.left.searchParent(value);
            else if (value >= this.value && this.right != null)
            {
                return this.right.searchParent(value);
            }
            else return null;//没有找到父节点,即为根节点
        }
    }

    //添加节点的方法
    public void add(Node node)
    {
        if (node == null) return;

        //判断传入的节点值,和当前子树的根节点值得关系
        if (node.value < this.value)
        {
            if (this.left == null) this.left = node;
            else this.left.add(node);
        }
        else
        {
            if (this.right == null) this.right = node;
            else this.right.add(node);
        }

        //当添加完一个节点后, 如果: 右子树的高度-左子树的高度 > 1, 左旋转
        if (rightHeight() - leftHeight() > 1)
        {
            //如果它的右子树的左子树高度大于它的右子树的高度
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight())
            {
                //先对当前节点的右子树, 右旋转
                right.rightRotate();
                //再对当前节点进行左旋转
                leftRotate();
            }else leftRotate();
            return;//处理完就结束
        }

        //当添加完一个节点后,如果:左子树的高度-右子树的高度 > 1, 右旋转
        if (this.leftHeight() - this.rightHeight() > 1)
        {
            //如果它的左子树的右子树高度大于它的左子树的高度
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight())
            {
                //先对当前节点的左子树, 左旋转
                left.leftRotate();
                //再对当前节点进行右旋转
                rightRotate();
            }else rightRotate();
        }
    }

    //中序遍历二叉树
    public void infixOrder()
    {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }

    //左旋转
    private void leftRotate()
    {
        //创建新的节点, 以当前根节点的值
        Node newNode = new Node(this.value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = this.left;
        //把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = this.right.left;
        //把当前节点的值替换成右子节点的值
        this.value = this.right.value;
        //把当前节点的右子树设置成右子树的右子树
        this.right = this.right.right;
        //把当前节点的左子节点设置成新的节点
        this.left = newNode;
    }

    //右旋转
    private void rightRotate()
    {
        Node newNode = new Node(this.value);
        newNode.right = right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }
}


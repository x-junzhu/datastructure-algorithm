package edu.fzu.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @author johnrambo
 * @create 2020-07-18 17:29
 */
public class HuffmanCode {

    public static void main(String[] args) {

        //测试压缩文件
//        String src = "D://myfile//1.png";
//        String dest = "D://myfile//dest.zip";
//        zipFile(src, dest);
//        System.out.println("压缩完成");
        //测试解压文件
        String scr = "D://myfile//dest.zip";
        String dest = "D://myfile//test2.bmp";
        unzipFile(scr, dest);
        System.out.println("解压成功");

        /*
        String str = "i like like like java do you like a java";
        byte[] contentsBytes = str.getBytes();//40

        byte[] bytes = huffmanZip(contentsBytes);
        System.out.println("压缩后的结果是=" + Arrays.toString(bytes));

        byte[] source = decode(huffmanCodes, bytes);
        System.out.println("原来的字符串=" + new String(source));

         */
        /*
        List<Node> nodes = getNodes(contentsBytes);

        Node root = createHuffmanTree(nodes);
        preOrder(root);

        Map<Byte, String> codes = getCodes(root);
        System.out.println("--生成的哈夫曼编码表" + huffmanCodes);

        byte[] huffmanCodeBytes = zip(contentsBytes, codes);
        System.out.println("huffmanCode=" + Arrays.toString(huffmanCodeBytes));
        */
        
    }

    /**
     * 解压文件
     * @param zipFile 待解压文件
     * @param destFile 解压的到的路径
     */
    public static void unzipFile(String zipFile, String destFile)
    {
        //定义一个文件输入流
        InputStream is = null;
        //定义个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try{
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组
            byte[] huffmanBytes = (byte[])ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            //将bytes数组写入到目标文件
            os = new FileOutputStream(destFile);
            os.write(bytes);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (os != null) os.close();
                if (ois != null) ois.close();
                if (is != null) is.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 对文件进行压缩
     * @param srcFile 待压缩文件路径
     * @param destFile 压缩后文件的存放路径
     */
    public static void zipFile(String srcFile, String destFile)
    {
        //创建输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            //创建文件的输入流
            fis = new FileInputStream(srcFile);
            //创建一个源文件大小一样的数组
            byte[] b = new byte[fis.available()];
            //读取文件
            fis.read(b);
            //直接对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流,用于存放压缩后的文件
            fos = new FileOutputStream(destFile);
            //创建一个和文件关联的ObjectOutputStream
            oos = new ObjectOutputStream(fos);
            //以对象流的方式写入,为了以后恢复源文件使用
            oos.writeObject(huffmanBytes);
            //以对象流的方式吧赫夫曼编码也写入文件中,用于恢复文件使用
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    完成数据的解压
    1.将huffmanCodeBytes转成二进制字符串
    2.再将二进制字符串对照哈夫曼编码转成原本的字符串
     */

    /**
     * 完成压缩数据的解码
     * @param huffmanCodes 赫夫曼编码表
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 返回原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes)
    {
        //1.先得到huffmanBytes对应的二进制字符串
        StringBuilder sb = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++)
        {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            sb.append(byteToBitString(!flag, b));
        }

//        System.out.println("赫夫曼字节数组对应的二进制字符串" + sb.toString());
        //按照指定的赫夫曼编码表进行解码
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry: huffmanCodes.entrySet())
        {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); )
        {
            //这里i是一个索引,扫描sb
            int count = 1;//计数器
            boolean flag = true;
            Byte b = null;

            while (flag)
            {
                //取出一个'0'或者'1'
                //i不能动,让count移动,直到匹配到一个字符
                String key = sb.substring(i, i + count);
                b = map.get(key);
                if (b == null) count++;//因为编码是变长的b是空说明没有匹配到
                else flag = false;
            }
            list.add(b);
            i += count;//匹配到一个字符后i移动到下一个编码的位置
        }
        //当for循环结束后,list中存放了所有的字符
        //最后把list中的数据存放到byte[]并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转成二进制字符串
     * @param flag 表示是否需要补高位如果是true,则需要高位
     * @param b 传入的byte
     * @return 是该b对应的二进制字符串(按补码返回)
     */
    private static String byteToBitString(boolean flag, byte b)
    {
        int temp = b;//将b转成int
        //如果是整数还需要补位
        if (flag) temp |= 256;//按位与256, 高位补齐
        String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制补码
        if (flag) return str.substring(str.length() - 8);
        else return str;
    }

    /**
     * 使用一个方法,将所有用于哈夫曼编码的方法封装起来,便于调用
     * @param bytes 原始的字符串对应的字节数组
     * @return 哈夫曼编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes)
    {
        List<Node> nodes = getNodes(bytes);
        //创建哈夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        //生成对应的哈夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
        //根据生成的哈夫曼编码,压缩得到压缩后的哈夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    public static void preOrder(Node root) {
        if (root != null) root.showHuffmanTree();
        else System.out.println("the root node is null, please input again");
    }

    //生成哈夫曼树对应的哈夫曼编码
    /*
    1.将哈夫曼编码放在Map<Byte, String>,形如32->01, 97->100等等
    2.生成哈夫曼编码中需要拼接路径定义一个StringBuilder
     */
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    //为了调用方便,这里重载一下
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) return null;
        getCodes(root.left, "0", sb);
        getCodes(root.right, "1", sb);

        return huffmanCodes;
    }

    /**
     * 将传入的node节点的所有叶子节点的哈夫曼编码得到,并放入到huffmanCodes集合
     *
     * @param node 传入的节点
     * @param code 路径左边0,右边是1
     * @param sb   用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder stringBuilder2 = new StringBuilder(sb);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null)//非叶子节点
            {
                //向左递归处理
                getCodes(node.left, "0", stringBuilder2);
                //向右递归处理
                getCodes(node.right, "1", stringBuilder2);
            } else//叶子节点
            {
                //表示找到叶子节点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }


    /**
     * 字符串对应的byte[]数组,通过生成的哈夫曼编码表返回哈夫曼编码压缩后的byte[]
     * @param bytes 这里原始的字符串对应的byte[]
     * @param huffmanCodes huffmanCodes生成的哈夫曼编码map集合
     * @return 返回哈夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes)
    {
        //1.利用huffmanCodes将bytes转成哈夫曼编码对应的字符串
        StringBuilder sb = new StringBuilder();
        //遍历bytes数组
        for (byte b: bytes) sb.append(huffmanCodes.get(b));

        //将得到的sb字符串,转成byte[]
        int len;
        if (sb.length() % 8 == 0) len = sb.length() / 8;
        else len = sb.length() / 8 + 1;
        //创建存储压缩后的byte[]数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; //记录是第几个byte
        for (int i = 0; i < sb.length(); i += 8)
        {
            //这里每8位对应一个byte
            String strByte;
            if (i + 8 > sb.length()) strByte = sb.substring(i);//sb不一定是8的整数倍
            else strByte = sb.substring(i, i + 8);
            //将strByte转成byte放入huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    public static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        //存储每个byte出现的次数使用map存储
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            //根据传入的bytes数组构建map集合
            Integer count = counts.get(b);
            if (count == null) counts.put(b, 1);
            else counts.put(b, count + 1);
        }

        //把每一键值对转成一个Node对象,并加入nodes集合中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(null, leftNode.weight + rightNode.weight);

            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }

        return nodes.get(0);
    }
}

//节点
class Node implements Comparable<Node> {
    Byte data;//存放数据本身, 'a'=97, ' '=32
    Integer weight;//数据中字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight.compareTo(o.weight);
    }

    //前序遍历
    public void showHuffmanTree() {
        if (this.left == null && this.right == null) System.out.println(this);
        if (this.left != null) this.left.showHuffmanTree();
        if (this.right != null) this.right.showHuffmanTree();
    }
}

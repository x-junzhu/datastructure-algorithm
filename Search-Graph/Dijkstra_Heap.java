package edu.fzu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author johnrambo
 * @create 2020-07-31 9:24
 */
public class Dijkstra_Heap {

    public static int N = 1000010, INF = 0x3f3f3f3f;

    public static int idx;
    public static int[] e = new int[N];
    public static int[] h = new int[N];
    public static int[] ne = new int[N];
    public static int[] w = new int[N];

    public static int[] dist = new int[N];
    public static boolean[] stk = new boolean[N];

    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = br.readLine().split(" ");
        n = Integer.parseInt(fLine[0]);
        m = Integer.parseInt(fLine[1]);

        Arrays.fill(h, -1);

        for (int i = 0; i < m; i++)
        {
            String[] sLine = br.readLine().split(" ");
            int x = Integer.parseInt(sLine[0]);
            int y = Integer.parseInt(sLine[1]);
            //x->y的权重
            int w = Integer.parseInt(sLine[2]);
            insert(x, y, w);
        }

        System.out.println(dijkstra());
    }

    public static void insert(int x, int y, int z)
    {
        e[idx] = y;
        w[idx] = z;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static int dijkstra()
    {
        Arrays.fill(dist, INF);
        PriorityQueue<MyPair> heap = new PriorityQueue<>();

        dist[1] = 0;
        heap.add(new MyPair(0, 1));

        while (!heap.isEmpty())
        {
            MyPair t = heap.poll();
            int cur = t.getSecond();//表示当前节点
            int d = t.getFirst();//表示1到节点cur的最短距离

            if (stk[cur]) continue;

            stk[cur] = true;

            for (int i = h[cur]; i != -1; i = ne[i])
            {
                int j = e[i];
                if (dist[j] > d + w[i]) {
                    dist[j] = d + w[i];
                    heap.add(new MyPair(dist[j], j));
                }
            }
        }

        if (dist[n] == INF) return -1;
        return dist[n];
    }
}

class MyPair implements Comparable<MyPair>{

    //表示1到节点first的最短距离
    private Integer first;
    //表示第i个节点
    private Integer second;

    public MyPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public int compareTo(MyPair o) {
        return Integer.compare(this.first, o.first);
    }
}

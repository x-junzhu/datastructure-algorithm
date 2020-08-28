package edu.fzu.lc;

/**
 * @author johnrambo
 * @create 2020-08-28 8:49
 */
public class RobotMovingCount {

    public static final int N = 210;
    public static Pair[] q = new Pair[N];
    public static boolean[][] stk = new boolean[N][N];

    public static void main(String[] args) {
        RobotMovingCount rbmc = new RobotMovingCount();
        int count = rbmc.movingCount(3, 2, 17);
        System.out.println(count);

    }

    /**
     * 带有障碍的广度优先搜索
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        int hh = 0, tt = 0;
        int count = 1;
        q[0] = new Pair(0, 0);
        stk[0][0] = true;
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        while (hh <= tt)
        {
            Pair t = q[hh++];
            for (int i = 0; i < 2; i++)
            {
                int x = t.getFirst() + dx[i];
                int y = t.getSecond() + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && stk[x][y] == false && get(x) + get(y) <= k)
                {
                    q[++tt] = new Pair(x, y);
                    stk[x][y] = true;
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * 获取数字x的所有位之和
     * @param x
     * @return
     */
    private int get(int x)
    {
        int res = 0;
        for (; x != 0; x /= 10)
        {
            res += x % 10;
        }
        return res;
    }
}

class Pair{

    Integer first;
    Integer second;

    public Pair(Integer first, Integer second) {
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
}

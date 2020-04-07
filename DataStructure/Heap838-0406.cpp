#include <iostream>
using namespace std;

const int N = 100010;

int n, m, len;
int h[N];

void down(int u)
{
    int t = u;
    //在左孩子，右孩子两个节点中找出最小的往父节点上放
    if(2 * u < len && h[t] > h[2 * u]) t = 2 * u;
    if(2 * u + 1 < len && h[t] > h[2 * u + 1]) t = 2 * u + 1;
    if(t != u)
    {
        swap(h[t], h[u]);
        down(t);
    }
}

void up(int u)
{
    while(u / 2 && h[u] < h[u / 2])
    {
        swap(h[u], h[u / 2]);
        u /= 2;
    }
}

int main()
{
    scanf("%d%d", &n, &m);

    //堆中从下标从1开始，为了方便找到儿子节点
    for(int i = 1; i <= n; i++) scanf("%d", &h[i]);
    
    //堆的初始化
    for(int i = n / 2; i; i--) down(i);
    len = n;
    while(m--)
    {
        printf("%d ", h[1]);
        //输出堆顶元素后，将最后一个元素放在堆顶，然后堆总大小减1，继续从堆顶开始down
        h[1] = h[len];
        len--;
        down(1);
    }
    system("pause");
    return 0;
}
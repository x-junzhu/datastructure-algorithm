#include <iostream>
using namespace std;

const int N = 100010;

int n, k;
int a[N], q[N], hh, tt;

int main()
{
    scanf("%d%d", &n, &k);
    hh = 0, tt = -1;
    for(int i = 0; i < n; i++) scanf("%d", &a[i]);

    for(int i = 0; i < n; i++)
    {
        //判断滑动窗口大小是否为k
        if(hh <= tt && i - k + 1 > q[hh]) hh++;

        //只要队尾元素比当前的元素大,则队尾元素就不可能作为滑动窗口的最小值输出,从队尾删除即可
        while(hh <= tt && a[q[tt]] >= a[i]) tt--;
        q[++tt] = i;

        //只要i比滑动窗口大了,即可以开始输出
        if(i >= k - 1) printf("%d ", a[q[hh]]);
    }
    puts("");
    hh = 0, tt = -1;
    for(int i = 0; i < n; i++)
    {
        if(hh <= tt && i - k + 1 > q[hh]) hh++;
        while(hh <= tt && a[q[tt]] <= a[i]) tt--;
        q[++tt] = i;
        if(i >= k - 1) printf("%d ", a[q[hh]]);
    }
    puts("");
    system("pause");
    return 0;
}
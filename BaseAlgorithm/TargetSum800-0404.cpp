#include <iostream>
using namespace std;

const int N = 100010;

int n, m, x;
int a[N], b[N];

int main()
{
    scanf("%d%d%d", &n, &m, &x);
    for(int i = 0; i < n; i++) scanf("%d", &a[i]);
    for(int i = 0; i < m; i++) scanf("%d", &b[i]);
    /*
    用二分搜索代替一重循环使得算法的时间复杂度降到nlogn
    x - a[i]为第二个数组中待查找的数值
    */
    for(int i = 0; i < n; i++)
    {
        int l = 0, r = m - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(b[mid] >= x - a[i]) r = mid;
            else l = mid + 1;
        }
        if(a[i] + b[l] == x)
        {
            printf("%d %d\n", i, l);
        }
    }
    return 0;
}
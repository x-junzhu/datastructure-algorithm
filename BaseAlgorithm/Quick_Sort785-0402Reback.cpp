#include <iostream>

using namespace std;

const int N = 1e6 + 10;

int n;
int q[N];

/*快速排序
i, j 两个指针分别指向头和尾，相对运动，如果q[i]<x，则继续i+1,如果q[j]>x,则j+1
如果两个条件都不满足则将q[i]和q[j]交换位置,这样一次扫描完就将小于x的值都放在了x的
左边，大于x的值都放在了x的右边，即初始的x=q[l]位置固定，然后在递归的排左边和右边即可
*/
void quick_sort(int q[], int l, int r)
{
    if(l >= r) return;
    int x = q[l + r >> 1], i = l - 1, j = r + 1;
    while(i < j)
    {
        do i++; while(q[i] < x);
        do j--; while(q[j] > x);
        if(i < j) swap(q[i], q[j]);
    }
    quick_sort(q, l, j);
    quick_sort(q, j + 1, r);
}

int main()
{
    scanf("%d", &n);
    for(int i = 0; i < n; i++) scanf("%d", &q[i]);

    quick_sort(q, 0, n - 1);

    for(int i = 0; i < n; i++) printf("%d ", q[i]);
    return 0;
}
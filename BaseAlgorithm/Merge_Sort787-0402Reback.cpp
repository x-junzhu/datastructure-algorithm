#include <iostream>

using namespace std;

const int N = 100010;

int n, q[N], tmp[N];

/*归并排序
1.选取中间点下标作为分界点
2.递归的在左边进行排序，递归的在右边进行排序
3.此时以mid为分界点的左右两边均有序，需要借助一个额外数组，将左右两端的数值依次
	存入原数组；即从[i-mid]和[j-r]比较q[i]与q[j]小，小的先放入临时数组，直到一个序列
	遍历完，然后另一个序列的下一个值就比当前已经遍历完的序列最后一个值大，最后就剩下的这
	个序列依次放入原数组即可.
*/
void merge_sort(int q[], int l, int r)
{
    if(l >= r) return;
    int mid = l + r >> 1;
    merge_sort(q, l, mid);
    merge_sort(q, mid + 1, r);

    int i = l, j = mid + 1, k = 0;
    while(i <= mid && j <= r)
    {
        if(q[i] <= q[j]) tmp[k++] = q[i++];
        else tmp[k++] = q[j++];
    }

    while(i <= mid) tmp[k++] = q[i++];
    while(j <= r) tmp[k++] = q[j++];

    for(i = l, k = 0; i <= r; i++, k++) q[i] = tmp[k];
}

int main()
{
    scanf("%d", &n);
    for(int i = 0; i < n; i++) scanf("%d", &q[i]);

    merge_sort(q, 0, n - 1);

    for(int i = 0; i < n; i++) printf("%d ", q[i]);
    return 0;
}
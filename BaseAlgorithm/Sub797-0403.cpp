#include <iostream>
using namespace std;

const int N = 100010;

int n, m;
/*
数组a[N]是b[N]的前缀和
数组b[N]是a[N]的差分
即:b1 = a1
   b2 = a2 - a1
   b3 = a3 - a2
   ...
   b(n) = a(n) - a(n-1)
*/
int a[N], b[N];

/*
差分数组b[l] + c相当于a[N]从第l个数开始以后每个数加c
差分数组b[r + 1] - c相当于a[N]从第r + 1个数开始以后每个数减c
*/
void insert(int l, int r, int c)
{
    b[l] += c;
    b[r + 1] -= c;
}

int main()
{
    scanf("%d%d", &n, &m);
    for(int i = 1; i <= n; i++) scanf("%d", &a[i]);

    for(int i = 1; i <= n; i++) insert(i, i, a[i]);

    while(m--)
    {
        int l, r, c;
        scanf("%d%d%d", &l, &r, &c);
        insert(l, r, c);
    }

    for(int i = 1; i <= n; i++) b[i] += b[i - 1];

    for(int i = 1; i <= n; i++) printf("%d ", b[i]);
    system("pause");
    return 0;
}
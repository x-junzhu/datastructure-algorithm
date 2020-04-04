#include <iostream>
using namespace std;

const int N = 100010;

int n, a[N];
/*
10的二进制: 0000 1010
-10的二进制:1111 0110
两数相与即可得低位第一个二进制1
*/
int lowbit(int x)
{
    return x & -x;
}

int main()
{
    scanf("%d", &n);
    while(n--)
    {
        int x, res = 0;
        scanf("%d", &x);
        while(x)
        {
            x -= lowbit(x);
            res++;
        }
        printf("%d ", res);
    }
    return 0;
}
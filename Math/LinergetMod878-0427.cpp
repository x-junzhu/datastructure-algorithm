#include <iostream>

using namespace std;

typedef long long LL;

/*
线性同余方程：a*x = b mod m 即a*x mod m = b => 
存在y,a*x = m*y + b与扩展欧几里得算法相似ax+by=gcd(a, b)=d 
*/

int exgcd(int a, int b, int &x, int &y)
{
    if(!b)
    {
        x = 1, y = 0;
        return a;
    }
    int d = exgcd(b, a % b, y, x);
    y -= a / b * x;
    return d;
}

int main()
{
    int n;
    scanf("%d", &n);
    while(n--)
    {
        int a, b, m;
        scanf("%d%d%d", &a, &b, &m);
        int x, y;
        int d = exgcd(a, m, x, y);
        if(b % d) puts("impossible");
        else printf("%d\n", (LL)x * (b / d) % m);

    }
    system("pause");
    return 0;
}
#include <iostream>

using namespace std;
/*
扩展欧几里得算法
裴蜀定理：对于任意的正整数a, b,一定存在非零整数x, y，使得ax + by = gcd(a, b)
推导过程：
=> (a, b) = (b, a % b)
① 当b = 0时， (a, 0) = a 即 a * x + 0 * y = a -> x = 1, y = 0
② 当b != 0时， by + (a % b)x = d = (a, b)
            => by + (a - a / b * b)x = d
            => 根据a和b将上式合并同类项得
            => ax + b(y - a / b * x) = d
            即： y = y - a / b * x
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
        int a, b, x, y;
        scanf("%d%d", &a, &b);
        exgcd(a, b, x, y);
        printf("%d %d\n", x, y);
    }
    return 0;
}
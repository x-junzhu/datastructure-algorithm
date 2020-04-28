#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;

/*
快速幂: a ^ k % p
4 ^ 3 % 10 = [4 ^ (2 ^ 0) *  4 ^ (2 ^ 1)] % 10
           = [4 ^ (2 ^ 0)] % 10 * [4 ^ (2 ^ 1)] % 10
具体流程：
① 先预处理出a ^ (2 ^ 0) mod p, a ^ (2 ^ 1) mod p, a ^ (2 ^ 2) mod p, ...,
a ^ (2 ^ t) mod p,(t <= logk),其中(2 ^ 0)+(2 ^ 1)+...+(2 ^ t)=k
② 再将k分解为二进制，然后就是类似于查表的形式，找出对应位是1的求余结果，相乘即得结果
*/
int qmi(int a, int k, int p)
{
    int res = 1;
    while(k)
    {
        if(k & 1) res = (LL)res * a % p;
        k >>= 1;
        a = (LL)a * a % p;
    }
    return res;
}

int main()
{
    int n;
    scanf("%d", &n);
    while(n--)
    {
        int a, k, p;
        scanf("%d%d%d", &a, &k, &p);
        printf("%d\n", qmi(a, k, p));
    }
    system("pause");
    return 0;
}
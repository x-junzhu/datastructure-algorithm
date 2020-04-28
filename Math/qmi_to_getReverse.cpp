#include <iostream>

using namespace std;

typedef long long LL;

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
        int a, p;
        scanf("%d%d", &a, &p);
        if(a % p) printf("%d\n", qmi(a, p - 2, p));
        else puts("impossible");
    }
    return 0;
}

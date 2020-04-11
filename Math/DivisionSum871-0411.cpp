#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <cstring>

using namespace std;

int n;

const int mod = 1e9 + 7;

typedef long long LL;

int main()
{
    scanf("%d", &n);
    unordered_map<int, int> primes;
    while(n--)
    {
        int x;
        
        scanf("%d", &x);
        for(int i = 2; i <= x / i; i++)
        {
            while(x % i == 0)
            {
                x /= i;
                primes[i]++;
            }
        }
        if(x > 1) primes[x]++;
    }

    /*接870 约数之和
    (p1 ^ 0 * p1 ^ 1 ... p1 ^ a1) * (p2 ^ 0 * p2 ^ 1 ... p2 ^ a2)...(pk ^ 0 * pk ^ 1 ... pk ^ ak)
    */
    LL res = 1;
    for(auto item: primes)
    {
        LL t = 1;
        int p = item.first, b = item.second;
        while(b--) t = (t * p + 1) % mod;
        res  = res * t % mod;
    }

    cout << res << endl;
    system("pause");
    return 0;
}
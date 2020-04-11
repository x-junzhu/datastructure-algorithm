#include <iostream>
#include <algorithm>
#include <cstring>
#include <unordered_map>

using namespace std;

int n;

typedef long long LL;

const int mod = 1e9 + 7;

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
    LL res = 1;
    /*
    N = p1 ^ a1 * p2 ^ a2...pk ^ ak
    N的约数个数(a1 + 1) * (a2 + 1) * ... * (ak + 1)
    例如:N = 2 * 6 * 8
         N = (2 ^ 5) * (3 ^ 1) 则N的约数个数为(5 + 1) * (1 + 1) = 12
     */
    for(auto item: primes) res = res * (item.second + 1) % mod;
    cout << res << endl;
    return 0;
}
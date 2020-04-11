#include <iostream>
using namespace std;

const int N = 100010;

int q, cnt;
int primes[N];
bool st[N];

void get_primes(int n)
{
    for(int i = 2; i <= n; i++)
    {
        if(st[i] == false) primes[cnt++] = i;
        for(int j = i + i; j <= n; j += i) st[j] = true;
    }
}

int main()
{
    scanf("%d", &q);
    get_primes(q);

    cout << cnt << endl;
    system("pause");
    return 0;
}
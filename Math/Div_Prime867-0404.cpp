#include <iostream>
using namespace std;

int q;

void divide(int n)
{
    for(int i = 2; i <= n / i; i++)
        if(n % i == 0)
        {
            int s = 0;
            while(n % i == 0)
            {
                n /= i;
                s++;
            }
            printf("%d %d\n", i, s);
        }
    if(n > 1) printf("%d %d\n", n, 1);
    puts("");
}

int main()
{
    scanf("%d", &q);
    while(q--)
    {
        int x;
        scanf("%d", &x);
        divide(x);
    }
    return 0;
}
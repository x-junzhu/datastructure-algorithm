#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int gcd(int a, int b)
{
    return b? gcd(b, a % b): a;
}

int main()
{
    int n;
    scanf("%d", &n);
    while(n--)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        cout << gcd(a, b) << endl;
    }
    system("pause");
    return 0;
}
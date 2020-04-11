#include <iostream>
using namespace std;

int n;

/*
质数(素数):大于1的数中,除了1和自身没有其他约数的数
i < x / i为什么不写成sqrt(x)或者i * i < x
1.因为每一次循环中都会运算sqrt(x),比较慢
2.i * i < x如果i比较接近int的最大表示数字，会出现i * i溢出的可能
*/
bool is_prime(int x)
{
    if(x < 2) return false;
    for(int i = 2; i <= x / i; i++)
    {
        if(x % i == 0) return false;
    }
    return true;
}

int main()
{
    scanf("%d", &n);
    while(n--)
    {
        int x;
        scanf("%d", &x);
        if(is_prime(x)) puts("Yes");
        else puts("No");
    }
    return 0;
}
#include <iostream>
using namespace std;

const int N = 100010;

int n;
int stk[N], tt;

/*单点栈:查找当前元素左边第一个比它小的元素
只要栈不空并且栈顶元素比当前元素大，则栈顶元素
不会作为当前元素左边第一个比它小的数，出栈
*/
int main()
{
    scanf("%d", &n);
    while(n--)
    {
        int x;
        scanf("%d", &x);
        while(tt && stk[tt] >= x) tt--;
        if(tt) cout << stk[tt] << ' ';
        else cout << -1 << ' ';

        stk[++tt] = x;
    }
    return 0;
}
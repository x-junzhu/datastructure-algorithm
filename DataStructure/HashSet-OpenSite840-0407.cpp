#include <iostream>
#include <cstring>
using namespace std;

const int N = 200003, INF = 0x3f3f3f3f;
int n, h[N];

//开放寻址法
int find(int x)
{
    int k = (x % N + N) % N;
    while(h[k] != INF && h[k] != x)
    {
        k++;
        if(k == N) k = 0;//如果找到最后一位还没有找到，那么从头再开始找
    }
    return k;
}

int main()
{
    scanf("%d", &n);
    memset(h, INF, sizeof h);
    char op[2];
    int x;
    while(n--)
    {
        scanf("%s%d", op, &x);
        int k = find(x);
        if(op[0] == 'I') h[k] = x;
        else
        {
            if(h[k] != INF) puts("Yes");
            else puts("No");
        }    
    }
    return 0;
}
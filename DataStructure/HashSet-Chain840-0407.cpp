#include <iostream>
#include <cstring>
using namespace std;

const int N = 100003;

//拉链法
int idx, e[N], h[N], ne[N], m;

//具有相同余数的数字存储到同一条链中
void insert(int x)
{
    int k = (x % N + N) % N;
    e[idx] = x;
    ne[idx] = h[k];
    h[k] = idx++;
}

bool query(int x)
{
    int k = (x % N + N) % N;
    for(int i = h[k]; i != -1; i = ne[i])
        if(e[i] == x) 
            return true;
    return false;
}

int main()
{
    scanf("%d", &m);
    memset(h, -1, sizeof h);

    //定义op[2]吃掉可能多于的字符
    char op[2];
    int x;
    while(m--)
    {
        cin >> op >> x;
        if(op[0] == 'I') insert(x);
        else 
        {
            if(query(x)) puts("Yes");
            else puts("No");
        }
    }
    return 0;
}
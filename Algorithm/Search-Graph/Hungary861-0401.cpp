#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510, M = 100010;

int idx, h[N], e[M], ne[M];

int n1, n2, m;

//match[i] = j 表示第i个女生和第j个男生好上了
int match[N];

//st[i] = true表示第i个女生已经有对象了
bool st[N];

void insert(int a, int b)
{
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}

int find(int x)
{
    for(int i = h[x]; i != -1; i = ne[i])
    {
        //i表示男生，j就表示女生
        int j = e[i];
        if(st[j] == false)
        {
            st[j] = true;
            //如果第j个女生没有对象或者第j个女生还有下一个备胎
            if(match[j] == 0 || find(match[j]))
            {
                match[j] = x;
                return true;
            }
        }
    }
    return false;
}

int main()
{
    scanf("%d%d%d", &n1, &n2, &m);
    memset(h, -1, sizeof h);

    while(m--)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        insert(a, b);
    }

    int res = 0;
    for(int i = 1; i <= n1; i++)
    {
        memset(st, false, sizeof st);
        if(find(i)) res++;
    }

    printf("%d\n", res);
}
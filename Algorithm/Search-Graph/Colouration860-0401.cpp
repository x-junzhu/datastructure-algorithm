#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010, M = 200010;

int n, m;
int h[N], e[M], ne[M], idx;
int color[N];

void insert(int k, int b)
{
    e[idx] = b;
    ne[idx] = h[k];
    h[k] = idx++;
}

//dfs若返回false表示染色过程中有矛盾发生
bool dfs(int u, int c)
{
    color[u] = c;
    for(int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if(color[j] == 0)
        {
            if(dfs(j, 3 - c) == false) return false;
        }
        else if(color[j] == c) return false;
    }
    return true;
}

int main()
{
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);

    while(m--)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        insert(a, b);
        insert(b, a);
    }
    //flag表示当前染色过程中是否有矛盾发生
    bool flag = true;

    for(int i = 1; i <= n; i++)
    {
        if(color[i] == 0)
        {
            if(dfs(i, 1) == false)
            {
                flag = false;
                break;
            }
        }
    }

    if(flag) puts("Yes");
    else puts("No");
    return 0;
}
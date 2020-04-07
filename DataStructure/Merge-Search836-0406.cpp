#include <iostream>
using namespace std;

const int N = 100010;

int n, m;
/*p[x] = i表示节点x的父节点是i*/
int p[N];

//找到节点x的父节点,并进行路径压缩
int find(int x)
{
    if(p[x] != x) p[x] = find(p[x]);
    return p[x];
}

int main()
{
    scanf("%d%d", &n, &m);

    //此处规定只有p[x] = x才是根节点，用根节点编号代表整个集合
    for(int i = 1; i <= n; i++) p[i] = i;

    char op[2];
    while(m--)
    {
        cin >> op;
        int a, b;
        scanf("%d%d", &a, &b);
        if(op[0] == 'M') p[find(a)] = find(b);
        else 
        {
            if(find(a) == find(b)) puts("Yes");
            else puts("No");
        }
    }
    return 0;
}
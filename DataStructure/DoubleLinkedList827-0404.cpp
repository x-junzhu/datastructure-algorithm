#include <iostream>
using namespace std;

const int N = 100010;

int idx, e[N], l[N], r[N];
int n;

/*双链表初始化*/
void init()
{
    r[0] = 1, l[1] = 0;
    idx = 2;
}

/*双链表在第k个节点插入x*/
void insert(int k, int x)
{
    e[idx] = x;
    r[idx] = r[k];
    l[r[k]] = idx;
    l[idx] = k;
    r[k] = idx++;
}

/*双链表删除第k个节点后面的数*/
void remove(int k)
{
    l[r[k]] = l[k];
    r[l[k]] = r[k];
}

int main()
{
    scanf("%d", &n);
    string op;
    init();
    while(n--)
    {
        cin >> op;
        if(op[0] == 'L')
        {
            int x;
            scanf("%d", &x);
            insert(0, x);
        }
        else if(op[0] == 'R')
        {
            int x;
            scanf("%d", &x);
            insert(l[1], x);
        }
        else if(op[0] == 'D')
        {
            int k;
            scanf("%d", &k);
            remove(k + 1);
        }
        else if(op == "IL")
        {
            int k, x;
            scanf("%d%d", &k, &x);
            insert(l[k + 1], x);
        }
        else if(op == "IR")
        {
            int k, x;
            scanf("%d%d", &k, &x);
            insert(k + 1, x);
        }
    }
    for(int i = r[0]; i != 1; i = r[i]) cout << e[i] << ' ';
    cout << endl;
    return 0;
}
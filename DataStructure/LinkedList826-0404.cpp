#include <iostream>
using namespace std;

const int N = 100010;

int n;
/*
数组模拟单链表的存储结构
idx:当前可用的位置编号
head:头结点
e[i]:第i个节点保存的元素值
ne[i]:第i个节点的下一个节点位置
*/
int idx, head, e[N], ne[N];

/*初始化头结点指向空(-1)*/
void init()
{
    head = -1;
    idx = 0;
}

//向头结点后面插入x
void add_to_head(int x)
{
    e[idx] = x;
    ne[idx] = head;
    head = idx++;
}

//删除第k个节点
void remove(int k)
{
    ne[k] = ne[ne[k]];
}

//在第k个位置插入x
void insert(int k, int x)
{
    e[idx] = x;
    ne[idx] = ne[k];
    ne[k] = idx++;
}

int main()
{
    scanf("%d", &n);
    init();
    char op;
    while(n--)
    {
        cin >> op;
        if(op == 'H')
        {
            int x;
            scanf("%d", &x);
            add_to_head(x);
        }
        else if(op == 'D')
        {
            int k;
            scanf("%d", &k);
            if(k == 0) head = ne[head];
            remove(k - 1);
        }
        else
        {
            int k, x;
            scanf("%d%d", &k, &x);
            insert(k - 1, x);
        }
    }
    for(int i = head; i != -1; i = ne[i]) cout << e[i] << ' ';
    cout << endl;
    system("pause");
    return 0;
}
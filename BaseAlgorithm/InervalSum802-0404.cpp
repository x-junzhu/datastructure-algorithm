#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 100010;

typedef pair<int, int> PII;

int n, m;

vector<PII> add, query;

//a[N]原数组，s[N]是a[N]的前缀和数组
int a[N], s[N];
vector<int> alls;

int find(int x)
{
    int l = 0, r = alls.size() - 1;
    while(l < r)
    {
        int mid  = l + r >> 1;
        if(alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return r + 1;
}

int main()
{
    scanf("%d%d", &n, &m);

    for(int i = 0; i < n; i++)
    {
        int x, c;
        scanf("%d%d", &x, &c);
        add.push_back({x, c});
        alls.push_back(x);
    }

    for(int i = 0; i < m; i++)
    {
        int l, r;
        scanf("%d%d", &l, &r);
        query.push_back({l, r});
        alls.push_back(l);
        alls.push_back(r);
    }

    //去重
    sort(alls.begin(), alls.end());
    alls.erase(unique(alls.begin(), alls.end()), alls.end());

    //预处理插入
    for(auto items: add)
    {
        int x = find(items.first);
        a[x] += items.second;
    }

    //处理前缀和
    for(int i = 1; i <= alls.size(); i++) s[i] += s[i - 1] + a[i];

    //询问
    for(auto items: query)
    {
        int l = find(items.first), r = find(items.second);
        printf("%d\n", s[r] - s[l - 1]);
    }
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 100010;

typedef pair<int, int> PII;

int n;
vector<PII> segs;

void inerval_merge(vector<PII> &segs)
{
    vector<PII> res;
    sort(segs.begin(), segs.end());
    int st = -2e9, ed = -2e9;
    for(auto item: segs)
    {
        if(ed < item.first)
        {
            if(ed != -2e9)
            {
                res.push_back({st, ed});
            }
            st = item.first;
            ed = item.second;
        }
        else ed = max(ed, item.second);
    }
    if(st != -2e9) res.push_back({st, ed});
    segs = res;
}

int main()
{
    scanf("%d", &n);
    while(n--)
    {
        int l, r;
        scanf("%d%d", &l, &r);
        segs.push_back({l, r});
    }
    inerval_merge(segs);
    printf("%d\n", segs.size());
    system("pause");
    return 0;
}
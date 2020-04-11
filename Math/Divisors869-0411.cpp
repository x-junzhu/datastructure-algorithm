#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;

vector<int> get_divisios(int x)
{
    vector<int> res;
    for(int i = 1; i <= x / i; i++)
    {
        if(x % i == 0)
        {
            res.push_back(i);
            if(i != x / i) res.push_back(x / i);//如果i^2=x，则只输入一个i到结果数组res
        }
    }
    sort(res.begin(), res.end());
    return res;
}

int main()
{
    scanf("%d", &n);
    while(n--)
    {
        int x;
        scanf("%d", &x);
        auto res = get_divisios(x);
        for(auto item: res) cout << item << ' ';
        cout << endl;
    }
    return 0;
}
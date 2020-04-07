#include <iostream>
using namespace std;

const int N = 100010;

/*tt队尾，hh队头初始tt = -1,判断队空条件是hh > tt*/
int q[N], tt, hh;
int n;

int main()
{
    scanf("%d", &n);
    string op;
    tt = -1;
    while(n--)
    {
        cin >> op;
        if(op == "push")
        {
            int x;
            scanf("%d", &x);
            q[++tt] = x;
        }
        else if(op == "pop") hh++;
        else if(op == "query") cout << q[hh] << endl;
        else if (op == "empey") cout << (hh > tt? "Yes": "No") << endl;
    }
    return 0;
}
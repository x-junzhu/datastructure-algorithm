#include <iostream>
using namespace std;

const int N = 100010;

int n;

/*栈顶初始为0,tt指向栈顶元素，若tt < 1则表示栈空*/
int stk[N], tt;

int main()
{
    scanf("%d", &n);
    string op;
    while(n--)
    {
        cin >> op;
        if(op == "push")
        {
            int x;
            scanf("%d", &x);
            stk[++tt] == x;
        }
        else if(op == "pop") tt--;
        else if(op == "query") cout << stk[tt] << endl;
        else if(op == "empey") cout << (tt ? "No": "Yes") << endl;
    }
    return 0;
}
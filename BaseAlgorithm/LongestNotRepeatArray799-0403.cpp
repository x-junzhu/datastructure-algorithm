#include <iostream>
using namespace std;

const int N = 100010;

int n;

/*s[i]表示数i在数组a中的个数*/
int a[N], s[N];

int main()
{
    scanf("%d", &n);
    for(int i = 0; i < n; i++) scanf("%d", &a[i]);

    int res = 0;
    /*i, j指针初始都指向第一个元素，其中j指针表示离i最近的不重复元素*/
    for(int i = 0, j = 0; i < n; i++)
    {
        s[a[i]] ++;
        while(s[a[i]] > 1)
        {
            //j指针向后移动一位，同时也伴随着s[j]的个数减1
            s[a[j]]--;
            j++;
        }
        res = max(res, i - j + 1);
    }
    printf("%d\n", res);
    return 0;
}
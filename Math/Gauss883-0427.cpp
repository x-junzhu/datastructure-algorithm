#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

const int N = 110;

const double eps = 1e-6;

double a[N][N];
int n;

//高斯消元
int gauss()
{
    int c, r;
    for(c = 0, r = 0; c < n; c++)
    {
        int t = r;
        //1.找出当前行中首元素绝对值最大的一行
        for(int i = r; i < n; i++)
            if(fabs(a[i][c]) > fabs(a[t][c]))
                t = i;
        //如果当前列的元素为0则继续循环
        if(fabs(a[t][c]) < eps) continue;
        //2.将首元素绝对值最大的一行换到第一行
        for(int i = c; i <= n; i++) swap(a[t][i], a[r][i]);
        //3.将第一行的第一个元素变成1
        for(int i = n; i >= c; i--) a[r][i] /= a[r][c];
        //4.将下面所有行的第c列消为0
        for(int i = r + 1; i < n; i++)
            if(fabs(a[i][c]) > eps)
                for(int j = n; j >= c; j--)
                    a[i][j] -= a[r][j] * a[i][c];

        r++;
    }

    if(r < n)
    {
        for(int i = r; i < n; i++)
            if(fabs(a[i][n]) > eps)//等式左边为0,右边不为0
                return 2;//无解
        return 1;
    }

    for(int i = n - 1; i >= 0; i--)
        for(int j = i + 1; j < n; j++)
            a[i][n] -= a[i][j] * a[j][n];
    return 0;
}

int main()
{
    cin >> n;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n + 1; j++)
            cin >> a[i][j];

    int t = gauss();

    if(t == 0)
    {
        for(int i = 0; i < n; i++) printf("%.2lf\n", a[i][n]);
    }
    else if(t == 1) puts("Infinite group solutions");
    else puts("No solution");
    system("pause");
    return 0;
}
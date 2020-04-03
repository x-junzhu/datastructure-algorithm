#include <iostream>
using namespace std;

const int N = 1010;

int n, m, q;
/*
a[N][N]是原矩阵，是b[N][N]的前缀和
b[N][N]是差分矩阵,是a[N][N]的差分
*/
int a[N][N], b[N][N];

/*
b[x1][y1] += c表示从(x1,y1)~(xn, ym)的所有数都加上了c,即（x1, y1）的右下角.
对于差分数组/矩阵，不用事先构造，首先想象b[i][j] = 0,则a[i][j] = 0,然后再把各个元素逐个插入即可
*/
void insert(int x1, int y1, int x2, int y2, int c)
{
    b[x1][y1] += c;
    b[x2 + 1][y1] -= c;
    b[x1][y2 + 1] -= c;
    b[x2 + 1][y2 + 1] += c;
}

int main()
{
    scanf("%d%d%d", &n, &m, &q);

    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= m; j++)
        {
            scanf("%d", &a[i][j]);
            insert(i, j, i, j, a[i][j]);
        }
            
    while(q--)
    {
        int x1, y1, x2, y2, c;
        scanf("%d%d%d%d%d", &x1, &y1, &x2, &y2, &c);
        insert(x1, y1, x2, y2, c);
    }

    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= m; j++)
        {
            b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            printf("%d ", b[i][j]);
        }
        puts("");
    }
    return 0;
}
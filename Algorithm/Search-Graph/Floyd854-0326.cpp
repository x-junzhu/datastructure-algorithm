#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 210, INF = 1e9;

int n, m, Q;

/*d[i][j]表示i->j的最短距离*/
int d[N][N];

void floyd()
{
	/*k表示以k为过渡的中间点从i->j的最短距离*/
	for (int k = 1; k <= n; k++)
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
}

int main()
{
	scanf("%d%d%d", &n, &m, &Q);

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			if (i == j) d[i][j] = 0;
			else d[i][j] = INF;

	while (m--)
	{
		int a, b, w;
		scanf("%d%d%d", &a, &b, &w);

		/*去掉重边*/
		d[a][b] = min(d[a][b], w);
	}

	floyd();

	while (Q--)
	{
		int a, b;
		scanf("%d%d", &a, &b);
		if (d[a][b] > INF) puts("impossible");
		else printf("%d\n", d[a][b]);
	}
	return 0;
}
#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

const int N = 110;
typedef pair<int, int> PII;

int n, m;

/*g[N][N]保存的是迷宫*/
int g[N][N];

/*d[i][j]表示点(i, j)到起点的距离*/
int d[N][N];

/*
q[N * N]是一个保存了(i, j)坐标的队列
path[i][j]表示点(i, j)是由哪个点走过来的
*/
PII q[N * N], path[N][N];

int bfs()
{
	int hh = 0, tt = 0;
	q[0] = { 0, 0 };

	memset(d, -1, sizeof d);
	d[0][0] = 0;

	/*
	dx[i], dy[i]表示向四个方向(上，右，下，左)扩展，
	此时向下为x轴正方向，向右为y轴正方向
	*/
	int dx[4] = { -1, 0, 1, 0 }, dy[4] = { 0, 1, 0, -1 };

	while (hh <= tt)
	{
		auto t = q[hh++];
		for (int i = 0; i < 4; i++)
		{
			int x = t.first + dx[i], y = t.second + dy[i];
			/*判断坐标(x, y)是否出迷宫边界and 图中是否可通行and 该点是否已经走过*/
			if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1)
			{
				d[x][y] = d[t.first][t.second] + 1;
				path[x][y] = t;
				q[++tt] = { x, y };
			}
		}
	}
	/*逆序输出迷宫走出的路径*/
	int x = n - 1, y = m - 1;
	while (x || y)
	{
		cout << x << ' ' << y << endl;
		auto t = path[x][y];
		x = t.first, y = t.second;
	}
	return d[n - 1][m - 1];
}

int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			scanf("%d", &g[i][j]);

	cout << bfs() << endl;
	return 0;
}
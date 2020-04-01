#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;

int n, m;

/*邻接矩阵存储图*/
int g[N][N];

/*dist[N]集合表示当前已经在连通块的所有点*/
int dist[N];
bool st[N];

int prim()
{
	memset(dist, 0x3f, sizeof dist);

	/*当前的最短路径和*/
	int res = 0;
	for (int i = 0; i < n; i++)
	{
		int t = -1;
		/*查找所有节点到到"集合"中距离最短的点
		这里的集合是指当前已经在连通块中的所有点
		*/
		for (int j = 1; j <= n; j++)
		{
			if (st[j] == false && (t == -1 || dist[t] > dist[j]))
				t = j;
		}
		/*如果存在一个节点到"集合"的距离为INF，则此图为不连通图*/
		if (i && dist[t] == INF) return INF;
		if (i) res += dist[t];

		/*此时t是到集合距离最短的点，所以以t为出发点更新dist数组*/
		for (int j = 1; j <= n; j++) dist[j] = min(dist[j], g[t][j]);

		st[t] = true;
	}
	return res;
}

int main()
{
	scanf("%d%d", &n, &m);
	memset(g, 0x3f, sizeof g);

	while (m--)
	{
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		g[a][b] = g[b][a] = min(g[a][b], c);
	}
	int t = prim();
	if (t == INF) puts("impossible");
	else printf("%d\n", t);
	return 0;
}
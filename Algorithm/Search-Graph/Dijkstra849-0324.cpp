#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510;
int n, m;

/*邻接矩阵存储图*/
int g[N][N];
/*dist[i]表示从0->i的最短距离*/
int dist[N];
/*st[i]表示第i个节点已经确定最短距离*/
bool st[N];

int dijkstra()
{
	memset(dist, 0x3f, sizeof dist);

	/*第一个节点到本身的距离为0*/
	dist[1] = 0;

	for (int i = 0; i < n; i++)
	{
		/*t表示当前未确定最短距离、且距离当前节点最近的节点*/
		int t = -1;
		for (int j = 1; j <= n; j++)
			if (!st[j] && (t == -1 || dist[t] > dist[j]))
				t = j;

		st[t] = true;
		for (int j = 1; j <= n; j++)
			/*用0->t->j的最短距离更新0->j的距离*/
			dist[j] = min(dist[j], dist[t] + g[t][j]);
	}
	if (dist[n] == 0x3f3f3f3f) return -1;
	return dist[n];
}

int main()
{
	scanf("%d%d", &n, &m);
	memset(g, 0x3f, sizeof g);

	while (m--)
	{
		int a, b, w;
		scanf("%d%d%d", &a, &b, &w);
		g[a][b] = min(g[a][b], w);
	}

	printf("%d\n", dijkstra());
	return 0;
}
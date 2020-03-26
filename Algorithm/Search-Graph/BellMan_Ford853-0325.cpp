#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 510, M = 10010;

int n, m, k;
int dist[N];

/*backup[N]保证当前的最短路径是从上一个最短路径过来的*/
int backup[N];

/*结构体存储图*/
struct Edge
{
	int a, b, w;
}edges[M];

int bellman_ford()
{
	memset(dist, 0x3f, sizeof dist);

	dist[1] = 0;
	for (int i = 0; i < k; i++)
	{
		/*保证本次最短路径是从上一次的最短路径中过来的*/
		memcpy(backup, dist, sizeof dist);

		/*每一次循环都遍历整个图*/
		for (int j = 0; j < m; j++)
		{
			int a = edges[j].a, b = edges[j].b, w = edges[j].w;
			dist[b] = min(dist[b], backup[a] + w);
		}
	}
	if (dist[n] > 0x3f3f3f3f / 2) return -1;
	return dist[n];
}

int main()
{
	scanf("%d%d%d", &n, &m, &k);
	for (int i = 0; i < n; i++)
	{
		int a, b, w;
		scanf("%d%d%d", &a, &b, &w);
		edges[i] = { a, b, w };
	}
	int t = bellman_ford();
	if (t == -1) puts("impossible");
	else printf("%d\n", t);

	return 0;
}
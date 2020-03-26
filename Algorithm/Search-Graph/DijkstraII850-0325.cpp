#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 100010;
typedef pair<int, int> PII;

int n, m;

/*带权重的图的邻接表存储*/
int idx, e[N], w[N], ne[N], h[N];

bool st[N];

/*dist[i]表示从1->i的最短距离*/
int dist[N];

/*头插法*/
void insert(int x, int y, int c)
{
	e[idx] = y;
	w[idx] = c;
	ne[idx] = h[x];
	h[x] = idx++;
}

int dijkstra()
{
	memset(dist, 0x3f, sizeof dist);
	dist[1] = 0;

	/*优先队列:小根堆*/
	priority_queue<PII, vector<PII>, greater<PII>> hq;

	/*第一个结点入队*/
	hq.push({ 0, 1 });

	while (hq.size())
	{
		auto t = hq.top();
		hq.pop();

		int ver = t.second, distance = t.first;

		//if (st[ver]) continue;y总给的版本里写了st[N],仔细看了一下代码中并没有对该数组进行操作

		for (int i = h[ver]; i != -1; i = ne[i])
		{
			int j = e[i];
			if (dist[j] > distance + w[i])
			{
				dist[j] = distance + w[i];
				hq.push({ dist[j], j });
			}
		}
	}

	if (dist[n] == 0x3f3f3f) return -1;
	return dist[n];
}

int main()
{
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	while (m--)
	{
		int x, y, w;
		scanf("%d%d%d", &x, &y, &w);
		insert(x, y, w);
	}

	printf("%d\n", dijkstra());

	return 0;
}

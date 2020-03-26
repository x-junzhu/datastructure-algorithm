#include <cstring>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 100010;

int n, m;

/*带有权重的图的邻接表存储*/
int idx, e[N], ne[N], h[N], w[N];
int dist[N];
bool st[N];

/*头插法*/
void insert(int a, int b, int c)
{
	e[idx] = b;
	w[idx] = c;
	ne[idx] = h[a];
	h[a] = idx++;
}

/*带有边数限制的最短路径求解SPFA*/
int spfa()
{
	memset(dist, 0x3f, sizeof dist);
	dist[1] = 0;

	queue<int> q;
	q.push(1);
	st[1] = true;

	while (q.size())
	{
		int t = q.front();
		q.pop();
		st[t] = false;
		for (int i = h[t]; i != -1; i = ne[i])
		{
			int j = e[i];
			if (dist[j] > dist[t] + w[i])
			{
				dist[j] = dist[t] + w[i];
				if (!st[j])
				{
					q.push(j);
					st[j] = true;
				}
			}
		}
	}
	if (dist[n] == 0x3f3f3f3f) return -1;
	return dist[n];
}

int main()
{
	scanf("%d%d", &n, &m);

	memset(h, -1, sizeof h);
	while (m--)
	{
		int a, b, c;
		scanf("%d%d%d", &a, &b, &c);
		insert(a, b, c);
	}

	int t = spfa();

	if (t == -1) puts("impossible");
	else printf("%d\n", t);
	return 0;
}
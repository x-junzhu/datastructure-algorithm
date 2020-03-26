#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 100010;

int n, m;

/*带权重的图的邻接表存储*/
int idx, e[N], ne[N], w[N], h[N];

/*cnt[N]为统计当前节点个数*/
int dist[N], cnt[N];
bool st[N];

/*带权重的头插法*/
void insert(int a, int b, int c)
{
	e[idx] = b;
	w[idx] = c;
	ne[idx] = h[a];
	h[a] = idx++;
}

bool spfa()
{
	queue<int> q;

	for (int i = 1; i <= n; i++)
	{
		st[i] = true;
		q.push(i);
	}

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
				cnt[j] = cnt[t] + 1;

				/*抽屉原理:只要边的总数n大于等于点的个数，图中就存在环*/
				if (cnt[j] >= n) return true;

				if (!st[j])
				{
					q.push(j);
					st[j] = true;
				}
			}
		}
	}
	return false;
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

	if (spfa()) puts("Yes");
	else puts("No");

	return 0;
}
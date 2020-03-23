#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

int n, m;
int idx, h[N], e[N], ne[N];
int q[N];

/*d[i]表示第i个节点的入度*/
int d[N];

/*头插法*/
void insert(int k, int x)
{
	e[idx] = x;
	ne[idx] = h[k];
	h[k] = idx++;
}

bool topsort()
{
	int hh = 0, tt = -1;

	/*拓扑序列必须从入度为0的节点开始所以
	首先将度为0的节点入队*/
	for (int i = 1; i <= n; i++)
		if (d[i] != 0)
			q[++tt] = i;

	/*广度优先搜索每一个节点*/
	while (hh <= tt)
	{
		int t = q[hh++];
		for (int i = h[t]; i != -1; i = ne[i])
		{
			int j = e[i];
			d[j]--;
			if (d[j] == 0) q[++tt] = j;
		}
	}
	return tt == n - 1;
}

int main()
{
	scanf("%d%d", &n, &m);
	for (int i = 0; i < m; i++)
	{
		int k, x;
		scanf("%d%d", &k, &x);
		insert(k, x);

		/*记录第i个节点入度*/
		d[x]++;
	}
	if (topsort())
	{
		for (int i = 0; i < n; i++) printf("%d ", q[i]);
	}
	else puts("-1");
	return 0;
}
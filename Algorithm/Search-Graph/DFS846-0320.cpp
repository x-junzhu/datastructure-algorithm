#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010, M = 2 * N;

/*数组模拟树、图的邻接表存储
idx 当前可用存储节点值得下标
e[i] 树的节点值
ne[i] 第i个节点的下一个节点存储位置
h[i] 节点i的头结点
*/
int idx, e[M], ne[M], h[N];
int n;

/*标记第k个节点是否被遍历过*/
bool st[N];

/*删除节点x后各个连通块节点数目最大值的最小值*/
int ans = N;

/*头插法*/
void insert(int k, int x)
{
	e[idx] = x;
	ne[idx] = h[k];
	h[k] = idx++;
}

/*返回以u为根节点的子树中点的数量*/
int dfs(int u)
{
	st[u] = true;

	int sum = 1, res = 0;
	for (int i = h[u]; i != -1; i = ne[i])
	{
		int j = e[i];
		if (st[j] == false)
		{
			int s = dfs(j);
			res = max(res, s);
			sum += s;
		}
	}
	res = max(res, n - sum);
	ans = min(ans, res);
	return sum;
}

int main()
{
	scanf("%d", &n);
	memset(h, -1, sizeof h);
	for (int i = 0; i < n - 1; i++)
	{
		int k, int x;
		scanf("%d%d", &k, &x);
		insert(k, x);
		insert(x, k);
	}
	dfs(1);
	cout << ans << endl;
}
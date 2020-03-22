#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010;

/*数组模拟图的邻接表存储*/
int idx, e[N], ne[N], h[N];
/*
q[N]是一个队列，每一次存储的是与当前节点相邻的边
d[i]保存的是从节点1到i的最短距离
*/
int q[N], d[N];
int n, m;

/*头插法*/
void insert(int k, int x)
{
	e[idx] = x;
	ne[idx] = h[k];
	h[k] = idx++;
}

/*返回节点1到n的最短距离*/
int bfs()
{
	/*初始化队列的头、尾结点*/
	int tt = 0, hh = 0;
	memset(d, -1, sizeof d);
	q[0] = 1;
	d[0] = 0;
	while (hh <= tt)
	{
		int t = q[hh++];
		for (int i = h[t]; i != -1; i = ne[i])
		{
			int j = e[i];
			if(d[j] == -1)
			{
				/*如果下一个节点没有遍历过，则遍历并且把它到1的距离+1*/
				d[j] = d[t] + 1;
				q[++tt] = j;
			}
		}
	}
	return d[n];
}

int main()
{
	scanf("%d%d", &n, &m);
	memset(h, -1, sizeof h);
	for (int i = 0; i < m; i++)
	{
		int k, x;
		scanf("%d%d", &k, &x);
		insert(k, x);
	}

	cout << bfs() << endl;
	return 0;
}
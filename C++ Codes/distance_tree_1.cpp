#include<bits/stdc++.h>

using namespace std;

const int N = 2e5 + 1;

vector<int> gr[N];
int g[N], f[N];

void dfs_g(int cur, int par) {
	for (auto x : gr[cur]) {
		if (x != par) {
			dfs_g(x, cur);
			g[cur] = max(g[cur], g[x] + 1);
		}
	}
}

void dfs_f(int cur, int par, int dis_par) {

	int max_1 = -1, max_2 = -1;

	for (auto x : gr[cur]) {
		if (x != par) {
			if (g[x] > max_1) max_2 = max_1, max_1 = g[x];
			else if (g[x] > max_2) max_2 = g[x];
		}
	}

	for (auto x : gr[cur]) {
		if (x != par) {

			int new_dis_par = dis_par;

			// for (auto y : gr[cur]) {
			// 	if (y != par && y != x) {
			// 		new_dis_par = max(g[y], new_dis_par);
			// 	}
			// }

			if (g[x] == max_1)
				new_dis_par = max(new_dis_par, max_2);
			else
				new_dis_par = max(new_dis_par, max_1);

			dfs_f(x, cur, new_dis_par + 1);

			// for any node in the subtree
			f[cur] = max(f[cur], g[x] + 1);
		}
	}

	// for any node in the supertree
	// supertree = compliment of subtree
	f[cur] = max(f[cur], dis_par + 1);

}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	cin >> n;

	for (int i = 0; i < n - 1; i++) {
		int x, y;
		cin >> x >> y;
		gr[x].push_back(y);
		gr[y].push_back(x);
	}

	// O(N)
	dfs_g(1, -1);

	// O(N)
	dfs_f(1, -1, -1);

	for (int i = 1; i <= n; i++) {
		cout << f[i] << " ";
	}

	return 0;
}
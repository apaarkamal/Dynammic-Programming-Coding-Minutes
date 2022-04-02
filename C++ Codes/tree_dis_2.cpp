#include<bits/stdc++.h>
#define int long long int

using namespace std;

const int N = 2e5 + 1;

vector<int> gr[N];
int g[N], h[N], f[N], n;

void dfs_g(int cur, int par) {
	for (auto x : gr[cur]) {
		if (x != par) {
			dfs_g(x, cur);
			g[cur] += g[x] + h[x];
			h[cur] += h[x];
		}
	}
	h[cur] += 1;
}

void dfs_f(int cur, int par, int sum_par) {

	for (auto x : gr[cur]) {
		if (x != par) {

			int new_sum_par = sum_par + (n - h[cur]);

			int current_child_values = g[x] + h[x];

			new_sum_par += (g[cur] - current_child_values);

			dfs_f(x, cur, new_sum_par);

			// for any node in the subtree
			f[cur] += (g[x] + h[x]);
		}
	}

	// for any node in the supertree
	// supertree = compliment of subtree
	f[cur] += sum_par + (n - h[cur]);

}

int32_t main()
{
	// freopen("input.txt", "r", stdin);
	// freopen("output.txt", "w", stdout);

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
	dfs_f(1, -1, 0);

	for (int i = 1; i <= n; i++) {
		cout << f[i] << " ";
	}

	return 0;
}
#include<bits/stdc++.h>

using namespace std;

const int N = 2e5 + 1;

vector<int> gr[N];
int f[N], g[N];

void dfs(int cur, int par) {
	int max_1 = 0, max_2 = 0;

	for (auto x : gr[cur]) {
		if (x != par) {
			dfs(x, cur);

			// g for the cur node
			g[cur] = max(g[x] + 1, g[cur]);
			f[cur] = max(f[x], f[cur]);

			// max 2 values of g[x]
			if (g[x] + 1 > max_1) {
				max_2 = max_1;
				max_1 = g[x] + 1;
			}
			else if (g[x] + 1 > max_2) {
				max_2 = g[x] + 1;
			}
		}
	}

	f[cur] = max(f[cur], max_1 + max_2);

}

int main()
{
	// freopen("input.txt", "r", stdin);
	// freopen("output.txt", "w", stdout);

	int n;
	cin >> n;

	for (int i = 0; i < n - 1; i++) {
		int x, y;
		cin >> x >> y;
		gr[x].push_back(y);
		gr[y].push_back(x);
	}

	dfs(1, -1);

	cout << f[1];

	return 0;
}
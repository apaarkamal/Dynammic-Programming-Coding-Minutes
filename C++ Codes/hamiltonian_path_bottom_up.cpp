#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n, m;
	cin >> n >> m;
	vector<int> gr[n];

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		gr[x].push_back(y);
		gr[y].push_back(x);
	}

	int dp[n][1 << n];
	memset(dp, 0, sizeof(dp));

	for (int i = 0; i < n; i++) {
		dp[i][1 << i] = 1;
	}

	for (int mask = 0; mask < (1 << n); mask++) {
		for (int cur = 0; cur < n; cur++) {
			if (dp[cur][mask]) {
				for (auto x : gr[cur]) {
					if (!((mask >> x) & 1)) {
						dp[x][mask | (1 << x)] = true;
					}
				}
			}
		}
	}

	bool ans = 0;

	for (int i = 0; i < n; i++) {
		ans |= dp[i][(1 << n) - 1];
	}

	cout << ans;



	return 0;
}
#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int x, n;
	cin >> x >> n;

	int weight[n];

	for (int i = 0; i < n; i++) {
		cin >> weight[i];
	}

	pair<int, int> dp[1 << n];
	// dp[mask].first = f[mask] = rides
	// dp[mask].second = g[mask] = weight

	dp[0] = {1, 0};

	for (int mask = 1; mask < 1 << n; mask++) {
		dp[mask] = {n, 0};
		for (int y = 0; y < n; y++) {
			if ((mask >> y) & 1) {
				int new_mask = mask ^ (1 << y);
				pair<int, int> option = dp[new_mask];
				// include yth person
				if (option.second + weight[y] <= x) {
					option.first = option.first;
					option.second += weight[y];
				}
				else {
					// exclude the yth person
					// new ride with y
					option.first++;
					option.second = weight[y];
				}
				dp[mask] = min(dp[mask], option);
			}
		}
	}

	cout << dp[(1 << n) - 1].first << " " << dp[(1 << n) - 1].second;







	return 0;
}
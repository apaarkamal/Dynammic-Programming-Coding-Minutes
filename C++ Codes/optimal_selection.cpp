#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int k, n;
	cin >> k >> n;

	int price[k][n];
	vector<vector<int>> dp(1 << k, vector<int>(n, 1e8));

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < n; j++) {
			cin >> price[i][j];
		}
	}

	dp[0][0] = 0;

	for (int i = 0; i < k; i++) {
		dp[1 << i][0] = price[i][0];
	}

	for (int mask = 0; mask < (1 << k); mask++) {
		for (int d = 1; d < n; d++) {
			// dp[mask][d]
			dp[mask][d] = dp[mask][d - 1];

			for (int x = 0; x < k; x++) {
				if ((mask >> x) & 1) {
					// unset jth bit of mask
					int new_mask = mask ^ (1 << x);
					dp[mask][d] = min(dp[mask][d],
					                  dp[new_mask][d - 1] + price[x][d]);
				}
			}
		}
	}

	cout << dp[(1 << k) - 1][n - 1];












	return 0;
}
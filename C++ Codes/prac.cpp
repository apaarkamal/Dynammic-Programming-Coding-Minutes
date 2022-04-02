#include<bits/stdc++.h>
#define int long long int

using namespace std;

int32_t main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	int n;
	cin >> n;
	int a[n][n];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}

	pair<int, int> dp[1 << n];

	dp[0] = {0, 0};

	for (int mask = 1; mask < (1 << n); mask++) {
		dp[mask] = { -1e18, 0};
		for (int bit = 0; bit < n; bit++) {
			if ((mask >> bit) & 1) {
				// bit -> x
				int new_mask = mask ^ (1 << bit);

				// whether start a new group with bit
				if (dp[mask].first < dp[new_mask].first) {
					dp[mask] = {dp[new_mask].first, (1 << bit)};
				}

				// include bit into the previous best group
				// dp[new_mask].second
				int score = 0;
				for (int j = 0; j < n; j++) {
					if ((dp[new_mask].second >> j) & 1) {
						// j represents element in the previous best group
						// add compatibility of bit with j
						score += a[bit][j];
					}
				}

				if (dp[mask].first <= dp[new_mask].first + score) {
					dp[mask] = {dp[new_mask].first + score, dp[new_mask].second | (1 << bit)};
				}
			}
		}
	}


	cout << dp[(1 << n) - 1].first;









}
#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int sum, n;
	cin >> sum >> n;

	int a[n + 1];
	a[0] = 0;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	bool dp[n + 1][sum + 1];

	dp[0][0] = true;

	for (int j = 1; j <= sum; j++) {
		dp[0][j] = false;
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= sum; j++) {

			// exlcusion
			dp[i][j] = dp[i - 1][j];

			// inclusion
			if (j - a[i] >= 0) {
				dp[i][j] |= dp[i - 1][j - a[i]];
			}
		}
	}

	// cout << dp[n][sum];


	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= sum; j++) {
			cout << dp[i][j] << " ";
		} cout << '\n';
	}











	return 0;
}
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

	bool dp[2][sum + 1];

	// first row dp[0][j]
	// second row dp[1][j]

	dp[0][0] = true;

	for (int j = 1; j <= sum; j++) {
		dp[0][j] = false;
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= sum; j++) {
			// dp[ith] row is 2nd row
			dp[1][j] = dp[0][j];
			if (j - a[i] >= 0) {
				dp[1][j] |= dp[0][j - a[i]];
			}
		}

		// copy 2st row to 0th row
		// for next i calculation
		for (int j = 0; j <= sum; j++) {
			dp[0][j] = dp[1][j];
		}

	}

	cout << dp[1][sum];











	return 0;
}
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

	bool dp[sum + 1];

	// one row dp[j]

	dp[0] = true;

	for (int j = 1; j <= sum; j++) {
		dp[j] = false;
	}

	// O(n*sum)
	for (int i = 1; i <= n; i++) {
		for (int j = sum; j >= 0; j--) {

			if (j - a[i] >= 0) {
				dp[j] |= dp[j - a[i]];
			}

		}

	}

	cout << dp[sum];











	return 0;
}
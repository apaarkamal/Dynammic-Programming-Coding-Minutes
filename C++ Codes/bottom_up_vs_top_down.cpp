#include<bits/stdc++.h>

using namespace std;

map<int, int> mp;

// int memo[1e6];

int dp(int n) {
	if (n <= 1) return n;
	if (mp.count(n)) return mp[n];
	return mp[n] = max(dp(n / 2) + dp(n / 3) + dp(n / 4), n);
}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	/*
	while (cin >> n) {
		// cout << n << '\n';

		// bottom up

		int dp[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
		}
		cout << dp[n] << '\n';
	}
	*/

	// top down
	while (cin >> n) {
		cout << dp(n) << '\n';
	}








	return 0;
}
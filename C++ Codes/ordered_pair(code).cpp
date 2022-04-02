#include<bits/stdc++.h>
#define int long long int

using namespace std;

int memo[1000];

// O(n*n)
int countWaysOrdered(int n) {
	if (n == 0) return 1;
	if (memo[n] != -1) return memo[n];
	int ans = 0;

	// for (i....n)
	for (int i = 1; i <= n; i++) {
		ans += countWaysOrdered(n - i);
	}

	return memo[n] = ans;
}

int32_t main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	int n;
	cin >> n;

	// top down approach
	memset(memo, -1, sizeof(memo));

	cout << countWaysOrdered(n) << '\n';

	// bottom up approach
	// O(n)
	int sum = 0;
	int dp[n + 1];

	for (int i = 1; i <= n; i++) {
		dp[i] = sum + 1;
		sum += dp[i];
	}

	cout << dp[n] << '\n';

	// 2^(n-1)
	// O(1)
	cout << pow(2, n - 1) << '\n';







}
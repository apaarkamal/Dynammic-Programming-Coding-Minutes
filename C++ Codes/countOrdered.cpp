#include<bits/stdc++.h>
#define int long long int

using namespace std;

// O(n*n)
int memo[1000];
int countOrdered(int n) {
	if (n == 0) return 1;
	if (memo[n] != -1) return memo[n];
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		ans += countOrdered(n - i);
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
	memset(memo, -1, sizeof(memo));
	cout << countOrdered(n) << '\n';

	// O(n)
	int dp[n + 1];
	dp[0] = 1;
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		dp[i] = sum + 1;
		sum += dp[i];
	}

	cout << dp[n] << '\n';

	// O(1)
	cout << pow(2, n - 1);


}
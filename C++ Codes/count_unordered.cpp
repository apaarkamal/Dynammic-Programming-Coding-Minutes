#include<bits/stdc++.h>
#define int long long int

using namespace std;

// O(n*n*n) after memoisation
int countUnordered(int min, int n) {

	if (n == 0) return 1;

	int ans = 0;
	for (int i = min; i <= n; i++) {
		ans += countUnordered(i, n - i);
	}

	return ans;

}

int32_t main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	int n;
	cin >> n;

	// for (int i = 0; i <= 20; i++) {
	// 	cout << countUnordered(1, i) << '\n';
	// }

	// O(n*n) solution
	int dp[n + 1];
	memset(dp, 0, sizeof(dp));
	dp[0] = 1;

	for (int i = 1; i <= n; i++) {

		for (int j = i; j <= n; j++) {
			dp[j] += dp[j - i];
		}

		for (int k = 0; k <= n; k++) {
			cout << dp[k] << " ";
		} cout << '\n';
	}

	cout << dp[n] << '\n';





}
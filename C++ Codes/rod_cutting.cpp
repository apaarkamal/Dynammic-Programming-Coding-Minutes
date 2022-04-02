#include<bits/stdc++.h>
#define int long long int

using namespace std;

int memo[100000];

// Space Complexity -> O(n)
// Time complexity -> O(n*n)
int rodCutting(int n, int prices[]) {
	if (n == 0) return 0;

	if (memo[n] != -1) return memo[n];

	// O(n) extra work inside each state
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		ans = max(ans, prices[i] + rodCutting(n - i, prices));
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
	int prices[n + 1];

	for (int i = 1; i <= n; i++) {
		cin >> prices[i];
	}

	memset(memo, -1, sizeof(memo));
	cout << rodCutting(n, prices);






}
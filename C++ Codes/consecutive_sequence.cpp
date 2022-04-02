#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	cin >> n;
	int a[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	map<int, int> dp;

	for (int i = 0; i < n; i++) {
		dp[a[i]] = dp[a[i] - 1] + 1;
	}

	int k = 0, start, end;
	for (auto x : dp) {
		// x.first
		if (k < x.second) end = x.first;
		k = max(k, x.second);
	}

	cout << k << '\n';

	start = end - k + 1;
	for (int i = 0; i < n; i++) {
		if (a[i] == start) {
			// zero-based inedxing
			cout << i + 1 << " ";
			start++;
		}
		if (start == end + 1) break;
	}

	return 0;
}
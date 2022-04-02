#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	cin >> n;

	int a[n], dp[n];

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	dp[0] = a[0];
	dp[1] = a[1];
	dp[2] = a[2];

	for (int i = 3; i < n; i++) {
		dp[i] = min({dp[i - 1], dp[i - 2], dp[i - 3]}) + a[i];
	}

	for (int i = 0; i < n; i++) {
		cout << dp[i] << " ";
	} cout << '\n';

	cout << min({dp[n - 1], dp[n - 2], dp[n - 3]});










	return 0;
}
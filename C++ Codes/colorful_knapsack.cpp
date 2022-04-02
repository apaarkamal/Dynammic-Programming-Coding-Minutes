#include<bits/stdc++.h>
using namespace std;

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	// ll t;
	// cin>>t;
	// while(t--)
	{
		ll i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
		cin >> j >> n >> m;
		ll dp[105][10005] = {};
		vector<ll> v[105];
		ll a[105];
		for (i = 0; i < j; i++) {
			cin >> a[i];
		}
		for (i = 0; i < j; i++) {
			ll x; cin >> x;
			v[x].pb(a[i]);
		}
		for (auto x : v[1]) {
			dp[1][x]++;
		}
		for (i = 1; i < n; i++) {
			for (j = 0; j <= m; j++) {
				if (dp[i][j]) {
					for (auto x : v[i + 1]) {
						if (j + x <= m) {
							dp[i + 1][j + x]++;
						}
					}
				}
			}
		}
		for (j = 1; j <= m; j++) {
			if (dp[n][j]) {
				ans = max(ans, j);
			}
		}
		if (ans == 0) cout << -1;
		else cout << m - ans;
	}
}
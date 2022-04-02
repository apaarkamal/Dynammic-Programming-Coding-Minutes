#include<bits/stdc++.h>

using namespace std;

#define int long long int
#define ld long double
#define F first
#define S second
#define P pair<int,int>
#define pb push_back

const int N = 300005;

int32_t main()
{
	ios_base:: sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int t; cin >> t; while (t--)
	{
		int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
		cin >> n;
		int a[n], b[n];
		for (i = 0; i < n; i++) {
			cin >> a[i] >> b[i];
		}
		int dp[n][3] ;
		for (i = 0; i < n; i++) {
			dp[i][0] = dp[i][1] = dp[i][2] = 1e18;
		}
		dp[0][0] = 0; dp[0][1] = b[0]; dp[0][2] = 2 * b[0];
		for (i = 1; i < n; i++) {
			for (j = 0; j < 3; j++) {
				for (k = 0; k < 3; k++) {
					if (a[i - 1] + j != a[i] + k) {
						dp[i][k] = min(dp[i][k], dp[i - 1][j] + k * b[i]);
					}
				}
			}
		}
		cout << min({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]}) << '\n';
	}
}
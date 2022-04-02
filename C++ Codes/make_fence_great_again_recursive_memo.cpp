#include<bits/stdc++.h>

using namespace std;

#define int long long int
#define ld long double
#define F first
#define S second
#define P pair<int,int>
#define pb push_back

const int N = 300005;

int n;
int a[N], dp[N][3], b[N];

int solve(int pos, int prev, int state) {
	if (pos == n) return 0;
	if (dp[pos][state] != -1) return dp[pos][state];
	int ans = 1e18;
	if (a[pos] + 0 != prev) {
		ans = min(ans, solve(pos + 1, a[pos] + 0, 0));
	}
	if (a[pos] + 1 != prev) {
		ans = min(ans, b[pos] + solve(pos + 1, a[pos] + 1, 1));
	}
	if (a[pos] + 2 != prev) {
		ans = min(ans, 2 * b[pos] + solve(pos + 1, a[pos] + 2, 2));
	}
	return dp[pos][state] = ans;
}

int32_t main()
{
	ios_base:: sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int t; cin >> t; while (t--)
	{
		int i, j, k, m, ans = 0, cnt = 0, sum = 0;
		cin >> n;
		for (i = 0; i < n; i++) {
			cin >> a[i] >> b[i];
		}
		for (i = 0; i <= n; i++) {
			for (j = 0; j < 3; j++) {
				dp[i][j] = -1;
			}
		}
		cout << min({solve(0, -1, 0), solve(0, -1, 1), solve(0, -1, 2)}) << '\n';
	}
}
#include<bits/stdc++.h>

using namespace std;

#define int long long int
#define ld long double
#define F first
#define S second
#define pb push_back

const int N = 100005;

string s;
int dp[2001][2][2000], m, mod = 1e9 + 7;

int work(int pos, bool last, int modpro) {
	if (pos == s.size()) {
		if (modpro == 0) {
			return 1;
		}
		return 0;
	}
	if (dp[pos][last][modpro] != -1) {
		return dp[pos][last][modpro];
	}
	int till = (last ? s[pos] - '0' : 9);
	int ans = 0;
	for (int i = 0; i <= till; i++) {
		ans += work(pos + 1, last && (i == s[pos] - '0'), (modpro * 10 + i) % m);
		ans %= mod;
	}
	return dp[pos][last][modpro] = ans % mod;
}

int solve(int n) {
	s = to_string(n);
	memset(dp, -1, sizeof(dp));
	int ans = work(0, 1, 0);
	return ans;
}

int32_t main()
{
	ios_base:: sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	freopen("debug.txt", "w", stderr);
#endif
	int t; cin >> t; while (t--)
	{
		int i, j, k, n, ans = 0, cnt = 0, sum = 0;
		cin >> i >> j >> m;
		cout << solve(j) - solve(i - 1);
	}
}
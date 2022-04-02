#include<bits/stdc++.h>

using namespace std;

#define int long long int
#define ld long double
#define F first
#define S second
#define P pair<int,int>
#define pb push_back
#define db(...) __f(#__VA_ARGS__, __VA_ARGS__)

template <typename Arg1>
void __f(const char* name, Arg1&& arg1) { cout << name << " : " << arg1 << '\n'; }
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
	const char* comma = strchr(names + 1, ',');
	cout.write(names, comma - names) << " : " << arg1 << " | "; __f(comma + 1, args...);
}

const int N = 205;

int n, k, m;
vector<int> a(N);
vector<vector<int>> memo(N, (vector<int>(N, -1)));

int dp(int cur, int rem) {
	if (memo[cur][rem] != -1) return memo[cur][rem];
	if (cur == n) {
		if (rem == 0) return 0;
		else return -1e18;
	}
	if (rem == 1) {
		if (cur >= n - k) return a[cur];
		else return -1e18;
	}
	int i;
	int ans = -1e18;
	for (i = cur + 1; i < n && i <= cur + k; i++) {
		ans = max(ans, a[cur] + dp(i, rem - 1));
	}
	return memo[cur][rem] = ans;
}

void solve() {
	int i, j, ans = 0, cnt = 0, sum = 0;
	cin >> n >> k >> m;
	for (i = 0; i < n; i++) {
		cin >> a[i];
	}
	ans = -1e18;
	for (i = 0; i < k; i++) {
		ans = max(ans, dp(i, m));
		// cout << i << " " << dp(i, m) << '\n';
	}
	if (ans < 0) ans = -1;
	cout << ans;
	return ;
}

int32_t main()
{
	ios_base:: sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	// int t; cin >> t; while (t--)
	solve();
	return 0;
}
// 1879965082
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

const int N = 5005;

int n, k, m;
vector<int> a(N);

struct sparse_table {
	vector<vector<int>> mat;// 0 based indexing
	int n, m; // size and log
	vector<int> p2;//log2
	void init(int _n, int _m) {
		n = _n; m = _m;
		mat.resize(n); p2.resize(n + 1);
		for (int i = 0; i < n; i++) mat[i].resize(m);
		for (int i = 2; i <= n; i++) p2[i] = p2[i / 2] + 1;
	}
	void build(int a[]) {
		int i, j;
		for (i = 0; i < n; i++) mat[i][0] = a[i];
		for (j = 1; j < m; j++) {
			for (i = 0; i + (1 << j) <= n; i++) {
				mat[i][j] = max(mat[i][j - 1], mat[i + (1 << (j - 1))][j - 1]);
			}
		}
	}
	int query(int l, int r) {
		int pw = p2[r - l];
		return max(mat[l][pw], mat[r - (1 << pw) + 1][pw]);
	}
} table;

void solve() {
	int i, j, ans = 0, cnt = 0, sum = 0;
	cin >> n >> k >> m;
	for (i = 0; i < n; i++) {
		cin >> a[i];
	}
	int dp[n];
	for (i = 0; i < n; i++) {
		if (i >= n - k) dp[i] = a[i];
		else dp[i] = -1e16;
	}
	table.init(n, 13);
	for (j = 2; j <= m; j++) {
		table.build(dp);
		for (i = 0; i < n - 1; i++) {
			dp[i] = a[i] + table.query(i + 1, min(i + k, n - 1));
		}
		dp[n - 1] = -1e16;
	}
	ans = -1e16;
	for (i = 0; i < k; i++) {
		ans = max(ans, dp[i]);
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
#include<bits/stdc++.h>

using namespace std;

#define int long long int
#define ld long double
#define F first
#define S second
#define P pair<int,int>
#define V vector
#define pb push_back
#define db(...) __f(#__VA_ARGS__, __VA_ARGS__)

template <typename Arg1>
void __f(const char* name, Arg1&& arg1) { cout << name << " : " << arg1 << '\n'; }
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
	const char* comma = strchr(names + 1, ',');
	cout.write(names, comma - names) << " : " << arg1 << " | "; __f(comma + 1, args...);
}

const int N = 100005;

int mod;

const int M = 20;
int sz;
struct Mat
{
	int m[M][M];

	Mat()
	{
		memset(m, 0, sizeof m);
	}

	void eye()
	{
		for (int i = 0; i < sz; i++)
			m[i][i] = 1;
	}

	Mat operator* (const Mat &a) const
	{
		Mat r;
		for (int i = 0; i < sz; i++)
			for (int j = 0; j < sz; j++)
				for (int k = 0; k < sz; k++)
					r.m[i][j] = (r.m[i][j] + m[i][k] * a.m[k][j]) % mod;
		return r;
	}
};
int solve(int b[], int c[], int e, int n)
{
	Mat r, a;
	r.eye();
	a.m[0][0] = 1;
	for (int i = 1; i < sz; i++) {
		a.m[0][i] = c[i - 1];
		a.m[1][i] = c[i - 1];
	}
	for (int i = 2; i < sz; i++) {
		a.m[i][i - 1] = 1;
	}
	while (e) {
		if (e & 1)
			r = r * a;
		a = a * a;
		e >>= 1;
	}
	int ans = 0;
	for (int i = 0; i < n; i++) {
		ans += b[i];
	}
	ans = r.m[0][0] * ans;
	ans %= mod;
	for (int i = 1; i < sz; i++) {
		ans += r.m[0][i] * b[n - i];
		ans %= mod;
	}
	return ans;
}

int give(int k, int b[], int c[], int n) {
	if (k < n) {
		int ans = 0;
		for (int i = 0; i <= k; i++) {
			ans += b[i];
			ans %= mod;
		}
		return ans;
	}
	else {
		return solve(b, c, k - n + 1, n) ;
	}
}

int32_t main()
{
	int t; cin >> t; while (t--)
	{
		int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
		cin >> n;
		sz = n + 1;
		int b[n], c[n];
		for (i = 0; i < n; i++) {
			cin >> b[i];
		}
		for (i = 0; i < n; i++) {
			cin >> c[i];
		}
		int l, r;
		cin >> l >> r >> mod;
		l--; r--;
		cout << (give(r, b, c, n) - give(l - 1, b, c, n) + mod) % mod << '\n';
	}
}
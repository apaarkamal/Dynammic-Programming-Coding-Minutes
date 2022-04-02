#include<bits/stdc++.h>
#define int long  long int

using namespace std;

int m, d, mod = 1e9 + 7;
string n;

// memoisation
int memo[2000][2][2000];

// 0-based index
int dp(int index, bool last, int dig_mod) {

	if (index == n.size()) {
		return (dig_mod == 0);
	}

	if (memo[index][last][dig_mod] != -1) return memo[index][last][dig_mod];

	int till = (last ? n[index] - '0' : 9);
	int ans = 0;

	if (index % 2 == 1) {
		// even position
		if (d <= till) {
			ans += dp(index + 1, last && (d == till), (dig_mod * 10 + d) % m);
			ans %= mod;
		}
	}
	else {
		// odd positions
		for (int digits = 0; digits <= till; digits++) {
			// odd position cannot place d
			if (digits == d) continue;
			ans += dp(index + 1, last && (digits == till), (dig_mod * 10 + digits) % m);
			ans %= mod;
		}
	}
	return memo[index][last][dig_mod] = ans;
}

int solve(string _n) {
	n = _n;
	memset(memo, -1, sizeof(memo));
	return dp(0, true, 0);
}

int32_t main() {

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	cin >> m >> d;

	string a, b;
	cin >> a >> b;

	int i = a.size() - 1;

	while (i >= 0 && a[i] == '0') {
		a[i] = '9';
		i--;
	}
	a[i] = a[i] - 1;

	// cout << a << '\n';

	// a = a - 1;
	cout << (solve(b) - solve(a) + mod) % mod;





}
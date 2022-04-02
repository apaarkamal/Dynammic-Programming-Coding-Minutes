#include<bits/stdc++.h>
#define int long long int

using namespace std;

string s;
vector<int> memo;

int dp(int i) {

	if (i == s.size()) return 1;

	if (memo[i] != -1) return memo[i];

	int ans = 0;
	if (s[i] >= '1' && s[i] <= '9') {
		ans += dp(i + 1);
	}

	if (i + 1 < s.size() && (s[i] == '1')) {
		ans += dp(i + 2);
	}

	if (i + 1 < s.size() && (s[i] == '2' && s[i + 1] <= '6')) {
		ans += dp(i + 2);
	}

	return memo[i] = ans;
}

int32_t main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	while (1) {
		cin >> s;
		if (s[0] == '0') break;

		memo.clear();
		memo.resize(s.size(), -1);

		cout << dp(0) << '\n';

	}


}
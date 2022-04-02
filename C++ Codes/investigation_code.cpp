#include<bits/stdc++.h>
#define int long long int

using namespace std;

string n;
int a, b, k;

// 10 * 2 * 100 * 100 states
int memo[10][2][90][90];

int solver(int index, bool last, int sum_mod, int sum_dig_mod) {

	if (index == n.size()) {
		if (sum_mod == 0 && sum_dig_mod == 0) {
			return 1;
		}
		return 0;
	}

	if (memo[index][last][sum_mod][sum_dig_mod] != -1) {
		return memo[index][last][sum_mod][sum_dig_mod];
	}

	int till = (last ? n[index] - '0' : 9);
	int ans = 0;

	for (int digits = 0; digits <= till; digits++) {
		ans += solver(index + 1, last && (digits == till),
		              (sum_mod * 10 + digits) % k,
		              (sum_dig_mod + digits) % k);
	}

	return memo[index][last][sum_mod][sum_dig_mod] = ans;

}

int f(int _n) {
	if (k > 90) return 0;
	n = to_string(_n);
	memset(memo, -1, sizeof(memo));
	return solver(0, true, 0, 0);
}

int32_t main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	// dont forget to add case ?
	// Case 1:
	// Case 2:

	int t;
	cin >> t;
	while (t--) {
		cin >> a >> b >> k;
		cout << f(b) - f(a - 1) << '\n';
	}


	return 0;
}
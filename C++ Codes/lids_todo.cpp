#include<bits/stdc++.h>
#define int long long int

using namespace std;

string n, m;

int memo1[11][2][2][11][11];

int combination(int index, bool first, bool last, int prev, int len) {

	// cout << prev << " " << len << '\n';

	if (index == n.size()) {
		if (len == 0) return 1;
		return 0;
	}

	if (memo1[index][first][last][prev][len] != -1) {
		return memo1[index][first][last][prev][len];
	}

	int start = (first ? n[index] - '0' : 0);
	int till = (last ? m[index] - '0' : 9);
	int ans = 0;


	for (int digits = start; digits <= till; digits++) {
		ans += combination(index + 1, first && (digits == start), last && (digits == till), prev, len);
		if (digits > prev) {
			ans += combination(index + 1, first && (digits == start), last && (digits == till), digits, len - 1);
		}
	}

	return memo1[index][first][last][prev][len] = ans;

}

int solver(int _n, int _m, int len) {
	n = to_string(_n);
	m = to_string(_m);
	int diff = m.size() - n.size();
	while (diff--) {
		n = "0" + n;
	}
	memset(memo1, -1, sizeof(memo1));
	return combination(0, true, true, 0, len);
}

int32_t main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int t;
	cin >> t;

	for (int i = 1; i <= t; i++) {

		int a, b;
		cin >> a >> b;

		for (int len = 10; len >= 0; len--) {
			if (solver(a, b, len)) {
				cout << "Case " << i << ": " << len << " " << solver(a, b, len) << '\n';
				break;
			}
		}

	}


	return 0;
}
#include<bits/stdc++.h>
#define int long long int

using namespace std;

string n;

int memo[10][2][90];

int dp(int index, bool last, int sum) {

	if (index == n.size()) {
		return sum;
	}

	if (memo[index][last][sum] != -1) return memo[index][last][sum];

	int till = (last ? n[index] - '0' : 9);
	int ans = 0;

	for (int digits = 0; digits <= till; digits++) {
		ans += dp(index + 1, last && (digits == till), sum + digits);
	}

	return memo[index][last][sum] = ans;
}

int solve(int _n) {
	n = to_string(_n);
	memset(memo, -1, sizeof(memo));
	return dp(0, true, 0);
}

int32_t main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	while (1) {

		int a, b;
		cin >> a >> b;

		if (a == -1 && b == -1) break;

		cout << solve(b) - solve(a - 1) << '\n';

	}


	return 0;
}
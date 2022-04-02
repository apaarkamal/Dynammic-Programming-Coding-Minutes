#include<bits/stdc++.h>

using namespace std;

const int N = 1e5 + 1;

vector<int> gr[N];
int memo[N][2];

int dp(int cur, bool take, int par) {

	if (memo[cur][take] != -1) return memo[cur][take];

	int ans = take;
	for (auto x : gr[cur]) {
		if (x != par) {
			// x is only the child vertex
			if (take) {
				ans += min(dp(x, 0, cur),
				           dp(x, 1, cur));
			}
			else {
				ans += dp(x, 1, cur);
			}
		}
	}
	return memo[cur][take] = ans;
}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	cin >> n;

	// corrected n-1 as edge count
	for (int i = 0; i < n - 1; i++) {
		int x, y;
		cin >> x >> y;
		gr[x].push_back(y);
		gr[y].push_back(x);
	}

	memset(memo, -1, sizeof(memo));
	cout << min(dp(1, 0, -1), dp(1, 1, -1));

	return 0;
}
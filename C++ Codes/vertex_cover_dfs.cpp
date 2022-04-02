#include<bits/stdc++.h>

using namespace std;

const int N = 1e5 + 1;

vector<int> gr[N];
int dp[N][2];

void dfs(int cur, int par) {

	dp[cur][0] = 0;
	dp[cur][1] = 1;

	for (auto x : gr[cur]) {
		if (x != par) {

			dfs(x, cur);
			// coming back from dfs
			// dp[x] wil be filled

			dp[cur][0] += dp[x][1];
			dp[cur][1] += min(dp[x][0], dp[x][1]);

		}
	}

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

	dfs(1, 0);

	cout << min(dp[1][0], dp[1][1]);

	return 0;
}
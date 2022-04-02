#include<bits/stdc++.h>

using namespace std;

const int N = 1e5 + 1;

vector<int> gr[N];
int dp[N][2];
int vis[N];

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n, root;
	cin >> n;

	// corrected n-1 as edge count
	for (int i = 0; i < n - 1; i++) {
		int x, y;
		cin >> x >> y;
		gr[x].push_back(y);
		gr[y].push_back(x);
	}

	queue<int> Q;

	for (int i = 1; i <= n; i++) {
		if (gr[i].size() == 1) Q.push(i);
	}

	while (!Q.empty()) {

		int cur = Q.front();
		Q.pop();

		vis[cur] = 1;
		root = cur;

		dp[cur][0] = 0;
		dp[cur][1] = 1;

		for (auto x : gr[cur]) {
			if (vis[x]) {
				// child nodes
				dp[cur][0] += dp[x][1];
				dp[cur][1] += min(dp[x][0], dp[x][1]);
			}
			else {
				// parent node
				Q.push(x);
			}
		}

	}
	// the node which is visited in the end
	cout << min(dp[root][0], dp[root][1]);

	return 0;
}
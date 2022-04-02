#include<bits/stdc++.h>

using namespace std;

const int N = 2e5 + 1, M = 20;

vector<int> gr[N];
int Par[N][M];

void dfs(int cur, int par) {

	Par[cur][0] = par;
	for (int j = 1; j < M; j++) {
		Par[cur][j] = Par[Par[cur][j - 1]][j - 1];
	}

	for (auto x : gr[cur]) {
		if (x != par) {
			dfs(x, cur);
		}
	}
}

int giveKthPar(int x, int k) {

	int cur = x;
	for (int j = 0; j < M; j++) {
		if ((k >> j) & 1) {
			cur = Par[cur][j];
		}
	}

	if (cur == 0) cur = -1;
	return cur;

}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n, q;
	cin >> n >> q;

	for (int i = 2; i <= n; i++) {
		int par;
		cin >> par;
		gr[i].push_back(par);
		gr[par].push_back(i);
	}

	dfs(1, 0);

	// for (int i = 1; i <= n; i++) {
	// 	for (int j = 0; j < 3; j++) {
	// 		cout << i << " " << pow(2, j) << " " << Par[i][j] << '\n';
	// 	}
	// }

	while (q--) {
		int x, k;
		cin >> x >> k;
		cout << giveKthPar(x, k) << '\n';
	}

	return 0;
}
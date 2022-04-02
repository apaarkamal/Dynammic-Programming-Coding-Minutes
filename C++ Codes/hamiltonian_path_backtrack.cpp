#include<bits/stdc++.h>

using namespace std;

const int N = 1e5;

vector<int> gr[N];
int n, m;
int vis[N];
bool hamiltonian_path = false;

// bool paths()

// O(number_of_hamiltonian_paths)
void paths(int cur, int cnt) {
	if (cnt == n) {
		hamiltonian_path = true;
		return;
	}

	vis[cur] = 1;

	for (auto x : gr[cur]) {
		if (!vis[x]) {
			paths(x, cnt + 1);
		}
	}

	// backtracking
	vis[cur] = 0;
	return;
}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		gr[x].push_back(y);
		gr[y].push_back(x);
	}

	for (int i = 0; i < n; i++) {
		paths(i, 1);
	}

	cout << hamiltonian_path;






	return 0;
}
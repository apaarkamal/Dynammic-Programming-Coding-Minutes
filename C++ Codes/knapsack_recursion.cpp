#include<bits/stdc++.h>

using namespace std;

const int N = 2001;

int s[N], v[N];
int memo[N][N];

// O(n*size)
int knapsack(int index, int size) {
	if (index == 0) return 0;

	int &ans = memo[index][size];

	if (ans != -1) return ans;
	ans = 0;

	// include
	if (s[index] <= size) {
		ans = v[index] + knapsack(index - 1, size - s[index]);
	}
	// exclude
	ans = max(ans, knapsack(index - 1, size));

	return ans;

}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int size, n;
	cin >> size >> n;

	for (int i = 1; i <= n; i++) {
		cin >> s[i] >> v[i];
	}

	memset(memo, -1, sizeof(memo));

	cout << knapsack(n, size);

	return 0;
}
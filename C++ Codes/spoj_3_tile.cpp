#include<bits/stdc++.h>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	while (cin >> n) {
		if (n == -1) break;

		int f[n + 1], g[n + 1];

		f[0] = g[0] = 1;
		f[1] = g[1] = 0;

		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 2] + 2 * g[i - 2];
			g[i] = g[i - 2] + f[i];
		}

		cout << f[n] << '\n';
	}
	return 0;
}
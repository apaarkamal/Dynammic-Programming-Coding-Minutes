#include<bits/stdc++.h>
#define int long long int
using namespace std;

const int mod = 1e9 + 7;
const int sz = 3;

struct Mat {
	int m[sz][sz];
	Mat() {
		memset(m, 0, sizeof(m));
	}
	void identity() {
		for (int i = 0; i < sz; i++) {
			m[i][i] = 1;
		}
	}
	Mat operator* (Mat a) {
		Mat res;
		for (int i = 0; i < sz; i++) {
			for (int j = 0; j < sz; j++) {
				for (int k = 0; k < sz; k++) {
					res.m[i][j] += m[i][k] * a.m[k][j];
					res.m[i][j] %= mod;
				}
			}
		}
		return res;
	}
};

int Fibosum(int n) {
	// base case
	if (n == -1) return 0;
	if (n == 0) return 0;
	if (n == 1) return 1;

	Mat res;
	res.identity();
	Mat T;
	T.m[0][0] = T.m[0][1] = T.m[0][2] = 1;
	T.m[1][1] = T.m[1][2] = 1;
	T.m[2][1] = 1;

	// n >= 2
	n -= 1;

	// log(n)
	while (n) {
		if (n & 1) res = res * T;
		T = T * T;
		n /= 2;
	}

	return (res.m[0][0] + res.m[0][1]) % mod;
}

int32_t main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int t;
	cin >> t;

	while (t--) {
		int n, m;
		cin >> n >> m;
		cout << (Fibosum(m) - Fibosum(n - 1) + mod) % mod << '\n';
	}

	return 0;
}
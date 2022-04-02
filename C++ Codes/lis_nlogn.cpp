#include<bits/stdc++.h>

using namespace std;

struct fenwick {
	vector<int> fn;
	int n;
	fenwick() {}
	fenwick(int n) {
		init(n);
	}
	void init(int _n) {
		n = _n + 10;
		fn.clear(); fn.resize(n, 0);
	}
	// log(n)
	void update(int x, int val) {
		x++;// 1 based indexing
		while (x < n) {
			fn[x] = max(fn[x], val);
			x += (x & (-x));
		}
	}
	// log(n)
	int query(int x) {
		x++;//1 basaed indexing
		int ans = 0;
		while (x) {
			ans = max(ans, fn[x]);
			x -= (x & (-x));
		}
		return ans;
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	cin >> n;
	int a[n];
	pair<int, int> b[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		b[i] = {a[i], i};
	}

	fenwick H(n);

	int lis[n];

	// n log n
	sort(b, b + n);

	for (int i = 0; i < n; i++) {
		int val = b[i].first;
		int index = b[i].second;

		lis[index] = H.query(index - 1) + 1;

		H.update(index, lis[index]);
	}

	// for (int i = 0; i < n; i++) {
	// 	cout << lis[i] << " ";
	// }

	// n logn

	cout << H.query(n - 1);


	// inversion count



	return 0;
}
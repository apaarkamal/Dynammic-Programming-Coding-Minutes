#include<bits/stdc++.h>

using namespace std;

struct segmenttree {
	vector<int> st;
	int n;
	void init(int _n) {
		n = _n;
		st.clear();
		st.resize(4 * _n);
	}
	void build(int l, int r, int node, int a[]) {
		if (l == r) {
			st[node] = a[l];
			return;
		}
		int mid = (l + r) / 2;
		build(l, mid, node * 2 + 1, a);
		build(mid + 1, r, node * 2 + 2, a);
		st[node] = min(st[2 * node + 1], st[2 * node + 2]);
	}

	void update(int l, int r, int indup, int val, int node) {
		if (l == r) {
			st[node] = val;
			return;
		}
		else {
			int mid = (l + r) / 2;
			if (indup >= l && indup <= mid) {
				update(l, mid, indup, val, node * 2 + 1);
			}
			else {
				update(mid + 1, r, indup, val, node * 2 + 2);
			}
			st[node] = min(st[2 * node + 1], st[2 * node + 2]);
		}
	}

	int query(int si, int se, int l, int r, int node) {
		if (se < l || si > r || l > r) {
			return INT_MAX;
		}
		if (si >= l && se <= r) {
			return st[node];
		}
		int mid = (si + se) / 2;
		int q1 = query(si, mid, l, r, node * 2 + 1);
		int q2 = query(mid + 1, se, l, r, node * 2 + 2);
		return min(q1, q2);
	}
	void build(int n, int a[]) {
		init(n);
		build(0, n - 1, 0, a);
	}
	int query(int l, int r) {
		return query(0, n - 1, l, r, 0);
	}
	void update(int index, int val) {
		update(0, n - 1, index, val, 0);
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n, k;
	cin >> n >> k;
	int a[n], b[n], dp[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		b[i] = INT_MAX;
	}

	segmenttree H;

	H.build(n, b);

	for (int i = 0; i < k; i++) {
		dp[i] = a[i];
		H.update(i, dp[i]);
	}

	for (int i = k; i < n; i++) {
		int mn = H.query(i - k, i - 1);
		dp[i] = mn + a[i];
		H.update(i, dp[i]);
	}

	// for (int i = 0; i < n; i++) {
	// 	cout << dp[i] << " ";
	// }

	cout << H.query(n - k, n - 1);




	return 0;
}
#include<bits/stdc++.h>

using namespace std;

const int N = 13;

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int sum, n;
	cin >> sum >> n;

	int a[n + 1];
	a[0] = 0;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	bitset<N> bt;
	bt[0] = 1;

	// O(n)
	for (int i = 1; i <= n; i++) {
		bt |= (bt << a[i]);
	}

	cout << bt[sum];


	return 0;
}
#include<bits/stdc++.h>

using namespace std;

// one represents whether
// the number at previous index is one
int fun(int index, int n, bool previous_one) {

	// base case
	if (index == n + 1) return 1;

	int ans = 0;

	// either place 0 here
	ans += fun(index + 1, n, false);

	// or place 1 here
	if (previous_one == false) {
		ans += fun(index + 1, n, true);
	}

	return ans;
	// ans for array [index.....n]
}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);


	for (int i = 1; i <= 10; i++) {
		cout << fun(1, i, false) << '\n';
	}

	// fibonacci series
	// 1,1,2,3,5,8 .....
	// ans = fib(n+2)







	return 0;
}
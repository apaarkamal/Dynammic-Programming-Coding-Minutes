#include<bits/stdc++.h>

using namespace std;

const int N = 1000;

int a[N], n;

vector<vector<int>> memo;

// whether sum is possible from subset of
// a[.....index]
// O(n x sum)
int subsetSum(int index, int sum) {

	// no elements left for sum
	if (index == -1) return (sum == 0);

	if (memo[index][sum] != -1) return memo[index][sum];

	bool ans = false;
	// include a[index] in sum
	if (sum >= a[index]) {
		ans |= subsetSum(index - 1, sum - a[index]);
	}
	// exclude a[index]
	ans |= subsetSum(index - 1, sum);

	return memo[index][sum] = ans;
}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int sum;
	cin >> sum >> n;


	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	memo.resize(n, vector<int>(sum + 1, -1));
	cout << subsetSum(n - 1, sum);

	return 0;
}
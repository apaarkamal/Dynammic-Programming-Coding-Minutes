#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	vector<int> memo;
	int dp(int i, vector<int>& arr, int k) {
		if (i == arr.size()) return 0;
		if (memo[i] != -1) return memo[i];
		int ans = 0, mx = 0;
		for (int j = i; j < min((int)arr.size(), i + k); j++) {
			mx = max(mx, arr[j]);
			ans = max(ans, mx * (j - i + 1) + dp(j + 1, arr, k));
		}
		return memo[i] = ans;
	}
	int maxSumAfterPartitioning(vector<int>& arr, int k) {
		memo.resize(arr.size(), -1);
		return dp(0, arr, k);
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	Solution H;
	vector<int> a = {1, 15, 7, 9, 2, 5, 10};
	cout << H.maxSumAfterPartitioning(a, 3);


	return 0;
}
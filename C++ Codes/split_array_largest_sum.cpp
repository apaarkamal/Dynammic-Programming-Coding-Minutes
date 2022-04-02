#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	vector<vector<int>> memo;
	int dp(int i, vector<int>& nums, int m) {
		if (i == nums.size()) {
			if (m == 0) return 0;
			return 1e9;
		}
		if (m <= 0) return 1e9;
		// i>=0 && i<n && m>0
		// I can make partitions
		if (memo[i][m] != -1) return memo[i][m];
		int ans = 1e9, sum = 0;
		for (int j = i; j < nums.size(); j++) {
			// i....j
			sum += nums[j];
			ans = min(ans, max(sum, dp(j + 1, nums, m - 1)));
		}
		return memo[i][m] = ans;
	}
	int splitArray(vector<int>& nums, int m) {
		memo.resize(nums.size() + 1, vector<int>(m + 1, -1));
		return dp(0, nums, m);
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	Solution H;
	vector<int> a = {1, 2, 3, 4, 5};
	cout << H.splitArray(a, 2);


	return 0;
}
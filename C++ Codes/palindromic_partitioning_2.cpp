#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	string s;
	vector<vector<int>> memo;
	vector<int> memo1;

	// memoising?
	// O(n*n)
	bool is_palindrome(int i, int j) {
		if (i == j) return true;
		if (i == j - 1) return (s[i] == s[j]);
		if (memo[i][j] != -1) return memo[i][j];
		return memo[i][j] = is_palindrome(i + 1, j - 1) && (s[i] == s[j]);
	}

	// states O(n)
	int dp(int i) {
		if (i == s.size()) return 0;

		if (memo1[i] != -1) return memo1[i];

		int ans = INT_MAX;
		// O(n)
		for (int j = i; j < s.size(); j++) {
			if (is_palindrome(i, j)) {
				ans = min(ans, dp(j + 1));
			}
		}
		ans += 1;
		return memo1[i] = ans;
	}

	int minCut(string s) {
		this->s = s;
		memo.resize(s.size(), vector<int>(s.size(), -1));
		memo1.resize(s.size(), -1);
		return dp(0) - 1;
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	string s;
	cin >> s;

	Solution H;
	cout << H.minCut(s);



	return 0;
}
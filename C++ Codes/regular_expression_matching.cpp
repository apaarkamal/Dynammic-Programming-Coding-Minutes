#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	string s, p;
	vector<vector<int>> memo;
	int dp(int i, int j) {
		if (i == s.size() && j == p.size()) return true;
		if (j == p.size()) return false;
		// memoisation
		int &ans = memo[i][j];
		if (ans != -1) return ans;
		ans = 0;

		if (j + 1 < p.size() && p[j + 1] == '*') {
			// when character matches due to *
			if (i < s.size() && (s[i] == p[j] || p[j] == '.')) {
				ans |= dp(i + 1, j);
			}
			// no character matches
			ans |= dp(i, j + 2);
		}
		else {
			if (i < s.size() && (s[i] == p[j] || p[j] == '.')) {
				ans |= dp(i + 1, j + 1);
			}
		}

		return ans;
	}
	bool isMatch(string s, string p) {
		this->s = s;
		this->p = p;
		memo.resize(s.size() + 1, vector<int>(p.size() + 1, -1));
		return dp(0, 0);
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	string s, p;
	cin >> s >> p;

	Solution H;
	cout << H.isMatch(s, p);

	return 0;
}
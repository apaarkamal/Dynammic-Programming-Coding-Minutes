#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	string s, p;
	vector<vector<int>> memo;
	bool dp(int i, int j) {
		if (i == s.size() && j == p.size()) return true;
		if (j == p.size()) return false;
		// if (i == s.size()) ;

		if (memo[i][j] != -1) return memo[i][j];

		bool ans = false;

		if (i < s.size() && s[i] == p[j]) {
			ans |= dp(i + 1, j + 1);
		}
		else if (p[j] == '?') {
			if (i == s.size()) {
				return false;
			}
			else {
				ans |= dp(i + 1, j + 1);
			}
		}
		else if (p[j] == '*') {
			if (i < s.size()) {
				ans |= dp(i + 1, j);
			}
			ans |= dp(i, j + 1);
		}
		return memo[i][j] = ans;
	}
	bool isMatch(string ss, string pp) {
		this->s = ss;
		this->p = pp;
		memo.resize(ss.size() + 1, vector<int> (pp.size() + 1, -1));
		// 2d array structure filled with -1s
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
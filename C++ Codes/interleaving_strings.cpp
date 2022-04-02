#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	string s1, s2, s3;
	vector<vector<int>> memo;
	int dp(int i, int j) {


		int k = i + j;
		if (k == s3.size()) return true;

		if (memo[i][j] != -1) return memo[i][j];

		int ans = 0;
		if (i < s1.size() && s1[i] == s3[k]) {
			ans |= dp(i + 1, j);
		}

		if (j < s2.size() && s2[j] == s3[k]) {
			ans |= dp(i, j + 1);
		}

		return memo[i][j] = ans;
	}
	bool isInterleave(string s1, string s2, string s3) {
		this->s1 = s1;
		this->s2 = s2;
		this->s3 = s3;
		if (s1.size() + s2.size() != s3.size()) return false;
		memo.resize(s1.size() + 1, vector<int>(s2.size() + 1, -1));
		return dp(0, 0);
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	string s1, s2, s3;
	cin >> s1 >> s2 >> s3;

	Solution H;
	cout << H.isInterleave(s1, s2, s3);

	return 0;
}
#include<bits/stdc++.h>

using namespace std;

class Solution {
public:
	string s;
	map<int, vector<vector<string>>> mp;

	bool is_palindrome(int i, int j) {
		while (i <= j) {
			if (s[i] != s[j]) return false;
			i++; j--;
		}
		return true;
	}

	vector<vector<string>> dp(int i) {
		if (i == s.size()) return vector<vector<string>>();

		if (mp.count(i)) return mp[i];

		vector<vector<string>> ans;

		for (int j = i; j < s.size(); j++) {
			if (is_palindrome(i, j)) {

				vector<vector<string>> res = dp(j + 1);
				string substring = s.substr(i, j - i + 1);

				for (auto &x : res) {
					x.insert(x.begin(), substring);
				}

				if (res.empty()) {
					res.push_back({substring});
				}

				for (auto x : res) {
					ans.push_back(x);
				}
			}

		}

		return mp[i] = ans;
	}

	vector<vector<string>> partition(string s) {
		this->s = s;
		return dp(0);
	}
};

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	string s;
	cin >> s;

	Solution H;
	vector<vector<string>> res = H.partition(s);

	for (auto x : res) {
		for (auto y : x) {
			cout << y << " ";
		} cout << '\n';
	}

	return 0;
}
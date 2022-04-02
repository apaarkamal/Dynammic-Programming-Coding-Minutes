#include<bits/stdc++.h>

using namespace std;

string s, t;

int lcs(int i, int j) {
	if (i == s.size() && j == t.size()) return 0;
	if (i == s.size()) return 0;
	if (j == t.size()) return 0;

	int ans = 0;
	if (s[i] == t[j]) {
		ans = 1 + lcs(i + 1, j + 1);
	}
	else {
		ans = max(lcs(i, j + 1), lcs(i + 1, j));
	}

	return ans;
}

int main() {

#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	cin >> s >> t;

	cout << lcs(0, 0);

}
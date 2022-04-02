#include<bits/stdc++.h>
#define int long long int
using namespace std;

#define db(...) __f(#__VA_ARGS__, __VA_ARGS__)

template <typename Arg1>
void __f(const char* name, Arg1&& arg1) { cout << name << " : " << arg1 << '\n'; }
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
	const char* comma = strchr(names + 1, ',');
	cout.write(names, comma - names) << " : " << arg1 << " | "; __f(comma + 1, args...);
}


const int N = 16;
int a[N][N], n;

int give_score(int mask, int bit) {
	int score = 0;
	for (int i = 0; i < n; i++) {
		if ((mask >> i) & 1) {
			score += a[i][bit];
		}
	}
	return score;
}

int32_t main()
{
	ios_base:: sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}

	// total value,
	// set of previous group
	pair<int, int> dp[1 << n];

	dp[0] = {0, 0};

	for (int mask = 1; mask < (1 << n); mask++) {
		dp[mask] = { -1e18, 0};
		for (int bit = 0; bit < n; bit++) {
			if ((mask >> bit) & 1) {
				int new_mask = mask ^ (1 << bit);

				// start new group
				if (dp[new_mask].first > dp[mask].first) {
					dp[mask] = {dp[new_mask].first, 1 << bit};
				}

				// either add current element
				// to previous group
				int score = give_score(dp[new_mask].second, bit);
				if (score + dp[new_mask].first >= dp[mask].first) {
					dp[mask] = {score + dp[new_mask].first, dp[new_mask].second | (1 << bit)};
				}
			}
		}
		// cout << mask << " " << dp[mask].first << " " << dp[mask].second << '\n';
	}

	cout << dp[(1 << n) - 1].first;




	return 0;
}
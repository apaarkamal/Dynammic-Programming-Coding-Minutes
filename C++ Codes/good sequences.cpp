#include<bits/stdc++.h>

using namespace std;

const int N = 1e5 + 1;

int dp_prime[N];

// O(sqrt(n))
vector<int> give_prime_divisors(int n) {
	vector<int> div;
	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) {
			div.push_back(i);
			while (n % i == 0) n /= i;
		}
	}
	if (n > 1) div.push_back(n);
	return div;
}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	int n;
	cin >> n;
	int a[n];

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	for (int i = 0; i < n; i++) {
		vector<int> prime_div = give_prime_divisors(a[i]);

		int best_ending = 0;
		for (auto x : prime_div) {
			best_ending = max(best_ending, dp_prime[x]);
		}

		for (auto x : prime_div) {
			dp_prime[x] = best_ending + 1;
		}
	}

	cout << *max_element(dp_prime, dp_prime + N);










	return 0;
}
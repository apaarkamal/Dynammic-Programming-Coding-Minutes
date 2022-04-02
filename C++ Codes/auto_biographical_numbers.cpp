#include<bits/stdc++.h>

using namespace std;

const int N = 20;

int length, num[N], cnt[N];

void auto_bio_graphical_number(int index) {

	// base case
	if (index == length) {
		for (int i = 0; i < length; i++) {
			if (num[i] != cnt[i]) return;
		}

		for (int i = 0; i < length; i++) {
			cout << num[i];
		} cout << '\n';

		return;
	}

	for (int _num = 0; _num < length; _num++) {
		num[index] = _num;
		cnt[_num]++;

		auto_bio_graphical_number(index + 1);

		// back tracking
		cnt[_num]--;
		num[index] = -1;

	}

}

int main()
{
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

	length = 4;
	auto_bio_graphical_number(0);


	return 0;
}
#include <iostream>
#include <algorithm>

using namespace std;

void bubblesort(int items[], int n) {
	for (int i = 0; i < n; i++) {
		bool flag = false;
		for (int j = 0; j < n - i - 1; j++)
		{
			if (items[j] > items[j + 1]) {
				swap(items[j], items[j + 1]);
				flag = true;
			}		
		}
		if (!flag) break;
	}
}

void select_sort(int items[], int n) {
	for (int i = 0; i < n; i++) 
	{
		int min_i = i;
		for (int j = i + 1; j < n; j++) {
			if (items[j] < items[min_i])
				min_i = j;
		}
		if (min_i != i)
			swap(items[min_i], items[i]);
	}
}

void insert_sort(int items[], int n) {
	for (int i = 1; i < n; i++) {
		int insert_pos = i;
		while (insert_pos > 0 && items[insert_pos - 1] > items[insert_pos]) {
			swap(items[insert_pos], items[insert_pos - 1]);
			insert_pos--;
		}
	}
}

void quick_sort(int items[], int left, int right){
	if (left >= right) return;
	int i = left - 1, j = right + 1, x = items[left + right >> 1];
	while (i < j)
	{
		do i++; while (items[i] < x);
		do j--; while (items[j] > x);
		if (i < j) swap(items[i], items[j]);
	}
	quick_sort(items, left, j);
	quick_sort(items, j + 1, right);
}


int main() {
	int items[6] = { 2,5,8,9,10,1 };
	bubblesort(items, 6);
	for (int i = 0; i < 6; i++)
		cout << items[i] << " ";
	return 0;
}
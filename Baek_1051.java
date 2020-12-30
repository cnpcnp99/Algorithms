#include <iostream>
#include <string>
using namespace std;

int smallerSize(int N, int M) {
	if (N < M) return N;
	return M;
}

int main() {
	// get input Numbers and make 2nd array(N: row, M: col)
	int N, M;
	cin >> N >> M;
	int** arr = new int*[N];
	for (int i = 0; i < N; i++)
		arr[i] = new int[M];
	// Input is little bit tricky. So We need to change input to the seperate number
	// And then we can put the numbers into array.
	string* strArr = new string[N];
	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		strArr[i] = temp;
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int temp = strArr[i][j] - '0';
			arr[i][j] = temp;
		}
	}
	// The maximum length of square is derieved from smaller one between row and column.
	int maxLength = smallerSize(N, M);
	// from the (0, 0), check sub-square if it is square or not.
	int answer = 0;
	for (int i = 0; i < maxLength; i++) {
		for (int j = 0; j < N - i; j++) {
			for (int k = 0; k < M - i; k++) {
				if (arr[j][k] == arr[j + i][k] && arr[j][k] == arr[j][k + i] && arr[j][k] == arr[j + i][k + i])
					answer = (i + 1) * (i + 1);
			}
		}
	}
	cout << answer << endl;
	
	
	system("pause");
	return 0;
}

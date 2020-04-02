#include <iostream>
#include <vector>

using namespace std;

/*大整数乘法:一个大整数乘以一个较小的整数 A * b
1.首先将大整数按照倒序的方式存入数组中.
2.从各位依次将乘以小整数 A[i] * b 同时加上上一个进位 t 即 t = A[i] * b + t
	将t对10求余即得相应为的数字，t / 10得进位.
*/
vector<int> mul(vector<int> &A, int b)
{
    int t = 0;
    vector<int> C;
    for(int i = 0; i < A.size() || t; i++)
    {
        if(i < A.size()) t = t + A[i] * b;
        C.push_back(t % 10);
        t /= 10;
    }
    return C;
}

int main()
{  
    string a;
    int b;
    cin >> a >> b;
    vector<int> A;

    for(int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');

    auto C = mul(A, b);

    for(int i = C.size() - 1; i >= 0; i--) printf("%d", C[i]);

    return 0;
}
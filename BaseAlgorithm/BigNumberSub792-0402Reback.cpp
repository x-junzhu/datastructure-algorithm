#include <iostream>
#include <vector>

using namespace std;

bool cmp(vector<int> &A, vector<int> &B)
{
    if(A.size() != B.size()) return A.size() > B.size();
    for(int i = B.size() - 1; i >= 0; i--)
    {
        if(A[i] != B[i]) return A[i] > B[i];
    }
    return true;
}

/*大整数减法
1.与大整数加法类似，首先将大整数按照倒序存储在数组中.
2.比较两个大整数的大小，始终保持用大数减去小数.
3.t为借位，从低位开始作差，对应位相减后有两种可能：
	如果t = A[i] - B[i] > 0 无须向高位借1,此时只需将t存入结果数组C；
	如果t = A[i] - B[i] < 0 则需要向高位借1，（t + 10）% 10 存入结果数组C中，再将借位置为1，
	表示向高位借1.
*/
vector<int> sub(vector<int> &A, vector<int> &B)
{
    int t = 0;
    vector<int> C;
    for(int i = B.size() - 1; i >= 0; i--)
    {
        t = A[i] - t;
        if(i < B.size()) t -= B[i];
        C.push_back((t + 10) % 10);
        if(t < 0) t = 1;
        else t = 0;
    }
    while(C.size() > 1 && C.back() == 0) C.pop_back();
    return C;
}

int main()
{
    string a, b;
    cin >> a >> b;
    vector<int> A, B, C;
    for(int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    for(int i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');
    if(cmp(A, B))
    {
        C = sub(A, B);
        for(int i = C.size() - 1; i >= 0; i--) printf("%d", C[i]);
    }
        
    else
    {
        C = sub(B, A);
        printf("-");
        for(int i = C.size() - 1; i >= 0; i--) printf("%d", C[i]);
    } 
    system("pause");
    return 0;
}
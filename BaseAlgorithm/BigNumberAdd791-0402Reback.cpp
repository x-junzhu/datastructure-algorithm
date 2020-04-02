#include <iostream>
#include <vector>

using namespace std;

/*大整数相加A+B
1.存储大整数：将大整数倒序（即最高位存在数组下标为0的位置）放入数组中（两个数相加可能存在
	进位，如果顺序存储进位时需要移动整个数组，费时）
2.手工相加：使用一个数字t保存当前位置包括进位之和（比如166+88，十位相加时t的值
	为8+6+1（1是个位的进位）），如果最后t不为0则表明倒数第二位有进位，即在最高为后再补一个1
*/
vector<int> add(vector<int> &A, vector<int> &B)
{
    vector<int> res;
    int t = 0;
    for(int i = 0; i < A.size() || i < B.size(); i++)
    {   
        if(i < A.size()) t += A[i];
        if(i < B.size()) t += B[i];
        res.push_back(t % 10);
        t /= 10;
    }
    if(t) res.push_back(1);
    return res;
}

int main()
{
    string a, b;
    vector<int> A, B;
    cin >> a >> b;
    for(int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    for(int i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');

    auto C = add(A, B);

    for(int i = C.size() - 1; i >= 0; i--) printf("%d", C[i]);
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/*大整数除法 A / b
1.同样首先将大整数按照倒序的方式存入数组中.
2.除法运算时从高位开始，将上一次运算的余数乘以10加上该位的值，即r * 10 + A[i]
	则该位对应的商是r / b, 余数r为 r % b
3.因为除法运算时从高位开始的，所以结果数组是从高位排列的，所以最后结果需要倒置,最后在去掉
	前导零.其中r为余数，通过引用传出.
*/
vector<int> div(vector<int> &A, int b, int &r)
{
    vector<int> res;
    r = 0;
    for(int i = A.size() - 1; i >= 0; i--)
    {
        r = r * 10 + A[i];
        res.push_back(r / b);
        r %= b;
    }
    reverse(res.begin(), res.end());
    while(res.size() > 1 && res.back() == 0) res.pop_back();
    return res;
}

int main()
{
    string a;
    int b, r;
    vector<int> A;
    cin >> a >> b;
    for(int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');

    auto C = div(A, b, r);

    for(int i = C.size() - 1; i >= 0; i--) printf("%d", C[i]); 
    cout << endl << r << endl;
    system("pause");
    return 0;
}
#include <iostream>
#include "SortTestHelper.h"

using namespace std;

/*选择排序的实现*/
template <typename T>
void selectionSort(T* arr, int n){
    //大的循环执行n-1次
    for (int i = 0; i < n - 1 ; ++i) {
        int minIndex = i;
        //每次找出[i,n)区间内的最小值
        for (int j = i + 1; j < n; ++j) {
            if ( arr[j] < arr[minIndex])
                minIndex = j;
        }
        swap(arr[i], arr[minIndex]);
    }
}


int main() {
    int n = 100000;
    int* arr = SortTestHelper::generateRandomArray(n, 0, n);
    SortTestHelper::testSort("SelectionSort", selectionSort, arr, n);
    delete[] arr;
    return 0;
}
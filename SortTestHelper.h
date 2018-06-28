//
// Created by andy on 18-6-28.
//

#ifndef SORTING_BASIC_SORTTESTHELPER_H
#define SORTING_BASIC_SORTTESTHELPER_H

#include <iostream>
#include <cassert>


using namespace std;

namespace SortTestHelper{

    //生成n个元素的随机数组，元素的取值范围在[rangeL, rangeR]
    int* generateRandomArray(int n, int rangeL, int rangeR){
        assert(rangeR > rangeL);
        int* arr = new int[n];
        srand(time(NULL));
        for (int i = 0; i < n; ++i)
            arr[i] = rand() % (rangeR - rangeL + 1) + rangeL;
        return arr;
    }

    //打印数组的所有内容
    template <typename T>
    void printArray(T* arr, int n){
        for (int i = 0; i < n; ++i)
            cout<<arr[i]<<" ";
        cout<<endl;

        return;
    }

    //判断arr数组是否有序
    template <typename T>
    bool isSorted(T* arr, int n){
        for ( int i = 0; i < n - 1; ++i){
            if ( arr[i] > arr[i + 1] )
                return false;
        }
        return true;
    }

    // 测试sort排序算法排序arr数组所得到结果的正确性和算法运行时间
    template <typename T>
    void testSort(const string &sortName, void(*sort)(T*, int), T* arr, int n){

        clock_t startTime = clock();
        sort(arr, n);
        clock_t endTime = clock();

        assert(isSorted(arr, n));
        cout<<sortName<<" : " << double(endTime - startTime) / CLOCKS_PER_SEC << "s." << endl;

        return;
    }



}

#endif //SORTING_BASIC_SORTTESTHELPER_H

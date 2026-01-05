package SortAlgorithm;

import java.util.Arrays;

/**
 * 稳定
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        //将数组分为已排序和未排序两部分，每次取未排序部分的
        //第一个元素插入(实际上是不断交换)到已排序部分的正确位置

        int n = arr.length;

        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

    }
    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前：" + Arrays.toString(arr));

        insertionSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}

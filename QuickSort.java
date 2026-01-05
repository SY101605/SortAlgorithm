package SortAlgorithm;

import java.util.Arrays;

/**
 * 不稳定
 * 选择一个基准元素，将数组分为两部分：小于基准和大于基准的，然后递归地
 * 对这两部分排序。
 * 选择的基准元素就是inplace的
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high){
        if (low < high){

            int pivotIndex = partitionHoare(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];  //choose the last element as pivot.
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partitionHoare(int[] arr, int low, int high){
        //choose the middle element as pivot
        int pivot = arr[low + (high - low) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true){
            do{
                i++;
            }while (arr[i] < pivot);

            do{
                j--;
            }while (arr[j] > pivot);

            if (i >= j){
                return j;
            }

            swap(arr, i, j);
        }


    }

    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前：" + Arrays.toString(arr));

        quickSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}

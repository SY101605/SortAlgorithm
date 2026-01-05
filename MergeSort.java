package SortAlgorithm;

import java.util.Arrays;

/**
 * 稳定
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);  //the left part
        mergeSort(arr, mid + 1, right); //the right part

        merge(arr, left, mid, right);   //merge the sorted arrays
    }

    private static void merge(int[] arr, int left, int mid, int right){

        int temp[] = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        //merge two sorted arrays
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= right){
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前：" + Arrays.toString(arr));

        mergeSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}

package SortAlgorithm;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr){
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for (int i = n -1; i> 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //if the leftChildren larger than rootNode
        if (left < n && arr[left] > arr[largest]){
            largest = left;
        }
        //if the rightChildren larger than rootNode
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            swap(arr, i, largest);

            heapify(arr, n, largest);
        }
    }

    public static int deleteRoot(int[] arr, int n){
        if (n <= 0){
            return -1;
        }
        int root = arr[0];
        arr[0] = arr[n - 1];
        n--;

        heapify(arr, n, 0);
        return root;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
      /* int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前：" + Arrays.toString(arr));
        int length = arr.length;
        int[] temp = new int[length];
        for (int i = length / 2 - 1; i >= 0; i--){
            heapify(arr, length, i);
        }

        for (int i = length - 1; i >= 0; i--){
            int root = deleteRoot(arr, length);
            temp[i] = root;
            length--;
        }
        System.out.println("排序后：" + Arrays.toString(temp));
    }*/
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}

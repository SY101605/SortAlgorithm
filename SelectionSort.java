package SortAlgorithm;

/**
 * 不稳定
 */
public class SelectionSort {
    //每次从未排序部分选择最小元素，放到已排序部分的末尾
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){

            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }

    public static int findSmallest(int[] arr){
        int n = arr.length;
        int smallest = arr[0];
        int index = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] < smallest){
                smallest = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
       //对findSmallest的测试
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int result = findSmallest(arr);
        System.out.println(result);
    }
}

package algorithms;

import java.util.Arrays;

public class Sort {

    public static void arraySort(int[] arr) {
        /*
         * Arrays는 7 미만의 작은 배열의 경우 insertion sort를 하고,
         * integer 등의 정수는 merge sort를
         * float 등의 부동 소수점 수는 quick sort를 합니다.
         *
         * Java8 부터는 내부적으로 사용하는 Sort가 다릅니다 (DualPivotQuicksort.java)
         */
        Arrays.sort(arr);
    }

    public static  void arrayParallelSort(int[] arr) {
        /**
         * Data 가 2500개보다 적은 경우, 그냥 sort가 나음
         * Data 가 2500개와 비슷한 경우, sort와 parallelSort 사이에 성능차이 없음
         * Data 가 2500개보다 많은 경우, parallelSort 성능이 나아지기 시작
         */
        Arrays.parallelSort(arr);
    }

    public static  void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int aux = i - 1;

            while ((aux >= 0) && (arr[aux] > temp)) {
                arr[aux + 1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = temp;
        }
    }

    public static  void qsort1st(int[] arr) {
        qsort1stImpl(arr, 0, arr.length - 1);
    }

    private static  void qsort1stImpl(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start + 1;
        int right = end;

        while (left < right) {
            while (arr[start] <= arr[right] && start < right) {
                right--;
            }

            while (arr[start] >= arr[left] && left < right) {
                left++;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

        if (arr[start] > arr[right]) {
            swap(arr, start, right);
        }

        qsort1stImpl(arr, start, right - 1);
        qsort1stImpl(arr, right + 1, end);
    }

    public static  void qsort2nd(int[] arr) {
        qsort2ndImpl(arr, 0, arr.length - 1);
    }

    public static void qsort2ndImpl(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[start]) {
                swap(arr, ++left, i);
            }
        }
        swap(arr, start, left);

        qsort2ndImpl(arr, start,left - 1);
        qsort2ndImpl(arr,left + 1, end);
    }

    public static void qsort3rd(int[] arr) {
        qsort3rdImpl(arr, 0, arr.length - 1);
    }

    private static void qsort3rdImpl(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];

        do {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        } while (left <= right);

        if (start < right) {
            qsort3rdImpl(arr, start, right);
        }

        if (end > left) {
            qsort3rdImpl(arr, left, end);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void countingSort(int[] input) {
        // Find the maximum number to know number of digits
        int max = getMax(input);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; (max / exp) > 0; exp *= 10) {
            count(input, exp);
            if (exp >= 1000000000) {
                break;
            }
        }
    }

    private static int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void count(int[] arr, int exp) {
        int length = arr.length;
        int output[] = new int[length]; // output array
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (int i = 0; i < length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        System.arraycopy(output, 0, arr, 0, output.length);
    }
}

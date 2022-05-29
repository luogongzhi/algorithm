package com.lgz.algorithm.array;

/**
 * @author lgz
 * @ClassName BisectionMethod.java
 * @description 二分法
 * @since 2022/04/11 15:07:42
 */
public class BisectionMethod {

    /**
     * 找到 arr 相邻不相等的目标索引
     * @param arr 相邻数不相等
     * @return 目标索引
     */
    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int N = arr.length;
        if (N == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 0;
        int R = N - 1;
        //此时 L ~ R 绝对有局部最小
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                }else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    /**
     * 生产随机数组，且相邻数不相等
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do{
                    arr[i] = (int) (Math.random() * maxValue);
                }while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * 校验 oneMinIndex() 结果
     * @param arr
     * @param minIndex
     * @return
     */
    public static boolean oneMinIndexValid(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    /**
     * <= num 的最右
     *
     * @param arr 有序数组
     * @param num
     * @return 目标的索引
     */
    public static int mostRightNoMoreNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 校验 mostRightNoMoreNumIndex() 结果
     *
     * @param arr
     * @param value
     * @return
     */
    public static int mostRightNoMoreNumIndexValid(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * >= num 的最左
     *
     * @param arr 有序数组
     * @param num
     * @return 目标的索引
     */
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 校验 mostLeftNoLessNumIndex() 结果
     *
     * @param arr
     * @param value
     * @return
     */
    public static int mostLeftNoLessNumIndexValid(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法查找目标是否存在
     *
     * @param arr
     * @param num
     * @return arr 中是否有 num
     */
    public static boolean bisectionFind(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    /**
     * 校验 bisectionFind() 结果
     *
     * @param sortedArr
     * @param num
     * @return arr 中是否有 num
     */
    public static boolean bisectionFindValid(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 随机生成数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 20;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
/*           int[] arr = generateRandomArray(maxSize, maxValue);
           Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//            if (find(arr, value) != bisectionFind(arr, value)) {
            if (mostRightNoMoreNumIndexValid(arr, value) != mostRightNoMoreNumIndex(arr, value)) {
                System.out.println(mostRightNoMoreNumIndexValid(arr, value));
                System.out.println(mostRightNoMoreNumIndex(arr, value));
                System.out.println(value);
                System.out.println(Arrays.toString(arr));
                succeed = false;
                break;
            }*/

            int[] arr = randomArray(maxSize, maxValue);
            int ans = oneMinIndex(arr);
            if (!oneMinIndexValid(arr, ans)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

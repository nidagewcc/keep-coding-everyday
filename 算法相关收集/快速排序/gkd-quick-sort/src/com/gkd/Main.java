package com.gkd;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86};

        quickSort1(arr, 0, 9);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] s, int l, int r) {

        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;

            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }

    // 。。。 。。。
    private static void quickSort1(int[] arr, int l, int r) {

        int i = l, j = r, x = arr[l];
        while (i < j) {

            while (arr[j] > x) {
                j--;
            }

            arr[j] = x;
            i++;

            while (arr[i] <= x) {
                i++;
            }

            arr[i] = x;
            j--;

            if (i == j) {
                arr[i] = x;
            }

            quickSort1(arr, l, i - 1);
            quickSort1(arr, i + 1, r);
        }

    }
}

package com.gkd;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86};

        quickSort1(arr, 0, 9);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] s, int left, int right) {

        if (left < right) {
            // x选为基准数
            int i = left, j = right, x = s[left];
            while (i < j) {

                // 从右向左找第一个小于x的数，找到之后[j]指针-1
                while (i < j && x <= s[j]) {
                    j--;
                }

                // 并把找到的数字放到开始的基准数位置
                if (i < j) {
                    s[i++] = s[j]; // 换值过程中i也++了，所以低位指针也向右移动了一位
                }

                // 然后再从左向右找第一个大于等于x的数，找到之后指针+1
                while (i < j && x >= s[i]) {
                    i++;
                }

                // 并把找到的数字放到
                if (i < j) {
                    s[j--] = s[i];
                }

            }
            s[i] = x;
            System.out.println(Arrays.toString(s));
            // 递归调用
            quickSort(s, left, i - 1);
            quickSort(s, i + 1, right);


        }
    }

    // 背诵写一遍
    private static void quickSort1(int[] arr, int left, int right) {

        if (left < right) {
            int i = left, j = right, x = arr[i];
            while (i < j) {
                while (i < j && x <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && x >= arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }

            arr[i] = x;

            System.out.println(Arrays.toString(arr));
            quickSort1(arr, left, j - 1);
            quickSort1(arr, i + 1, right);
        }
    }
}

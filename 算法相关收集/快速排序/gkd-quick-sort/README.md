### 冒泡排序

选取一个基准数，然后从右边开始查找比它小的，再从左边查找比它大的。再利用递归特性，分别递归左半部分和右半部分进行排序，最终达到排序效果

程序示例：
```java
public static void main(String[] args) {
        int[] arr = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86};

        quickSort(arr, 0, 9);

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

            // 递归调用
            quickSort(s, left, i - 1);
            quickSort(s, i + 1, right);
        }
    }
```

时间复杂度分析
// TODO

package com.zyp.interview.demo.algorithm.array;

import java.util.Arrays;

/**
 * @ClassName Rotate
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
 * 尽可能相处更多的解决方案，至少有三种不同的方法可以解决这个问题
 * 你可以使用空间复杂度O(1)的原地算法解决这个问题吗？
 * <p>
 * 解法1：
 * 新建一个相同数量的数组，将原数组的元素放到新数组的位置，就是(i+k) %n的位置，然后将新数组拷贝回原数组
 * <p>
 * 解法2：
 * 假设从0开始，将 int temp =nums[0];然后找到0位置后移后的位置int x = (0 + k) % n;再将x放到平移后的位置，直到x=0;
 * 一次循环下来，会有数没有遍历到，再从0位置的下一个位置开始循环
 * 循环多少次呢？
 * n(数组的元素个数)和k的最大公约数次。
 * <p>
 * <p>
 * 解法3：
 * 先说一个事实：
 * 若我们将元素向右移动k个位置，那么元素尾部 (k%n) 个元素会到数组的头部，并且相对位置不变，其余元素向后移动(k%n)个位置。
 * 该方法：
 * 将整个数组翻转之后，0～k-1个元素翻转，k～n-1的元素翻转，这样就实现了最后的答案
 * @Author zhangyanping
 * @Date 2022/2/18 13:58
 * @Version 1.0
 */
public class Rotate {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2,3,4,5,6,7};
        rotate3(nums, 3);
        System.out.println(Arrays.toString(nums));
    }


    public static void rotate1(int[] nums, int k) {
        int n = nums.length;

        int[] ints = new int[n];
        for (int i = 0; i < nums.length; i++) {
            ints[(i + k) % n] = nums[i];
        }
        System.arraycopy(ints, 0, nums, 0, ints.length);
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        //求出n和k的最大公约数
        int gcd = gcd(n, k);
        for (int i = 0; i < gcd; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (current != i);
        }
    }

    public static void rotate3(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        if (n < 2 || k == 0) {
            return;
        }
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * 翻转数组
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void reverse(int[] nums, int i, int j) {
        int left = i;
        int right = j;
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 求出两个数的最大公约数
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        while (n != 0) {
            int b = m % n;
            m = n;
            n = b;
        }
        return m;
    }
}

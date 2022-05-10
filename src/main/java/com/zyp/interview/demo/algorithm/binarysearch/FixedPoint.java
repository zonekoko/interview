package com.zyp.interview.demo.algorithm.binarysearch;

/**
 * @ClassName FixedPoint
 * @Description 给定已经按升序排列、由不同整数组成的数组 arr，返回满足 arr[i] == i 的最小索引 i。
 * 如果不存在这样的 i，返回 -1。
 * @Author zhangyanping
 * @Date 2022/1/26 15:42
 * @Version 1.0
 */
public class FixedPoint {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6,7};

        int i = fixedPoint(arr);
        System.out.println(i);
    }

    public static int fixedPoint(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int result = -1;
        int right = arr.length - 1;
        while (left < right){
            int mid = (left + right) >>> 1;
            if(arr[mid] == mid){
                result = mid;
                right = mid;
            }else if(arr[mid] > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return result;
    }
}

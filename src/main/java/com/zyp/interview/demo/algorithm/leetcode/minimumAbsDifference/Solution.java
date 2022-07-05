package com.zyp.interview.demo.algorithm.leetcode.minimumAbsDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你个整数数组 arr，其中每个元素都 不相同。
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
//
//
//
// 示例 1：
//
// 输入：arr = [4,2,1,3]
//输出：[[1,2],[2,3],[3,4]]
//
//
// 示例 2：
//
// 输入：arr = [1,3,6,10,15]
//输出：[[1,3]]
//
//
// 示例 3：
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
//输出：[[-14,-10],[19,23],[23,27]]
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 10^5
// -10^6 <= arr[i] <= 10^6
//
// Related Topics 数组 排序 👍 97 👎 0
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/7/4 13:23
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,3,6,10,15};
        List<List<Integer>> lists = minimumAbsDifference(arr);
        System.out.println(lists);
    }



    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minDif = Integer.MAX_VALUE;
        int index = 1;
        while (index < arr.length){
            int delta = Math.abs(arr[index] - arr[index - 1]);
            if(delta < minDif){
                result.clear();
                List<Integer> resultList = new ArrayList<>();
                resultList.add(arr[index - 1]);
                resultList.add(arr[index]);
                result.add(resultList);
                minDif = Math.min(delta,minDif);
            }else if(delta == minDif){
                List<Integer> resultList = new ArrayList<>();
                resultList.add(arr[index - 1]);
                resultList.add(arr[index]);
                result.add(resultList);
            }
            index++;
        }
        return result;
    }
}

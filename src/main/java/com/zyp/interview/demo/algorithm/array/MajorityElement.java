package com.zyp.interview.demo.algorithm.array;

/**
 * @ClassName MajorityElement
 * @Description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 思路：
 * 1.定义变量major表示票数最多的候选人，定义count表示当前候选人的票数
 * 2.遍历数组，当count = 0 时，说明当前没有候选人，就把当前元素作为major，count=1说明，这个元素有了一票，
 * 如果count不为0，看当前元素是否和major相同，相同count+1，票数+1，不同count-1，票数-1
 * @Author zhangyanping
 * @Date 2022/2/18 09:19
 * @Version 1.0
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //票数最多的候选人
        int major = 0;
        //票数最多的候选人的票数
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else {
                count += (major == num ? 1 : -1);
            }
        }
        return major;
    }
}

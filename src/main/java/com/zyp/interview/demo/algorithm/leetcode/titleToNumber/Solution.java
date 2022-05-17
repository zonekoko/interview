package com.zyp.interview.demo.algorithm.leetcode.titleToNumber;
//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
//
// 例如：
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
// 示例 1:
//
//
//输入: columnTitle = "A"
//输出: 1
//
//
// 示例 2:
//
//
//输入: columnTitle = "AB"
//输出: 28
//
//
// 示例 3:
//
//
//输入: columnTitle = "ZY"
//输出: 701
//
//
//
// 提示：
//
//
// 1 <= columnTitle.length <= 7
// columnTitle 仅由大写英文组成
// columnTitle 在范围 ["A", "FXSHRXW"] 内
//
// Related Topics 数学 字符串
/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/16 11:04
 * @Version 1.0
 */
public class Solution {


    public static void main(String[] args) {
        String columnTitle = "AZ";
        int i = titleToNumber(columnTitle);
        System.out.println(i);
    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i == 0){
                result = chars[i] - 'A' + 1;
            }else {
                result = result * 26 + chars[i] - 'A' + 1;
            }
        }
        return result;
    }
}

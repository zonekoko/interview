package com.zyp.interview.demo.algorithm.recursive;

/**
 * @ClassName ConvertToLetterString
 * @Description 规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111"，就可以转化为"AAA"、"KA"和"AK"。
 * 给定一个只有数字字符组成的字符串str，
 * 返回有多少种转化结果。
 * @Author zhangyanping
 * @Date 2022/2/21 15:56
 * @Version 1.0
 */
public class ConvertToLetterString {

    public static void main(String[] args) {
        String str = "11111";
        convertToLetterString(str);
    }

    public static int convertToLetterString(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    public static int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }

        if (chars[i] == '1') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length) {
                res += process(chars, i + 2);
                return res;
            }
        }

        if (chars[i] == '2') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '6')) {
                res += process(chars, i + 2);
            }
            return res;
        }

        return process(chars, i + 1);
    }
}

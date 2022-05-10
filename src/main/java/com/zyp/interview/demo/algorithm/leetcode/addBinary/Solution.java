package com.zyp.interview.demo.algorithm.leetcode.addBinary;

/**
 * @ClassName Solution
 * @Description 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * @Author zhangyanping
 * @Date 2022/4/19 09:51
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        System.out.println(s);

//        char a = 1;
//        char b = 1;
//        char c = 0;
//        int i = a + b + c;
//        System.out.println(i);

    }

    /**
     * 思路：用一个变量(carry)存进位,从后往前变量，得到a(int),b(int).
     *
     * 如果a+b+carry=3，说明这一位是1。如果a+b+carry=2，说明这一位是0。如果a+b+carry<2,说明没有产生进位，将进位改成0
     * 最后如果进位为1(说明有进位)，在前面加1
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a,String b){


        //将a,b转成字符数组aArray和bArray
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        //取出aArray和bArray的最大下标
        int indexA = aChars.length - 1;
        int indexB = bChars.length - 1;

        //新数组的元素个数要和aArray和bArray中较多的元素一致
        int max = Math.max(indexA,indexB);
        int[] resultArray = new int[max + 1];

        StringBuilder sb = new StringBuilder();

        //定义进位，初始为0
        int carry = Character.getNumericValue('0');

        //当aArray和bArray都没有循环完
        while (indexA >= 0 || indexB >= 0){
            int aChar;
            int bChar;
            if(indexA < 0){
                //如果aArray循环完了，对应的值就是0
                aChar = 0;
            }else{
                //没有循环完就是对应的值
                aChar = Character.getNumericValue(aChars[indexA]);
            }
            if(indexB < 0){
                //如果bArray循环完了，对应的值就是0
                bChar = 0;
            }else {
                //没有循环完就是对应的值
                bChar = Character.getNumericValue(bChars[indexB]);
            }
            //用aArray和bArray对应的值加上进位  =i
            int i = aChar + bChar + carry;

            if(i >= 2){
                //如果i>=2说明产生进位了，carry要设置成1
                carry = 1;
                if(i == 2){
                    //如果i=2，说明产生一位进位，新数组对应的值是0
                    resultArray[max] = 0;
                }else if(i == 3){
                    //如果i=3，说明产生二位进位，新数组对应的值是1
                    resultArray[max] = 1;
                }
            }else{
                //如果i<2说明没有产生进位，新数组对应的值就是i，进位carry设成0
                resultArray[max] = i;
                carry = 0;
            }
            //往下循环
            indexA--;
            indexB--;
            max--;
        }
        //循环完之后，如果还有进位，说明前面要添0
        if(carry == 1){
            sb.append(1);
        }

        //将新数组的元素转成字符串
        for (int i = 0; i < resultArray.length; i++) {
            sb.append(resultArray[i]);
        }
        return sb.toString();
    }
}

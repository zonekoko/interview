package com.zyp.interview.demo.algorithm.recursive;

/**
 * @ClassName printAllSubsquences
 * @Description
 * 打印一个字符串的全部子序列，包括空字符串
 * @Author zhangyanping
 * @Date 2022/2/21 14:36
 * @Version 1.0
 */
public class printAllSubsquences {

    public static void main(String[] args) {

        String str = "abc";
        printAllSubSquences(str);
    }

    public static void printAllSubSquences(String str){
        char[] chars = str.toCharArray();
        process(chars,0);
    }

    public static void process(char[] chars,int i){
        if(i == chars.length){
            System.out.println(String.valueOf(chars));
            return;
        }
        process(chars,i+1);
        char temp = chars[i];
        chars[i] = 0;
        process(chars,i+1);
        chars[i] = temp;
    }


}

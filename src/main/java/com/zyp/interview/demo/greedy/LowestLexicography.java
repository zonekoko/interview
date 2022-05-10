package com.zyp.interview.demo.greedy;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 15:58
 * @Description 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所有字符串拼起来之后形成的字符串具有最小的字典序。
 */
public class LowestLexicography {

    public static void main(String[] args) {
        String[] strings = { "jibw", "ji", "jp", "bw", "jibw" };
        String res = lowestString(strings);
        System.out.println(res);

        String[] strings1 = {"ba","b"};
        String res1 = lowestString(strings1);
        System.out.println(res1);
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] str) {
        if (Objects.isNull(str) || str.length == 0) {
            return "";
        }
        System.out.println(Arrays.toString(str));
        Arrays.sort(str, new MyComparator());
        System.out.println(Arrays.toString(str));
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res += str[i];
        }
        return res;
    }
}

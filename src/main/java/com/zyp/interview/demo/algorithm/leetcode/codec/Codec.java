package com.zyp.interview.demo.algorithm.leetcode.codec;
//TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-
//tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
//
// 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本
//的 URL 。
//
// 实现 Solution 类：
//
//
//
//
// Solution() 初始化 TinyURL 系统对象。
// String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
// String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系
//统对象加密的。
//
//
//
//
// 示例：
//
//
//输入：url = "https://leetcode.com/problems/design-tinyurl"
//输出："https://leetcode.com/problems/design-tinyurl"
//
//解释：
//Solution obj = new Solution();
//string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
//string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
//
//
//
//
// 提示：
//
//
// 1 <= url.length <= 10⁴
// 题目数据保证 url 是一个有效的 URL
//
//
//
// Related Topics 设计 哈希表 字符串 哈希函数 👍 168 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Codec
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/29 09:43
 * @Version 1.0
 */
public class Codec {
    private Map<Integer, String> dataBase = new HashMap<Integer, String>();
    private int id;

    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }
}


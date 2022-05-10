package com.zyp.interview.demo.base;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/11/4 12:29
 */
public class BloomFilterDemo {

    public static void main(String[] args) {
        final BloomFilter<CharSequence> filter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 100000000, 0.0001);
        filter.put("死");
        filter.put("磕");
        filter.put("redis");
        System.out.println(filter.mightContain("死"));
        System.out.println(filter.mightContain("哈哈"));
    }
}

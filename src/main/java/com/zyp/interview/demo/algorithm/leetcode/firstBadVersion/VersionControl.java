package com.zyp.interview.demo.algorithm.leetcode.firstBadVersion;

/**
 * @ClassName VersionControl
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/6/14 23:01
 * @Version 1.0
 */
public class VersionControl {

   public static boolean isBadVersion(int version){
        if(version >= 4){
            return true;
        }
        return false;
    }
}

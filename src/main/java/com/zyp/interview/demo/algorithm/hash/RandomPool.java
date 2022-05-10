package com.zyp.interview.demo.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RandomPool
 * @Description 设计RandomPool结构
 * 【题目】
 * 设计一种结构，
 * 在该结构中有如下三个功能:
 * insert(key):
 * 将某个key加入到该结构，做到不重复加入
 * delete(key):将原本在结构中的某个key移除
 * getRandom():等概率随机返回结构中的任何一个key。
 * 【要求】
 * Insert、delete和getRandom方法的时间复杂度都是O(1)
 * @Author zhangyanping
 * @Date 2022/2/22 11:19
 * @Version 1.0
 */
public class RandomPool {

    public static void main(String[] args) {
        Pool<Integer> integerPool = new Pool<>();
        integerPool.insert(1);
        integerPool.insert(2);
        integerPool.insert(3);
        integerPool.insert(4);
        integerPool.insert(5);
        integerPool.insert(6);

        integerPool.remove(3);

        System.out.println();
    }

    public static class Pool<K>{
        private Map<K,Integer> keyIndexMap;

        private Map<Integer,K> indexKeyMap;

        private int size;

        public Pool(){
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key){
            if(!this.keyIndexMap.containsKey(key)){
                keyIndexMap.put(key,this.size);
                indexKeyMap.put(this.size++,key);
            }
        }

        public K getRandom(){
            if (this.size == 0){
                return null;
            }
            int randomIndex = (int) Math.random() * this.size;
            return indexKeyMap.get(randomIndex);
        }

        public void remove(K key){
            if(this.keyIndexMap.containsKey(key)){
                Integer deleteIndex = keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey,deleteIndex);
                indexKeyMap.put(deleteIndex,lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }
    }
}

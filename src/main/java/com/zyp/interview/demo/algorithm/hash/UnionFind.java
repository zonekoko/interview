package com.zyp.interview.demo.algorithm.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName UnionFind
 * @Description 并查集结构的详解和实现
 * @Author zhangyanping
 * @Date 2022/2/24 14:56
 * @Version 1.0
 */
public class UnionFind {

    public static class Element<V>{
        private V value;

        public Element(V value){
            this.value = value;
        }
    }

    public static class UnionFindSet<V>{
        private Map<V,Element<V>> elementMap;
        private Map<Element<V>,Element<V>> fatherMap;
        private Map<Element<V>,Integer> rankMap;

        public UnionFindSet(List<V> list){
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value,element);
                fatherMap.put(element,element);
                rankMap.put(element,1);
            }
        }

        private Element<V> findHead(Element<V> element){
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()){
                fatherMap.put(path.pop(),element);
            }
            return element;
        }

        public boolean isSameSet(V var1,V var2){
            if(elementMap.containsKey(var1) && elementMap.containsKey(var2)){
                return findHead(elementMap.get(var1)) == findHead(elementMap.get(var2));
            }
            return false;
        }

        public void union(V var1,V var2){
            if(elementMap.containsKey(var1) && elementMap.containsKey(var2)){
                Element<V> var1Element = elementMap.get(var1);
                Element<V> var2Element = elementMap.get(var2);
                Element<V> big = rankMap.get(var1Element) >= rankMap.get(var2Element) ? var1Element : var2Element;
                Element<V> small = big == var1Element ? var2Element : var1Element;
                fatherMap.put(small,big);
                rankMap.put(big,rankMap.get(var1Element) + rankMap.get(var2Element));
                rankMap.remove(var2Element);
            }

        }

    }

}

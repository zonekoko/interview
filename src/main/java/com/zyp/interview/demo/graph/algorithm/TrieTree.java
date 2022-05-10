package com.zyp.interview.demo.graph.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author zyp
 * @version V1.0
 * @Date 2021/12/27 14:27
 * @Description 前缀树
 */
@Data
@AllArgsConstructor
public class TrieTree {
    @Data
    @AllArgsConstructor
    public static class TrieNode {
        private int path;

        private int end;

        private TrieNode[] nexts;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            nexts = new TrieNode[26];
        }
    }


    private TrieNode trieNode;

    public TrieTree() {
        this.trieNode = new TrieNode();
    }

    public void insert(String word) {
        if (StringUtils.isBlank(word)) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode rootNode = trieNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (Objects.isNull(rootNode.nexts[index])) {
                rootNode.nexts[index] = new TrieNode();
            }
            rootNode = rootNode.nexts[index];
            rootNode.path++;
        }
        rootNode.end++;
    }

    public int search(String word) {
        if (StringUtils.isBlank(word)) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node = trieNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (Objects.isNull(node.nexts[index])) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            TrieNode node = trieNode;
            int index = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].path == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    public int prefixNum(String pre) {
        if (StringUtils.isBlank(pre)) {
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = trieNode;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (Objects.isNull(node.nexts[index])) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuob");
        trie.insert("zuoab");
        System.out.println(trie.prefixNum("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        System.out.println(trie.prefixNum("zuo"));
    }

}

package com.zyp.interview.demo.algorithm.leetcode.serializeAndDeserializeTree;

//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。
//
// 编码的字符串应尽可能紧凑。
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：[2,1,3]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数范围是 [0, 10⁴]
// 0 <= Node.val <= 10⁴
// 题目数据 保证 输入的树是一棵二叉搜索树。
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/5/11 09:55
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        left.left = new TreeNode(3);
        left.right = new TreeNode(4);

        right.left = new TreeNode(5);
        right.right = new TreeNode(6);

        String serialize = serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);

    }

    /**
     * 序列化，每个节点之间用"｜"分割，如果节点为空，用"_"表示
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if(root == null){
            return "_|";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + "|");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] split = data.split("\\|");
        if(split == null || split.length == 0){
            return null;
        }
        String index0 = split[0];
        if("_".equals(index0)){
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            queue.offer(split[i]);
        }
        TreeNode root = treefy(queue);
        return root;
    }

    private static TreeNode treefy(Queue<String> queue){
        String poll = queue.poll();
        if("_".equals(poll)){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(poll));
        treeNode.left = treefy(queue);
        treeNode.right = treefy(queue);
        return treeNode;
    }


}

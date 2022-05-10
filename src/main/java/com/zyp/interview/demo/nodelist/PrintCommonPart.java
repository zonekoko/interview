package com.zyp.interview.demo.nodelist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author zhangyp26142@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2021/11/12 13:41
 */
public class PrintCommonPart {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next= new Node(3);
        head1.next.next.next = new Node(4);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        printLinkedList(head1);
        printLinkedList(head2);
        printCommonPart(head1,head2);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node{
        private int value;
        private Node next;

        public Node(int data){
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1,Node head2){
        while (Objects.nonNull(head1) && Objects.nonNull(head2)){
            if(head1.getValue() < head2.getValue()){
                head1 = head1.next;
            }else if(head1.getValue() > head2.getValue()){
                head2 = head2.next;
            }else{
                System.out.println("公共部分的值：" + head1.getValue());
                head1=head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void printLinkedList(Node node){
        while (Objects.nonNull(node)){
            System.out.println("current node:" + node.getValue());
            node = node.next;
        }
    }
}

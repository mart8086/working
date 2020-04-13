package com.naver.china.project3;

/**
 * @ClassName MyListNode
 * @Description 单向的有序链表
 * @Author XuLei
 * @Date 2020/04/13 21:14
 * @Version 1.0
 */
public class MyListNode {

    public int nodeIndex;
    public MyListNode next; // 单向

    public MyListNode(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

}

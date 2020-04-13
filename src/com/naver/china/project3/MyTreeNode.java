package com.naver.china.project3;

/**
 * @ClassName MyTreeNode
 * @Description 定义二叉树的节点
 * @Author XuLei
 * @Date 2020/04/13 21:16
 * @Version 1.0
 */
public class MyTreeNode {
    public int nodeIndex;
    public MyTreeNode left;// 左子节点
    public MyTreeNode right;// 右子节点
    public MyTreeNode(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    @Override
    public String toString() {
        return "MyTreeNode{" +
                "nodeIndex=" + nodeIndex +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

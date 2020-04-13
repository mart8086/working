package com.naver.china.project3;

/**
 * @ClassName MyTreeNodeUtil
 * @Description 具体实现
 * 重点解决：高度平衡二叉树 ，每个节点的左右两个子树的高度的绝对值不超过1
 * @Author XuLei
 * @Date 2020/04/13 21:21
 * @Version 1.0
 */
public class MyTreeNodeUtil {

    private static MyTreeNode working(MyListNode first, MyListNode next) {
        if(first == next)
            return null;

        MyListNode firstTemp = first;
        MyListNode nextTemp = first;
        while(nextTemp.next != next && nextTemp.next.next != next) {
            firstTemp = firstTemp.next;
            nextTemp = nextTemp.next.next;
        }
        MyTreeNode root = new MyTreeNode(firstTemp.nodeIndex);
        root.left = working(first, firstTemp);
        root.right = working(firstTemp.next, next);
        return root;
    }

    /**
     *@description 入口，假定已经是有序的列表转为2叉数
     *@param listNode
     *@return : com.naver.china.project3.MyTreeNode
     *@author XuLei
     **/
    public static MyTreeNode listToTree(MyListNode listNode) {
        if(listNode == null)
            return null;
        return working(listNode, null);
    }


}

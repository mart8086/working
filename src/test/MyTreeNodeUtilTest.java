package test;

import com.naver.china.project3.MyListNode;
import com.naver.china.project3.MyTreeNode;
import com.naver.china.project3.MyTreeNodeUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName MyTreeNodeUtilTest
 * @Description TODO
 * @Author XuLei
 * @Date 2020/04/13 21:30
 * @Version 1.0
 */
public class MyTreeNodeUtilTest {
    private MyListNode listNode = null;
    private MyTreeNode treeNode = null;

    @Before
    public void init(){
        int size = 4;
        listNode = new MyListNode(size);
        listNode.nodeIndex = 1;

        MyListNode listNode2 = new MyListNode(1);
        listNode2.nodeIndex = 2;


        MyListNode listNode3 = new MyListNode(1);
        listNode3.nodeIndex = 3;
        listNode2.next = listNode3;

        MyListNode listNode4 = new MyListNode(1);
        listNode4.nodeIndex = 4;
        listNode3.next = listNode4;

        MyListNode listNode5 = new MyListNode(1);
        listNode5.nodeIndex = 5;
        listNode4.next = listNode5;

        listNode.next = listNode2;
    }

    @Test
    public void run() {

        treeNode = MyTreeNodeUtil.listToTree(listNode);
        System.out.println("root index: " + treeNode.nodeIndex);
        System.out.println("leftNode: " + treeNode.left);
        System.out.println("rightNode: " + treeNode.right);
    }
}

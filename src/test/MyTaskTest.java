package test;

import com.naver.china.project1.MyDigraph;
import com.naver.china.project1.MyTask;
import com.naver.china.project1.MyTaskScheduler;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName MyTaskTest
 * @Description 题目1任务处理测试
 * @Author XuLei
 * @Date 2020/04/13 22:14
 * @Version 1.0
 */
public class MyTaskTest {
    private MyDigraph digraph = null;
    @Before
    public void init(){
        digraph = new MyDigraph();
        MyTask task1 = new MyTask(1L, "taskA", 0);
        MyTask task2 = new MyTask(2L, "taskB", 0);
        MyTask task3 = new MyTask(3L, "taskC", 0);
        MyTask task4 = new MyTask(4L, "taskD", 0);
        MyTask task5 = new MyTask(5L, "taskE", 0);
        MyTask task6 = new MyTask(6L, "taskF", 0);

        digraph.addMyTask(task1);
        digraph.addMyTask(task2);
        digraph.addMyTask(task3);
        digraph.addMyTask(task4);
        digraph.addMyTask(task5);
        digraph.addMyTask(task6);


        // 还需要调试输出顺序
        digraph.addEdge(task1, task2);
        digraph.addEdge(task6, task4);



    }

    @Test
    public void run(){
        MyTaskScheduler scheduler = new MyTaskScheduler();
        scheduler.schedule(digraph);
    }

}

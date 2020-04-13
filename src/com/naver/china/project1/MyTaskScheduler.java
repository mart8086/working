package com.naver.china.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MyTaskScheduler
 * @Description 任务处理器
 * @Author XuLei
 * @Date 2020/04/13 22:12
 * @Version 1.0
 */
public class MyTaskScheduler {
    public void schedule(MyDigraph digraph) {
        while (true) {
            List<MyTask> working = new ArrayList<MyTask>();
            for (MyTask task : digraph.getMyTasks()) {
                if (!task.hasExecuted()) {
                    Set<MyTask> prevs = digraph.getMap().get(task);
                    if (prevs != null && !prevs.isEmpty()) {
                        boolean toAdd = true;
                        for (MyTask taskTemp : prevs) {
                            if (!taskTemp.hasExecuted()) {
                                toAdd = false;
                                break;
                            }
                        }
                        if (toAdd) {
                            working.add(task);
                        }
                    } else {
                        working.add(task);
                    }
                }
            }
            if (!working.isEmpty()) {
                for (MyTask task : working) {
                    if (!task.execute()) {
                        throw new RuntimeException("任务调度错误");
                    }
                }
            } else {
                break;
            }
        }
    }
}

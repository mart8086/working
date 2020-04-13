package com.naver.china.project1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MyDigraph
 * @Description 任务图
 * @Author XuLei
 * @Date 2020/04/13 22:09
 * @Version 1.0
 */
public class MyDigraph {
    private Set<MyTask> myTasks;
    private Map<MyTask, Set<MyTask>> map;

    public MyDigraph() {
        this.myTasks = new HashSet<MyTask>();
        this.map = new HashMap<MyTask, Set<MyTask>>();
    }

    public void addEdge(MyTask myTask, MyTask prev) {
        if (!myTasks.contains(myTask) || !myTasks.contains(prev)) {
            throw new IllegalArgumentException();
        }
        Set<MyTask> prevs = map.get(myTask);
        if (prevs == null) {
            prevs = new HashSet<MyTask>();
            map.put(myTask, prevs);
        }
        if (prevs.contains(prev)) {
            throw new IllegalArgumentException();
        }
        prevs.add(prev);
    }

    public void addMyTask(MyTask myTask) {
        if (myTasks.contains(myTask)) {
            throw new IllegalArgumentException();
        }
        myTasks.add(myTask);
    }

    public void remove(MyTask myTask) {
        if (!myTasks.contains(myTask)) {
            return;
        }
        if (map.containsKey(myTask)) {
            map.remove(myTask);
        }
        for (Set<MyTask> set : map.values()) {
            if (set.contains(myTask)) {
                set.remove(myTask);
            }
        }
    }

    public Set<MyTask> getMyTasks() {
        return myTasks;
    }

    public void setMyTasks(Set<MyTask> myTasks) {
        this.myTasks = myTasks;
    }

    public Map<MyTask, Set<MyTask>> getMap() {
        return map;
    }

    public void setMap(Map<MyTask, Set<MyTask>> map) {
        this.map = map;
    }

}

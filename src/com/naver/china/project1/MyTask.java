package com.naver.china.project1;

/**
 * @ClassName MyTask
 * @Description TODO
 * @Author XuLei
 * @Date 2020/04/13 22:03
 * @Version 1.0
 */
public class MyTask implements ITaskExecute{
    /**任务编号*/
    private Long id;
    /**任务名*/
    private String name;
    /**任务状态，0：未执行，1：已执行*/
    private int status;

    public MyTask(Long id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    /**
     *@description 返回任务十分执行
     *@param
     *@return : boolean
     *@author XuLei
     **/
    public boolean hasExecuted() {
        return status == 1;
    }

    @Override
    public boolean execute() {
        System.out.println("task -> [" + name +"]  working");
        status = 1;
        return true;
    }
}

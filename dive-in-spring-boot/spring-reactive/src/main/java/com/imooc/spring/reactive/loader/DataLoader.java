package com.imooc.spring.reactive.loader;

import java.util.concurrent.*;

/**
 *  阻塞（串行）数据加载
 *  @Author AmVilCresx
 *  @Date 2018/12/19 14:13
 *  @Description
 */
public class DataLoader {

    public final void load(){
        long startTime = System.currentTimeMillis(); // 开始时间
        doLoad(); // 具体执行
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("load()总耗时：" + costTime + "毫秒");
    }

    protected void doLoad() {
        loadConfigurations();
        loadUsers();
        loadOrders();
    }


    protected void loadConfigurations() {
        loadMock("loadConfigurations()",1);
    }


    protected void loadUsers() {
        loadMock("loadUsers",2);
    }

    protected final void loadOrders() {
        loadMock("loadOrders()",3);
    }


    protected void loadMock(String source, int seconds) {
        try{
            long startTime = System.currentTimeMillis();
            long millseconds = TimeUnit.SECONDS.toMillis(seconds);
            Thread.sleep(millseconds);
            long costTime = System.currentTimeMillis() - startTime;

            System.out.printf("[线程：%s] %s 耗时：%d 毫秒\n",Thread.currentThread().getName(),source,costTime);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        new DataLoader().load();
    }

}

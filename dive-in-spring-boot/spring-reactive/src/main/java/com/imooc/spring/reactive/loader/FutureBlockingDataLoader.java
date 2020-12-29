package com.imooc.spring.reactive.loader;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Future 阻塞数据加载器
 *  @Author AmVilCresx
 *  @Date 2018/12/19 15:09
 *  @Description
 */
public class FutureBlockingDataLoader extends DataLoader{

    protected void doLoad(){
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));
        executorService.shutdown();
    }

    private void runCompletely(Future<?> future){
        try {
            future.get(); // 阻塞
        } catch (Exception e){

        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }
}

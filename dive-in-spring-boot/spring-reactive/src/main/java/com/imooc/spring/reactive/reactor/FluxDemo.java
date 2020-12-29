package com.imooc.spring.reactive.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/** Flux 示例
 *  @Author AmVilCresx
 *  @Date 2018/12/20 10:57
 *  @Description
 */
public class FluxDemo {

    public static void main(String[] args) {
        Flux.just("A","B","C")  // 发布 A->B->C
                //.publishOn(Schedulers.elastic())  // 线程切换
                .map(value -> "+" + value)       // “+” 转换
              /*  .subscribe(
                        FluxDemo::println,  // 数据消费 = onNext
                        FluxDemo::println,  // 异常回调 = onError
                        () ->{              // 完成回调 = onComplete
                            println("完成操作！");
                        },
                          subscription -> { // 背压操作 = onSubscribe(Subscription)
                              subscription.request(Integer.MAX_VALUE);    // 请求元素的数量
                              subscription.cancel();    // 取消上游传输数据到下游
                          }
                        )*/
              .subscribe(new Subscriber<String>() {

                  private Subscription subscription;

                  private int count = 0;

                  @Override
                  public void onSubscribe(Subscription s) {
                      subscription = s;
                      subscription.request(1);
                  }

                  @Override
                  public void onNext(String s) {
                      if(count == 2){
                            throw new RuntimeException("我是故意的！");
                      }
                      println(s);
                      count++;
                      subscription.request(1);
                  }

                  @Override
                  public void onError(Throwable t) {
                      println(t.getMessage());
                  }

                  @Override
                  public void onComplete() {
                      println("完成操作");
                  }
              })
                ;
       // Thread.sleep(1000L);
    }

    private static void println(Object o){
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + o);
    }
}

package com.kpztech.duboo.consumer.dubbo.proxy;

import com.alibaba.dubbo.rpc.RpcContext;
import com.kpztech.practice.dubbo.service.FirstDubboService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FirstDubboProxy {

  @Autowired
  private FirstDubboService firstDubboService;

  private RpcContext context = RpcContext.getContext();

  public void test() {
    log.info("I'm consumer, now I have to test something!");

    // RpcContext可以拿到Dubbo的上下文

    context.setAttachment("Key-KKK", "V-KKK");

    firstDubboService.test();

    context.get();

    log.info(context.getRemoteAddressString());

  }

  public String asyncTest() {
    log.info("Async Test>>> ");
    Future<String> stringFuture = context.asyncCall(() -> firstDubboService.test());
    String result = "";
    try {
      result = stringFuture.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return result;
  }


}

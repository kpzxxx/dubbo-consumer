package com.kpztech.duboo.consumer.dubbo.proxy;

import com.kpztech.practice.dubbo.service.FirstDubboService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstDubboProxy {

  @Autowired
  private FirstDubboService firstDubboService;

  public void test() {
    System.out.println("I'm consumer, now I have to test something!");
    firstDubboService.test();
  }


}

package com.kpztech.duboo.consumer.mvc.controller;

import com.kpztech.duboo.consumer.dubbo.proxy.FirstDubboProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

  @Autowired
  private FirstDubboProxy firstDubboProxy;
  @RequestMapping("/test")
  public void test(){
    firstDubboProxy.test();
  }

}

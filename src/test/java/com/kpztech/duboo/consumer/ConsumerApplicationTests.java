package com.kpztech.duboo.consumer;

import com.kpztech.duboo.consumer.dubbo.proxy.FirstDubboProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

@SpringBootTest
@ImportResource({"classpath*:consumer.xml"})
class ConsumerApplicationTests {
  @Autowired
  private FirstDubboProxy firstDubboProxy;

  @Test
  void contextLoads() {
    // 这里consumer client没有初始化，无法调用
    firstDubboProxy.test();
  }

}

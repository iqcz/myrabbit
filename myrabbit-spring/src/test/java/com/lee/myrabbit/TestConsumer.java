package com.lee.myrabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring/spring-consumer.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestConsumer {
	@Test
	public void testConsumer() {
		try {
			Thread.sleep(Long.MAX_VALUE); // 启动消费容器
		} catch (InterruptedException e) {
		}
	}
}

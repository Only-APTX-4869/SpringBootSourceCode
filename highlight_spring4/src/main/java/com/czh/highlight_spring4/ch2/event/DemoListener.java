package com.czh.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	public void onApplicationEvent(DemoEvent event) {
		
		String msg = event.getMsg();
		
		System.out.println("��(bean-demoListener)���ܵ���bean-demoPublisher��������Ϣ:"
				+ msg);

	}

}

package com.czh.highlight_spring4.ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{//1
	
	private String beanName;
	private ResourceLoader loader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {//2
		this.loader = resourceLoader;
	}

	@Override
	public void setBeanName(String name) {//3
		this.beanName = name;
	}
	
	public void outputResult(){
		System.out.println("Bean������Ϊ��" + beanName);
		
		Resource resource = 
				loader.getResource("classpath:com/czh/highlight_spring4/ch3/aware/test.txt");
		try{
			
			System.out.println("ResourceLoader���ص��ļ�����Ϊ: " + IOUtils.toString(resource.getInputStream()));
			
		   }catch(IOException e){
			e.printStackTrace();
		   }
	
	}

}

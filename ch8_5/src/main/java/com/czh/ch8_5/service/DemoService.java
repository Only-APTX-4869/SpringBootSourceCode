package com.czh.ch8_5.service;

import com.czh.ch8_5.domain.Person;

public interface DemoService {
	public Person save(Person person);
	
	public void remove(Long id);
	
	public Person findOne(Person person);

}

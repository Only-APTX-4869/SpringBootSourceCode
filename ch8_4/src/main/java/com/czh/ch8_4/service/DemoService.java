package com.czh.ch8_4.service;

import com.czh.ch8_4.domain.Person;

public interface DemoService {
	public Person savePersonWithRollBack(Person person);
	public Person savePersonWithoutRollBack(Person person);

}

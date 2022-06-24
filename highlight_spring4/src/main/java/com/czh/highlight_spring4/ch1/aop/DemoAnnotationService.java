package com.czh.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name = "czh And xmh")
    public void add(){} 
   
}

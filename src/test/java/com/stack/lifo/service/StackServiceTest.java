package com.stack.lifo.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.stack.lifo.LifoApplication;
import com.stack.lifo.model.Stack;
import com.stack.lifo.service.StackService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LifoApplication.class)
@ActiveProfiles("test")
public class StackServiceTest {

    @Autowired
    private StackService stackService;
    
    @Test
    public void testPush() {
    	Stack stack = stackService.push("10");
    	assertTrue("10".equals(stack.getItem()));
    }
    
    @Test
    public void testPop() {
    	stackService.push("20");
    	String item = stackService.pop();
    	assertTrue("20".equals(item));
    }
}
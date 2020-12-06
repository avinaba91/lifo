package com.stack.lifo.service;

import com.stack.lifo.model.Stack;

public interface StackService {
	
	public Stack push(String item);
	
	public String pop();

}

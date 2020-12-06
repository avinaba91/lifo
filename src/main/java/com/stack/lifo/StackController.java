package com.stack.lifo;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stack.lifo.model.Stack;
import com.stack.lifo.service.StackService;

@RestController
@RequestMapping(value = "/stack")
public class StackController {
	
	@Autowired
	StackService stackService;
	
	@PostMapping (value = "/push/{item}")
	public String push(@PathVariable String item) {
		Stack stack = stackService.push(item);
		return stack.getItem() + " is pushed into stack";
	}
	
	@DeleteMapping (value = "/pop")
	public String pop() {
		String item = stackService.pop();
		return item + " removed from stack";
	}
}

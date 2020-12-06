package com.stack.lifo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.lifo.dao.StackRepository;
import com.stack.lifo.model.Stack;

@Service
public class StackServiceImpl implements StackService {
	
	@Autowired
	private StackRepository stackRepository;

	@Override
	public Stack push(String item) {
		return stackRepository.save(new Stack(item));
	}

	@Override
	public String pop() {
		Long id = stackRepository.getMaxItemId();
		if (id == null) {
			return "No item left to be";
		}
		Optional<Stack> stack = stackRepository.findById(id);
		if (stack.isPresent()) {
			stackRepository.deleteById(id);
			return stack.get().getItem();
		} else {
			return "No item left to be";
		}
	}
}

package com.original.RestAPI_TodoList1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.original.RestAPI_TodoList1.model.TodoItem;
import com.original.RestAPI_TodoList1.service.TodoItemService;

@RestController
public class TodoItemController {
	
	@Autowired
	private TodoItemService todoitemService;
	
	@GetMapping("/todoitems")
	public List<TodoItem> getAllTodoItems(){
		return todoitemService.getAllTodoItems();
	}
	
	@GetMapping("/todoitem/{id}")
	public TodoItem getTodoItem(@PathVariable("id") int id) {
		return todoitemService.getTodoItem(id);
	}
	
	@PostMapping("/todoitem")
	public void addTodoItem(@RequestBody TodoItem todoitem) {
		todoitemService.addTodoItem(todoitem);
	}
	
	@PutMapping("/todoitem/{id}")
	public void updateTodoItem(@PathVariable("id") int id,
			@RequestBody TodoItem todoitem) {
		todoitemService.updateTodoItem(id, todoitem);
	}
	
	@DeleteMapping("/todoitem/{id}")
	public void deleteTodoItem(@PathVariable("id") int id) {
		todoitemService.deleteTodoItem(id);
	}

}

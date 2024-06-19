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
	public TodoItem getTodoItem(@PathVariable("id") Long id) {
		return todoitemService.getTodoItem(id);
	}
	
	@PostMapping("/todoitem")
	public void addTodoItem(@RequestBody TodoItem todoitem) {
		todoitemService.addTodoItem(todoitem);
	}
	
	@PutMapping("/todoitem/{id}")
	public void updateTodoItem(@PathVariable("id") Long id,
			@RequestBody TodoItem todoitem) {
		todoitemService.updateTodoItem(id, todoitem);
	}
	
	@DeleteMapping("/todoitem/{id}")
	public void deleteTodoItem(@PathVariable("id") Long id) {
		todoitemService.deleteTodoItem(id);
	}
	
	// ---------------------------------------------------------------------------------------
	
	@GetMapping("/todoitems/title/{title}")
	public List<TodoItem> getTitleTodoItems(@PathVariable("title") String title) {
		return todoitemService.getTitleTodoItems(title);
	}
	
	@GetMapping("/todoitems/status/{status}")
	public List<TodoItem> getStatusTodoItems(@PathVariable("status") String status) {
		return todoitemService.getStatusTodoItems(status);
	}

}

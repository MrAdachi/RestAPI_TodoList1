package com.original.RestAPI_TodoList1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.original.RestAPI_TodoList1.model.TodoItem;
import com.original.RestAPI_TodoList1.service.TodoItemService;

@RestController
public class TodoItemController {
	
	@Autowired
	private TodoItemService todoitemService;
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems(
			@RequestParam(name = "status",required = false) String status,
			@RequestParam(name = "title", required = false) String title){
		
		String status_list[] = {"未着手", "進行中", "完了"};
		
		if(status == null && title == null) {
			return todoitemService.getAllTodoItems();
		} else if((Arrays.asList(status_list).contains(status)) && title == null) {
			return todoitemService.getStatusTodoItems(status);
		} else if(status == null && title != null) {
			return todoitemService.getTitleTodoItems(title);
		} else {
			return null;
		}
	}
	
	@GetMapping("/todos/{id}")
	public TodoItem getTodoItem(@PathVariable("id") Long id) {
		return todoitemService.getTodoItem(id);
	}
	
	@PostMapping("/todos")
	public void addTodoItem(@RequestBody TodoItem todoitem) {
		todoitemService.addTodoItem(todoitem);
	}
	
	@PutMapping("/todos/{id}")
	public void updateTodoItem(@PathVariable("id") Long id,
			@RequestBody TodoItem todoitem) {
		todoitemService.updateTodoItem(id, todoitem);
	}
	
	@DeleteMapping("/todos/{id}")
	public void deleteTodoItem(@PathVariable("id") Long id) {
		todoitemService.deleteTodoItem(id);
	}

}

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
	private TodoItemService todoItemService;
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems(
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String title){
		
		String statusList[] = {"未着手", "進行中", "完了"};
		
		if (status == null && title == null) {
			return todoItemService.getAllTodoItems();
		} else if ((Arrays.asList(statusList).contains(status)) && title == null) {
			return todoItemService.getStatusTodoItems(status);
		} else if (status == null && title != null) {
			return todoItemService.getTitleTodoItems(title);
		} else {
			return null;
		}
	}
	
	@GetMapping("/todos/sort/{sortName}")
	public List<TodoItem> getSortAllTodoItems(@PathVariable(required = false) String sortName){
		
		if (sortName.equals("id")) {
			return todoItemService.getAllTodoItemsSortId();
		} else if (sortName.equals("status")) {
			return todoItemService.getAllTodoItemsSortStatus();
		} else {
			return null;
		}
	}
	
	@GetMapping("/todos/{id}")
	public TodoItem getTodoItem(@PathVariable Long id) {
		return todoItemService.getTodoItem(id);
	}
	
	@PostMapping("/todos")
	public void addTodoItem(@RequestBody TodoItem todoitem) {
		todoItemService.addTodoItem(todoitem);
	}
	
	@PutMapping("/todos/{id}")
	public void updateTodoItem(@PathVariable Long id,
			@RequestBody TodoItem todoitem) {
		todoItemService.updateTodoItem(id, todoitem);
	}
	
	@DeleteMapping("/todos/{id}")
	public void deleteTodoItem(@PathVariable Long id) {
		todoItemService.deleteTodoItem(id);
	}

}

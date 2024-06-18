package com.original.RestAPI_TodoList1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.original.RestAPI_TodoList1.model.TodoItem;

@Service
public class TodoItemService {
	
	private List<TodoItem> todoitems;
	
	public TodoItemService() {
		todoitems = new ArrayList<>();
	}
	
	public List<TodoItem> getAllTodoItems(){
		return todoitems;
	}
	
	public TodoItem getTodoItem(String id) {
		for(int i = 0; i < todoitems.size(); i++) {
			String get_todoitem_id = todoitems.get(i).getId();
			if(get_todoitem_id.equals(id)) {
				return todoitems.get(i);
			}
		}
		return null;
	}
	
	public void addTodoItem(TodoItem todoitem) {
		todoitems.add(todoitem);
	}
	
	public void updateTodoItem(String id, TodoItem todoitem) {
		for(int i = 0; i < todoitems.size(); i++) {
			String update_todoitem_id = todoitems.get(i).getId();
			if(update_todoitem_id.equals(id)) {
				todoitems.set(i, todoitem);
				break;
			}
		}
	}
	
	public void deleteTodoItem(String id) {
		for(int i = 0; i < todoitems.size(); i++) {
			String delete_todoitem_id = todoitems.get(i).getId();
			if(delete_todoitem_id.equals(id)) {
				todoitems.remove(i);
			}
		}
	}
}

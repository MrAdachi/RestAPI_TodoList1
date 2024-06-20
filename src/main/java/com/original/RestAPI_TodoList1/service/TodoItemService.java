package com.original.RestAPI_TodoList1.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.original.RestAPI_TodoList1.model.TodoItem;

@Service
public class TodoItemService {
	
	private List<TodoItem> todoItems;
	
	public TodoItemService() {
		todoItems = new ArrayList<>();
	}
	
	public List<TodoItem> getAllTodoItems(){
		return todoItems;
	}
	
	public List<TodoItem> getTitleTodoItems(String title){
		List<TodoItem> titleTodoItems = new ArrayList<>();
		for(TodoItem todoItem: todoItems) {
			if(todoItem.getTitle().equals(title)) {
				titleTodoItems.add(todoItem);
			}
		}
		return titleTodoItems;
	}
	
	public List<TodoItem> getStatusTodoItems(String status){
		List<TodoItem> statusTodoItems = new ArrayList<>();
		for(TodoItem todoItem: todoItems) {
			if(todoItem.getStatus().equals(status)) {
				statusTodoItems.add(todoItem);
			}
		}
		return statusTodoItems;
	}
	
	public List<TodoItem> getAllTodoItemsSortId(){
		List<TodoItem> todoItemsSortId = new ArrayList<>();
		
		for(TodoItem todoitem : todoItems) {
			todoItemsSortId.add(todoitem);
		}
		
		// ListのSort(Id)
		for(int i = 0; i < todoItemsSortId.size() - 1; i++) {
			for(int j = 0; j < todoItemsSortId.size() - 1 - i; j++) {
				if(todoItemsSortId.get(j).getId() > todoItemsSortId.get(j+1).getId()) {
					TodoItem temporary = todoItemsSortId.get(j);
					todoItemsSortId.set(j, todoItemsSortId.get(j+1));
					todoItemsSortId.set(j + 1, temporary);
				}
			}
		}
		return todoItemsSortId;
	}
	
	public List<TodoItem> getAllTodoItemsSortStatus(){
		List<TodoItem> todoItemsSortStatus = new ArrayList<>();
		String statusList[] = {"未着手", "進行中", "完了"};
		
		// ListのSort(Status)
		for(String status : statusList) {
			for(TodoItem todoItem : todoItems) {
				if(todoItem.getStatus().equals(status)) {
					todoItemsSortStatus.add(todoItem);
				}
			}
		}
		return todoItemsSortStatus;
	}
		
	public TodoItem getTodoItem(Long id) {
		for(int i = 0; i < todoItems.size(); i++) {
			Long getTodoItemId = todoItems.get(i).getId();
			if(getTodoItemId.equals(id)) {
				return todoItems.get(i);
			}
		}
		return null;
	}
	
	public void addTodoItem(TodoItem todoItem) {
		// 作成日時・更新日時の初期化
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		todoItem.setCreateDateTime(sdf.format(cl.getTime()));
		todoItem.setUpdateDateTime(sdf.format(cl.getTime()));
		todoItems.add(todoItem);
	}
	
	public void updateTodoItem(Long id, TodoItem todoItem) {
		for(int i = 0; i < todoItems.size(); i++) {
			Long updateTodoItemId = todoItems.get(i).getId();
			if(updateTodoItemId.equals(id)) {
				// 作成日時は更新前のデータから引用
				todoItem.setCreateDateTime(todoItems.get(i).getCreateDateTime());
				// 更新日時の初期化
				Calendar cl = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				todoItem.setUpdateDateTime(sdf.format(cl.getTime()));
				todoItems.set(i, todoItem);
				break;
			}
		}
	}
	
	public void deleteTodoItem(Long id) {
		for(int i = 0; i < todoItems.size(); i++) {
			Long deleteTodoitemId = todoItems.get(i).getId();
			if(deleteTodoitemId.equals(id)) {
				todoItems.remove(i);
			}
		}
	}
}

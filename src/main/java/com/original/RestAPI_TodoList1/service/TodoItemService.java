package com.original.RestAPI_TodoList1.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public TodoItem getTodoItem(Long id) {
		for(int i = 0; i < todoitems.size(); i++) {
			Long get_todoitem_id = todoitems.get(i).getId();
			if(get_todoitem_id.equals(id)) {
				return todoitems.get(i);
			}
		}
		return null;
	}
	
	public void addTodoItem(TodoItem todoitem) {
		// 作成日時・更新日時の初期化
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		todoitem.setCreate_datetime(sdf.format(cl.getTime()));
		todoitem.setUpdate_datetime(sdf.format(cl.getTime()));
		todoitems.add(todoitem);
	}
	
	public void updateTodoItem(Long id, TodoItem todoitem) {
		for(int i = 0; i < todoitems.size(); i++) {
			Long update_todoitem_id = todoitems.get(i).getId();
			if(update_todoitem_id.equals(id)) {
				// 作成日時は更新前のデータから引用
				todoitem.setCreate_datetime(todoitems.get(i).getCreate_datetime());
				// 更新日時の初期化
				Calendar cl = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				todoitem.setUpdate_datetime(sdf.format(cl.getTime()));
				todoitems.set(i, todoitem);
				break;
			}
		}
	}
	
	public void deleteTodoItem(Long id) {
		for(int i = 0; i < todoitems.size(); i++) {
			Long delete_todoitem_id = todoitems.get(i).getId();
			if(delete_todoitem_id.equals(id)) {
				todoitems.remove(i);
			}
		}
	}
}

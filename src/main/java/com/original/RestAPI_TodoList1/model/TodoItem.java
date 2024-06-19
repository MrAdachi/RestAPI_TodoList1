package com.original.RestAPI_TodoList1.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TodoItem {
	
	private String id;
	private String title;
	private String status;
	private String details;
	// 作成日時・更新日時
	private String create_datetime;
	private String update_datetime;
	
	// コンストラクタ（念のため記載）
	public TodoItem(String id, String title, String status, String details) {
		this.id = id;
		this.title = title;
		this.status = status;
		this.details = details;
		// 作成日時・更新日時の初期化
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.create_datetime = sdf.format(cl.getTime());
		this.update_datetime = sdf.format(cl.getTime());
	}

	public String getCreate_datetime() {
		return create_datetime;
	}

	public void setCreate_datetime(String create_datetime) {
		this.create_datetime = create_datetime;
	}
	

	public String getUpdate_datetime() {
		return update_datetime;
	}

	public void setUpdate_datetime(String update_datetime) {
		this.update_datetime = update_datetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}

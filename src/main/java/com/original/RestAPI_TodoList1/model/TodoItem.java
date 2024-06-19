package com.original.RestAPI_TodoList1.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoItem {
	
	private int id;
	private String title;
	private String status;
	private String details;
	// 作成日時・更新日時
	private String create_datetime;
	private String update_datetime;
	
	// コンストラクタ（念のため記載）
	public TodoItem(int id, String title, String status, String details) {
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
}

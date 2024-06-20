package com.original.RestAPI_TodoList1.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoItem {
	
	private Long id;
	private String title;
	private String status;
	private String details;
	// 作成日時・更新日時
	private String createDateTime;
	private String updateDateTime;
	
	// コンストラクタ（念のため記載）
	public TodoItem(Long id, String title, String status, String details) {
		this.id = id;
		this.title = title;
		this.status = status;
		this.details = details;
		// 作成日時・更新日時の初期化
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.createDateTime = sdf.format(cl.getTime());
		this.updateDateTime = sdf.format(cl.getTime());
	}
}

package main.manager;

import java.util.ArrayList;

import main.pay.data.db;

public class payCheck {
	ArrayList<String> data = new ArrayList<String>(); 
	db d = new db();
	
	//데이터 개수 알기위함..
	public payCheck() {
		data = chk("id","paydata");
	}
	
	public payCheck(String str) {
		data = chk(str,"paydata");
		for(int i=0; i<data.size(); i++) {
			System.out.println(data.get(i));
		}
	}

	//table 컬렴명 확인
	public ArrayList<String> chk(String tableName) {
		return d.colLookUp(tableName);
	}
	//데이터 select
	public ArrayList<String> chk(String str,String tableName) {
		return d.select(str,tableName);
	}
	
}

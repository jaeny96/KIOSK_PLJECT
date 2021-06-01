package main.pay.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import seatingTable.Main;

public class storeData {
	String id;
	String seat;
	String payT;
	String sTime;
	String eTime;
	String product;
	String price;
	String type;
	String menuType;

	public storeData(String id, String seat, String payT, String sTime, String eTime, String product, String price,
			String type, String menuType) {
		this.id = id;
		this.seat = seat;
		this.payT = payT;
		this.sTime = sTime;
		this.eTime = eTime;
		this.product = product;
		this.price = price;
		this.type = type;
		this.menuType = menuType;
	}

	public void store() {
		db newD = new db();
		ArrayList<String> arr = newD.select("Id", "paydata WHERE Id='" + id + "'");
		System.out.println(arr.size() + " size");
		System.out.println(menuType + " size");
		if (menuType.equals("reserv") && arr.size() >= 1) {
			newD.insert(id, seat, payT, sTime, eTime, product, price, type, menuType);
		} else if (menuType.equals("reserv") && arr.size() == 0) {
			newD.update(id, seat, payT, sTime, eTime, product, price, type, menuType);
		} else {
			newD.update(id, seat, payT, sTime, eTime, product, price, type, menuType);
		}
	}

}

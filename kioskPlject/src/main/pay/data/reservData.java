package main.pay.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class reservData {
	String beforeModiT="";
	String beforeModiProd="";
	String stdDate="";
	int prodTime = 0;
	String prod = "";
	String price = "";
	String startTime;
	String endTime;
	public reservData() {
		
	}
	public reservData(String date) {
		beforeModiT=date;
	}

	public reservData(String date,String prod) {
		stdDate=date;
		beforeModiProd=prod;
	}
	
	public String modiStart() {
		String date = beforeModiT+"/15:30";
		String format = "yyyy/MM/dd/HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date start = sdf.parse(date);
			startTime = sdf.format(start.getTime());
		} catch (ParseException e) {
			System.out.println("ParseException Error");
//			e.printStackTrace();
		}
		setStartTime(startTime);
		return startTime;
	}
	
	public String modiProd(String str) {
		String[] prodDt = str.split(" ");
		prod = prodDt[0];
		String modiTime= prod.substring(0,1);
		prodTime = Integer.parseInt(modiTime);
		price = prodDt[1];
		setProd(prod);
		setPrice(price);
		return price;
	}
	
	
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}

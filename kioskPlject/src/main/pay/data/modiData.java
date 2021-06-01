package main.pay.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class modiData {
	public modiData() {
	}
	// 시작시간~끝시간에 대한 보여지는 시간 형식 지정

	// 현재 시간 반환
	public String start() {
		Date date = new Date();
		String format = "YYYY/MM/dd/HH:mm";
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String now = sd.format(date.getTime());

		return now;
	}

	// 끝 시간 반환
	public String end(String start, String product) {
		String formatTime = "";
		String a = start;
		String form = "yyyy/MM/dd/HH:mm";
		SimpleDateFormat s = new SimpleDateFormat(form);
		Date now = new Date();
		if (product.contains("시간")) {
			try {
				now = s.parse(a);
				int productTime = Integer.parseInt(product.substring(0, product.length() - 2));
				Calendar c = Calendar.getInstance();
				c.setTime(now);
				c.add(Calendar.HOUR, productTime);
				String format = "YYYY/MM/dd/HH:mm";
				SimpleDateFormat sd = new SimpleDateFormat(format);
				String end = sd.format(c.getTime());
				formatTime = end;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				now = s.parse(a);
				int productDay = Integer.parseInt(product.substring(0, product.length() - 2));
				Calendar c = Calendar.getInstance();
				c.setTime(now);
				c.add(Calendar.DATE, productDay * 7);
				String format = "YYYY/MM/dd/HH:mm";
				SimpleDateFormat sd = new SimpleDateFormat(format);
				String end = sd.format(c.getTime());
				formatTime = end;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return formatTime;
	}

	// 사용 시간 반환
	public String use(String product) {
		String use = "";
		if (product.contains("시간")) {
			use = product.substring(0, product.length() - 2);
		} else {
			String tmp = product.substring(0, product.length() - 2);
			use = Integer.parseInt(tmp) * 7 * 24 + "";
		}
		return use;
	}

	// 상품명 반환
	public String modiPro(String product) {
		String pro = "";
		if (product.contains("시간")) {
			pro = product.substring(0, product.length() - 2) + "hours";
		} else {
			String tmp = product.substring(0, product.length() - 2);
			pro = Integer.parseInt(tmp) * 7 + "days";
		}
		return pro;
	}

	// 가격 반환
	public String modiPri(String price) {
		String pri = "";
		if (price.contains("원")) {
			pri = price.substring(0, price.length() - 1) + "won";
		}
		return pri;
	}
}

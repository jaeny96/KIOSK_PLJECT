package main.pay.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//파일 읽어오는 클래스
public class readFile {
	String title="";
	public readFile() {
		
	}
	public readFile( String title) {
		this.title=title;
	}
	
	// 파일 읽어와 arrayList에 저장한 후 arrayList 반환하는 함수
	public ArrayList<String> readFileFunc(ArrayList<String> arr) {
		String path = "./src/data";
		File file = new File(path+"/"+title+".txt");
		String str = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {
				arr.add(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
}

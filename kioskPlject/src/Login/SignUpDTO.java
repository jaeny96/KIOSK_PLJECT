package Login;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUpDTO {
	
	String Id;
	String Pw;
	String Name;
	String Gender;
	String IdNum;
	String PhoneNum;
	String Word;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getIdNum() {
		return IdNum;
	}
	public void setIdNum(String idNum) {
		IdNum = idNum;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	public String getWord() {
		return Word;
	}
	public void setWord(String word) {
		Word = word;
	}
	
	@Override
	public String toString() {
		return "SignUp [Id=" + Id + ", Pw=" + Pw + ", Name=" + Name + ", Gender=" + Gender + ", IdNum=" + IdNum
				+ ", PhoneNum=" + PhoneNum + ", Word=" + Word + "]";
	}
	
}

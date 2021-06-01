package Login;

import java.util.regex.Pattern;

public class CheckForm {
	
	// 숫자 검사 
	public boolean isNumeric(String str) {
	    return Pattern.matches("^[0-9]*$", str);
	}

	// 한국어 및 영어 검사
	public boolean isAlphaNumeric(String str) {
	    return Pattern.matches("[a-zA-Z0-9]*$", str);
	}

	// 한국어 검사
	public boolean isKo(String str) {
	    return Pattern.matches("/^[가-힣]{2,6}$/", str);
	}
	 
	// 휴대폰 번호 검사 
	public boolean isMob(String str) {
	    return Pattern.matches("/^01[0179][0-9]{7,8}$/", str);
	}
	
	// 생년월일 검사
	public boolean isIdNum(String str) {
		return Pattern.matches("/^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/", str);
	}

	
}
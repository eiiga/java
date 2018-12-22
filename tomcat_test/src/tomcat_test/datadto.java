package tomcat_test;

import java.io.Serializable;

//nameを格納

public class datadto implements Serializable{
	private String word;
	
	public String GetWord() {
		return word;
	}
	
	public void SetWord(String word) {
		this.word = word;
	}
	
}

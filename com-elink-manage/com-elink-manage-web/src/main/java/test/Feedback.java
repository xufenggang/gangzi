package test;

public class Feedback {
	public String sayYourName(String name) {
		if(name != null) {
			name += ",欢迎您！";
		}
		
		return name;
	}
	
}

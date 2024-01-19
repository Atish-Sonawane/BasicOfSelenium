package SeleniumBasics;

public class Try_catch1 {
	public static void main(String[] args) {
		try {
			int a = 1/0;
			System.out.println("in try");
		}
		catch(Exception e){
			System.out.println("in catch");
			System.out.println("exception message "+ e.getMessage());
		}
	}

}

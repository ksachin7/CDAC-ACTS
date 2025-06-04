package recursion;

public class message {
	
	public static void message(int count) {
		
		if(count == 0) {
			return ;
		}
		System.out.println("message call "+count);
		message(count-1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		message(5);
	}

}

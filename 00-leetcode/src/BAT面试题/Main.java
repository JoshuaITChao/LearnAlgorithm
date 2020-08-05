package BAT面试题;

public class Main {

	private static int num = 0;
	
	public static void main(String[] args) {
		
		int ret = sum(100);
		System.out.println(ret);
		
	}
	
	private static int sum(int n) {
		if(n <= 1) return 1;
		num = n;
		num += sum(n-1);
		return num;
	}
	
}

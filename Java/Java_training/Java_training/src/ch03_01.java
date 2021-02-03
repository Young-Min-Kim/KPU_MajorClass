
public class ch03_01 {
	public static void main(String[] args) {
		int sum = 0, i = 0;
		
		do {
			sum = sum + i;
			i+= 2;
		}while(i<99);
		System.out.println(sum);
	}

}

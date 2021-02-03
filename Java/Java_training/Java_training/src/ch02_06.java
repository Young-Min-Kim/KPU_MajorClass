//369 ÇÁ·Î±×·¥
import java.util.Scanner;

public class ch02_06 {
	public static void main(String[] args) {
		
		System.out.print("1~99Áß ¼ýÀÚ ÀÔ·Â : ");
		
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		
		if(i /10 == 3 || i /10 == 6|| i /10 == 9)
		{
			if(i %10 == 3 || i %10 == 6|| i %10 == 9)
			{
				System.out.println("Â¦Â¦");
			}
			else
			{
				System.out.println("Â¦");
			}
		}
		else
		{
			if(i %10 == 3 || i %10 == 6|| i %10 == 9)
			{
				System.out.println("Â¦");
			}
			else
			{
				System.out.println("¹Ú¼ö ¾ÈÄ§");
			}
		}
	}
}

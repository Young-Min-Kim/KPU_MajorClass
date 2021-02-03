import java.util.Scanner;

public class ch03_04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("소문자 알파벳 하나만 입력 >>");
		String s = scanner.next();
		
		if(s.length() != 1) {
			System.out.println("알파벳 하나만 입력해야 합니다");
			scanner.close();
			return ;
		}

		char c = s.charAt(0);
		if(c<'a'||c>'z')
		{
			System.out.println("소문자 알파벳이 아닙니다.");
			scanner.close();
			return ;
		}
		
		
		for(char i=c;i >= 'a'; i--)
		{
			for(char j = 'a';j<=i; j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
	}
}

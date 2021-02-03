import java.io.*;
import java.util.Scanner;

public class ch08_02 {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedReader fr = null;
		File f = new File("c:\\temp\\phone.txt");
		try {
			fw = new FileWriter(f);
			fr = new BufferedReader(new FileReader(f));
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("전화번호 입력 프로그램입니다.");
			while(true) {
				System.out.print("이름 전화번호 >> ");
				String line = scanner.nextLine(); // 한줄을 읽는다.
				int c = fr.read();
				
				if(line.equals("그만"))
						break; // 입력 종료
				fw.write(line+"\n"); // 한 줄 띄어 저장하기 위해 "\r\n"을 붙인다.
			}
			fw.close();
			System.out.println(f.getPath()+"에 저장하였습니다.");
			while(true) {
				String line_con = fr.readLine();
				if(line_con == null)
					break;
				System.out.println(line_con+"\n");
			}
			scanner.close();

			fr.close();

		} 
		catch (IOException e) { // 파일을 저장할 수 없는 경우 예외
			e.printStackTrace();
		}
	}
}
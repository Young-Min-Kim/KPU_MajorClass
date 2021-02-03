package java_training2;
import java.util.Scanner;

interface Stack {
	int length(); // 현재 스택에 저장된 개수 리턴
	int compacity(); //스택의 전체 저장 가능한 개수 리턴
	String pop(); // 스택의 톱(top)에 실수 저장
	boolean push(String val); // 스택의 톱(top)에 저장된 문자 리턴
}

class StringStack implements Stack {
	private String arr[]; // 문자열 저장할 배열 선언
	private int top; // 
	public StringStack(int num) {  //숫자 집어넣는 함수
		arr = new String[num];     //  배열 설정
		top = 0; //탑 초기화 현재 빈상태
	}
	@Override
	public int length() {
		return top;
	}
	@Override
	public int compacity() {
		return arr.length;
	}
	@Override
	public String pop() {  //팝 알고리즘
		if(top==0) // 0이면 비어있다
			return "비어있음";
		else {
			String str = arr[top-1]; // 하나 빼온다
			top--; //탑 하나 내린다.
			return str; //빼온 단어 리턴
		}
	}
	@Override
	public boolean push(String val) { //푸쉬 알고리즘
		if(top == arr.length) //지정한 길이랑 탑이 같아지면 그만둠
			return false;
		else {
			arr[top] = val;
			top++;
			return true;
		}
	}
}

public class ch05_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringStack s;
		
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		s = new StringStack(sc.nextInt());
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			String str = sc.next();
			
			if(str.equals("그만")) {
				break;
			}
			
			boolean result = s.push(str);
			if(result==false)
				System.out.println("스택이 꽉 차서 푸시 불가!");
		}
		
		System.out.print("스택에 저장된 모든 문자열 팝 : ");
		for(int i=0; i<s.length(); i++) {
			System.out.print(s.pop()+" ");
		}
	}
}





import java.util.Scanner;
class Seat{
	int seatNum;
	private String[] sSeat = new String[10];
	private String[] aSeat = new String[10];
	private String[] bSeat = new String[10];
	
	//좌석 초기화
	public Seat() {
		sSeat = new String[10];
		aSeat = new String[10];
		bSeat = new String[10];
		for (int i = 0; i < sSeat.length; i++) {
			sSeat[i] = "---";
			aSeat[i] = "---";
			bSeat[i] = "---";
        }
	}
	
	//좌석 출력
	void print_sSeat() {
		System.out.print("S>>");
		for(int i = 0; i< sSeat.length; i++) {
			System.out.print(" " + sSeat[i]);
		}
		System.out.println();
	}
	void print_aSeat() {
		System.out.print("A>>");
		for(int i = 0; i< sSeat.length; i++) {
			System.out.print(" " + aSeat[i]);
		}
		System.out.println();
	}
	void print_bSeat() {
		System.out.print("B>>");
		for(int i = 0; i< sSeat.length; i++) {
			System.out.print(" " + bSeat[i]);
		}
		System.out.println();
	}
	
	//조회
    void inquiry() {
    	print_sSeat();
    	print_aSeat();
    	print_bSeat();
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
    
    //좌석 구분
	void seatchoice() {
		System.out.print("좌석 구분 S(1), A(2), B(3) >>");
		Scanner scanner = new Scanner(System.in);
		seatNum = scanner.nextInt();
		
		if(seatNum == 1) print_sSeat();
		else if(seatNum == 2) print_aSeat();
		else if(seatNum == 3) print_bSeat();
		else System.out.println("오류: 올바른 번호를 입력하시오");
	}
	
	//예약
	void reservation() {
		seatchoice();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름>> ");
		String name = scanner.next();
		
		System.out.print("번호>>");
		int num = scanner.nextInt();
		
		switch (seatNum) {
        case 1:
            if (sSeat[num - 1] == "---") // 중복 검
            	sSeat[num - 1] = name;
            else
                System.out.println("이미 예약된 자리");
            break;
        case 2:
            if (aSeat[num - 1] == "---")
            	aSeat[num - 1] = name;
            else
                System.out.println("이미 예약된 자리");
            break;
        case 3:
            if (bSeat[num - 1] == "---")
                bSeat[num - 1] = name;
            else
                System.out.println("이미 예약된 자리");
            break;
        default:
            System.out.println("없는 메뉴");
            break;
    }
	}
	void cancel() {
		seatchoice();
		int i = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름>> ");
		String name = scanner.next();
		
		switch (seatNum) {
        case 1:
            for (; i < sSeat.length; i++) {
                if (sSeat[i].equals(name)) {
                    sSeat[i] = "---";
                    break;
                }
            }
            break;
        case 2:
            for (; i < aSeat.length; i++) {
                if (aSeat[i].equals(name)) {
                    aSeat[i] = "---";
                    break;
                }
            }
            break;
        case 3:
            for (; i < bSeat.length; i++) {
                if (bSeat[i].equals(name)) {
                    bSeat[i] = "---";
                    break;
                }
            }
            break;
        default:
            System.out.println("없는 메뉴");
            break;
		}
		if (i == 10) {
			System.out.println("없는 이름");
		}
	}
}


public class ch04_12{
	public static void main(String args[]) {
		System.out.println("명품 콘서트홀 예약 시스템 입니다.");
		Scanner scanner = new Scanner(System.in);
		Seat seat = new Seat();
		while(true) { 
			System.out.print("예약: 1, 조회:2, 취소:3, 끝내기: 4>> ");
			int num = scanner.nextInt(); 
			if(num == 1) {
				seat.reservation();
			}
			else if(num == 2) {
				seat.inquiry();
			}
			else if(num == 3) {
				seat.cancel();
			}
			else if(num == 4) {
				break;
			}
			else {
				System.out.println("없는 메뉴");
			}
		  }	 
	}
}
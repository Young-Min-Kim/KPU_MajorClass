	class TV{ 		// public은 한 파일에 한번 가능하고 퍼블릭 클래스 안에 는 퍼블릭 클래스 사용 가능
		private String TVa;
		private int date;
		private int inch;
		
		public TV(String TV, int date, int inch){ // 생성자 
			this.TVa = TV;
			this.date = date;
			this.inch = inch;
			
		}
		public void show(){			// void 라 출력값 없고 ()에 아무것도 없다 -> 입력값 없음
			System.out.println(this.TVa + "에서 만든" + this.date + "년형" + this.inch + "인치 TV");
		}
		
	}
public class ch04_01 {
	public static void main(String[] args) {
		TV myTV = new TV("LG", 2017, 32);
		myTV.show();
	}

}

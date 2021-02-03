package java_training2;

abstract class PairMap {
	protected String keyArray []; // key 들을 저장하는 배열
	protected String valueArray []; // value 들을 저장하는 배열
	abstract String get(String key); // key 값을 가진 value 리턴. 없으면 null 리턴
	abstract void put(String key, String value); // key와 value를 쌍으로 저장. 기존에 key가 있으면, 값을 value로 수정
	abstract String delete(String key); // key 값을 가진 아이템(value와 함께) 삭제. 삭제된 value 값 리턴
	abstract int length(); // 현재 저장된 아이템 개수 리턴
}

class Dictionary extends PairMap {
	private int num;
	private int cnt = 0;
	public Dictionary(int num) {
		this.num = num;  //배열을 얼마 크기로 넣을지 정하고
		keyArray = new String[num];// 그 배열 크기만큼 배열 생성
		valueArray = new String[num]; // 그 배열 크기만큼 배열 생성
	}
	@Override
	public String get(String key) {
		for(int i=0; i<cnt; i++) {
			if(key.equals(keyArray[i])) {
				return valueArray[i];
			}
		}
		return null;
	}
	@Override
	public void put(String key, String value) {
		if(cnt==num) {
			System.out.println("배열이 꽉 찼습니다.");
			return;
		} // 더이상 저장할 공간이 없을 떄
		
		for(int i=0; i<cnt; i++) {
			if(key.equals(keyArray[i])) {
				valueArray[i] = value; 
				return;
			}
		} // 이미 존재하는 key 값일 때
		
		keyArray[cnt] = key;
		valueArray[cnt] = value;
		cnt++;
	}
	@Override
	public String delete(String key) {
		for(int i=0; i<cnt; i++) {
			if(key.equals(keyArray[i])) {
				valueArray[i] = "null";
				return "null";
			}
		}
		return "해당 이름은 존재하지 않습니다.";
	}
	@Override
	public int length() {
		return cnt;
	}
}

public class ch05_10 {
	public static void main(String[] arsg) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
		System.out.println("이재문의 값은 " + dic.get("이재문")); // 이재문 아이템 출력
		System.out.println("황기태의 값은 " + dic.get("황기태")); // 황기태 아이템 출력
		dic.delete("황기태"); // 황기태 아이템 삭제
		System.out.println("황기태의 값은 " + dic.get("황기태")); // 삭제된 아이템 접근
	}
}



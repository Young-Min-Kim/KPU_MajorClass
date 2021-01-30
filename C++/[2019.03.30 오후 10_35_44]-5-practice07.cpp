//문자열 하나를 입력받아서 그 문자열의 첫글자를 출력하고 줄을 거듭할때마다 한글자 씩 추가해서 출력해 나가는 프로그램  
#include<iostream>
using namespace std;
int main(){
	char word[30];//입력할 문자열을 저장하는 배열
	cout << "문자열 입력>>";
	cin >> word;//문자열 저장
	int i,j,tmp=1;//tmp는 해당 줄에 출력할 문자 개수
	for (i = 0; word[i] != '\0'; i++)//개행문자를 만나기 전까지 for문 수행
	{
		for (j = 0; j < tmp; j++)//tmp만큼 문자 출력
		{
			cout << word[j];
		}
		tmp++;
		cout << "\n";

	
	}

}
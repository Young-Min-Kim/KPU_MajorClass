#include <stdio.h>
#include <stdlib.h>
#define cQ_SIZE  8

typedef int element;		// 큐 원소(element)의 자료형을 char로 정의
typedef struct {
	element queue[cQ_SIZE];	// 1차원 배열 큐 선언
	int front, rear;
} QueueType;

QueueType *createQueue() {
	QueueType *cQ;
	cQ = (QueueType *)malloc(sizeof(QueueType));
	cQ->front = 0;       // front 초깃값 설정
	cQ->rear = 0;        // rear 초깃값 설정
	return cQ;
}



// 원형 큐가 포화 상태인지 검사하는 연산
int isFull(QueueType *cQ) {
	if (((cQ->rear + 1) % cQ_SIZE) == cQ->front) {		//원형큐이기 때문에 나머지 연산 활용
		printf("  Circular Queue is full! ");
		return 1;
	}
	else return 0;
}

// 원형 큐의 rear에 원소를 삽입하는 연산
void enQueue(QueueType *cQ, element item) {
	if (isFull(cQ))	return;
	else {
		cQ->rear = (cQ->rear + 1) % cQ_SIZE;		//원형 큐이기때문에 이 코드 활용하기
		cQ->queue[cQ->rear] = item;
	}
}







void main(void) {
	QueueType *cQ = createQueue();  // 큐 생성
	element data;
	int num=1;
	int p, tmp=0;
	int price;
	while(1) {
		printf("%d 번째 손님 표 구매 개수 : ", num);
		scanf("%d", &p);
		if (p < 0)
		{
			price = tmp * 9000;
			printf("\n당일 매출 : %d매 판매, 이익 %d원\n", tmp, price);
			return 0;
		}

		enQueue(cQ, p);
		num++;
		tmp = p + tmp;
	}
	
}
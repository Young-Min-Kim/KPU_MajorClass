#include <stdio.h>
#include <malloc.h>

typedef int element;     // 연결 큐 원소(element)의 자료형을 char로 정의
typedef struct QNode {    // 연결 큐의 노드를 구조체로 정의
	element data;
	struct QNode *link;
} QNode;

typedef struct {		// 연결 큐에서 사용하는 포인터 front와 rear를 구조체로 정의
	QNode *front, *rear;	//포인터로 선언했기 때문에 값을 원본의 값에 간섭이 가능.
} LQueueType;

// 공백 연결 큐를 생성하는 연산
LQueueType *createLinkedQueue() {
	LQueueType *LQ;
	LQ = (LQueueType *)malloc(sizeof(LQueueType));
	LQ->front = NULL;
	LQ->rear = NULL;
	return LQ;
}


// 연결 큐의 rear에 원소를 삽입하는 연산
void enQueue(LQueueType *LQ, element item) {
	QNode *newNode = (QNode *)malloc(sizeof(QNode));
	newNode->data = item;
	newNode->link = NULL;
	if (LQ->front == NULL) {		// 현재 연결 큐가 공백 상태인 경우
		LQ->front = newNode;
		LQ->rear = newNode;
	}
	else {						// 현재 연결 큐가 공백 상태가 아닌 경우
		LQ->rear->link = newNode;		// A 큐 두에 B큐를 이어준다.
		LQ->rear = newNode;			//rear가 B큐를 가리킨다.
	}
}


void main(void) {

	LQueueType *LQ = createLinkedQueue();  // 연결 큐 생성
	element data;
	int num = 1;
	int p, tmp = 0;
	int price;

	while (1) {
		printf("%d 번째 손님 표 구매 개수 : ", num);
		scanf("%d", &p);
		if (p < 0)
		{
			price = tmp * 9000;
			printf("\n당일 매출 : %d매 판매, 이익 %d원\n", tmp, price);
			return 0;
		}

		enQueue(LQ, p);
		num++;
		tmp = p + tmp;
	}


}
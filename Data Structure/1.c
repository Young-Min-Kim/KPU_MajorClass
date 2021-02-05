//구동 안됨

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning(disable:4996) //scanf_s() 또는 printf_s()를 사용하지 않아서 발생하는 오류를 무시하는 코드
#include <time.h>




// 단순 연결 리스트의 노드 구조를 구조체로 정의
typedef struct ListNode {
	int a;
	int b;
	struct ListNode* link;
} listNode;

// 리스트의 시작을 나타내는 head 노드를 구조체로 정의
typedef struct {
	listNode* head;
} linkedList_h;

// 공백 연결 리스트를 생성하는 연산
linkedList_h* createLinkedList_h(void) {
	linkedList_h* L;
	L = (linkedList_h*)malloc(sizeof(linkedList_h));
	L->head = NULL;		// 공백 리스트이므로 NULL로 설정
	return L;
}


////////////////////////////////////////////////////////////////////
// 연결 리스트를 순서대로 출력하는 연산
void printList(linkedList_h* L) {
	listNode* p;


	p = L->head;
	while (p != NULL) {
		printf("(%d,%d)", p->a, p->b);

		p = p->link;
	}


	// 첫 번째 노드로 삽입하는 연산
	void insertFirstNode(linkedList_h *L, int x, int y) {
		listNode* newNode;
		newNode = (listNode*)malloc(sizeof(listNode));	// 삽입할 새 노드 할당
		newNode->a = x;		// 새 노드의 데이터 필드에 x 저장 
		newNode->b = y;
		newNode->link = L->head;
		L->head = newNode;
	}

	// 노드를 pre 뒤에 삽입하는 연산
	void insertMiddleNode(linkedList_h* L, listNode *pre, int x, int y) {
		listNode* newNode;
		newNode = (listNode*)malloc(sizeof(listNode));
		newNode->a = x;		// 새 노드의 데이터 필드에 x 저장 
		newNode->b = y;
		if (L == NULL) {				// 공백 리스트인 경우
			newNode->link = NULL;		// 새 노드를 첫 번째이자 마지막 노드로 연결
			L->head = newNode;
		}
		else if (pre == NULL) {			// 삽입 위치를 지정하는 포인터 pre가 NULL인 경우
			L->head = newNode;			// 새 노드를 첫 번째 노드로 삽입
		}
		else {
			newNode->link = pre->link;	// 포인터 pre의 노드 뒤에 새 노드 연결
			pre->link = newNode;
		}
	}

	// 마지막 노드로 삽입하는 연산 
	void insertLastNode(linkedList_h* L, int x, int y) {
		listNode* newNode;
		listNode* temp;
		newNode = (listNode*)malloc(sizeof(listNode));
		newNode->a = x;		// 새 노드의 데이터 필드에 x 저장 
		newNode->b = y;
		newNode->link = NULL;
		if (L->head == NULL) {		// 현재 리스트가 공백인 경우					
			L->head = newNode;		// 새 노드를 리스트의 시작 노드로 연결
			return;
		}
		// 현재 리스트가 공백이 아닌 경우 	
		temp = L->head;
		while (temp->link != NULL) temp = temp->link;	// 현재 리스트의 마지막 노드를 찾음
		temp->link = newNode;							// 새 노드를 마지막 노드(temp)의 다음 노드로 연결 
	}


	listNode* searchNode(linkedList_h* L, int x, int y) {
		listNode *temp;
		temp = L->head;
		while (temp != NULL) {
			if (temp->a == x && temp->b == y) return temp;
			else temp = temp->link;
		}
		return temp;
	}


	int main()
	{
		

		linkedList_h* L;
		L = createLinkedList_h();
		clock_t start, finish;
		double duration;
		int n, datl, datr;
		listNode *p;
		FILE* fp;
		fp = fopen("1.txt", "at+");

		start = clock();


		insertFirstNode(L, 0, 0);

		p = searchNode(L, 0, 0);
		while (1) {
			fprintf(stdout, "무엇을 하시겠습니까? 1: 좌표 삽입 2 : 좌표 삽입 종료\n");
			scanf("%d", &n);
			
			if (n == 1)
			{
				fprintf(stdout, "(0,0)부터 (5,5)전까지 임의의 좌표 할당\n");
				scanf("%d %d", &datl, &datr);
				insertMiddleNode(L, p, datl, datr);
			}
			else if (n == 2) {
				printf("삽입 종료\n");

				break;
			}
			else
			{
				printf("잘못 입력하셨습니다. 다시 입력하십시오.\n");
			}
		}

		insertLastNode(L, 5, 5);

		printList(L); getchar();

		finish = clock();
		duration = (double)(finish - start) / CLOCKS_PER_SEC;
		fprintf(stdout, "걸린 시간 : %lf\n", duration);
		fprintf(fp, "걸린 시간 : %lf\n", duration);
		getchar();


		fprintf(stdout, "첫번째 노드에 새로운 노드 5개 삽입\n");
		start = clock();

		for (int i = 0; i < 5; i++)
		{
			scanf("%d %d", &datl, &datr);
			insertFirstNode(L, datl, datr);
			printList(L); getchar();
		}
		finish = clock();
		duration = (double)(finish - start) / CLOCKS_PER_SEC;
		fprintf(stdout, "걸린 시간 : %lf\n", duration);
		fprintf(fp, "걸린 시간 : %lf\n", duration);
		getchar();




		fprintf(stdout, "중간노드 위치에 노드 5번 삽입\n");

		start = clock();
		p = searchNode(L, 0, 0);
		for (int i = 0; i < 5; i++)
		{
			scanf("%d %d", &datl, &datr);
			insertMiddleNode(L, p, datl, datr);
			printList(L); getchar();
		}
		finish = clock();
		duration = (double)(finish - start) / CLOCKS_PER_SEC;
		fprintf(stdout, "걸린 시간 : %lf\n", duration);
		fprintf(fp, "걸린 시간 : %lf\n", duration);




		fprintf(stdout, "마지막 노드 위치에 노드 5번 삽입\n");
		start = clock();
		for (int i = 0; i < 5; i++)
		{
			scanf("%d %d", &datl, &datr);
			insertLastNode(L, datl, datr);
			printList(L); getchar();
		}

		finish = clock();
		duration = (double)(finish - start) / CLOCKS_PER_SEC;
		fprintf(stdout, "걸린 시간 : %lf\n", duration);
		fprintf(fp, "걸린 시간 : %lf\n", duration);

		fclose(fp);
		system("notepad.exe 1.txt");
		getchar();

		return 0;
	}
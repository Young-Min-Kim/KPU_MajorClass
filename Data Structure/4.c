#pragma warning (disable : 4996)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#define CL_SIZE 10;

// 원형 연결 리스트의 노드 구조를 구조체로 정의
typedef struct ListNode {
	int id;
	char data[15];
	int searchNum;
	struct ListNode* link;
} listNode;

//struct ListNode* p[1000];
int structCnt = 0;

// 리스트의 시작을 나타내는 head 노드를 구조체로 정의
typedef struct {
	listNode* head;
} linkedList_h;


// 공백 원형 연결 리스트를 생성하는 연산
linkedList_h* createLinkedList_h(void) {
	linkedList_h* CL;
	CL = (linkedList_h*)malloc(sizeof(linkedList_h));   // 헤드 노드 할당
	CL->head = NULL;                              // 공백 리스트이므로 NULL로 설정
	return CL;
}

// 연결 리스트를 순서대로 출력하는 연산
void printList(linkedList_h* CL, FILE* fp) {
	listNode* p;
	p = CL->head;
	do {
		fprintf(stdout, "%d %s %d\n", p->id, p->data, p->searchNum);
		fprintf(fp, "%d %s %d\n", p->id, p->data, p->searchNum);
		p = p->link;

	} while (p != CL->head);
}

// 첫 번째 노드 삽입 연산
void insertFirstNode(linkedList_h *CL, char* x) {
	listNode* newNode, *temp;
	newNode = (listNode*)malloc(sizeof(listNode));   // 삽입할 새 노드 할당
	strcpy(newNode->data, x);	//알파벳 입력
	if (CL->head == NULL) {      // 원형 연결 리스트가 공백인 경우   
		CL->head = newNode;      // 새 노드를 리스트의 시작 노드로 연결
		newNode->link = newNode;
	}
	else {                  // 원형 연결 리스트가 공백이 아닌 경우    
		temp = CL->head;
		while (temp->link != CL->head)
			temp = temp->link;
		newNode->link = temp->link;
		temp->link = newNode;   // 마지막 노드를 첫 번째 노드인 new와 원형 연결 
		CL->head = newNode;
	}
}

// pre 뒤에 노드를 삽입하는 연산
void insertMiddleNode(linkedList_h* CL, listNode *pre, char* x) {
	listNode* newNode;
	newNode = (listNode*)malloc(sizeof(listNode));		
	strcpy(newNode->data, x);	//알파벳 입력
	newNode->searchNum = 0;		//searchNum 0 으로 초기화
	if (CL->head == NULL) {
		CL->head = newNode;
		newNode->link = newNode;
	}
	else if (pre == NULL)      //탐색한 것이 없을때 즉 pre가 NULL일 경우도 추가하였음
	{
		return;
	}
	else {
		newNode->link = pre->link;
		pre->link = newNode;
	}
}

// 원형 연결 리스트의 pre 뒤에 있는 노드 old를 삭제하는 연산
void deleteNode(linkedList_h* CL, listNode* old) {
	listNode* pre;               // 삭제할 노드의 선행자 노드를 나타내는 포인터   
	if (CL->head == NULL) return;   // 공백 리스트인 경우, 삭제 연산 중단   
	if (CL->head->link == NULL) {   // 리스트에 노드가 한 개만 있는 경우
		free(CL->head);            // 첫 번째 노드의 메모리를 해제하고
		CL->head = NULL;            // 리스트 시작 포인터를 NULL로 설정
		return;
	}
	else if (old == NULL) return;   // 삭제할 노드가 없는 경우, 삭제 연산 중단   
	else {
		pre = CL->head;            // 포인터 pre를 리스트의 시작 노드에 연결      
		while (pre->link != old) {
			pre = pre->link;         // 선행자 노드를 포인터 pre를 이용해 찾음
		}
		pre->link = old->link;
		if (old == CL->head)
			CL->head = old->link;
		free(old);               // 삭제 노드의 메모리를 해제          
	}
}

// 원형 연결 리스트에서 x 노드를 탐색하는 연산
listNode* searchNode(linkedList_h* CL, char* x) {
	listNode *temp;
	temp = CL->head;

	if (strcmp(temp->data, x) == 0) //처음에 temp!=NULL이었는데 만약 찾는 노드가 없다면 무한반복이 되기때문에 코드를 수정함
		return temp;
	else temp = temp->link;

	while (temp != CL->head) {
		if (strcmp(temp->data, x) == 0) return temp;
		else temp = temp->link;
	}
	temp = NULL;
	return temp;   //찾는값이 없을경우 NULL반환
}

void Input(linkedList_h* CL, FILE* fp1);
void searchalp(linkedList_h* CL, FILE* fp2, char * search);
int main()
{
	FILE* fp;
	linkedList_h* CL;
	CL = createLinkedList_h();
	ListNode* p;
	p = (listNode*)malloc(sizeof(listNode));
	p = CL->head;

	printf("알파벳 삽입\n");
	char alpha[2] = "a";
	insertFirstNode(CL, alpha);
	for (int i = 0; i < CL_SIZE i++)
	{
		p = searchNode(CL, alpha);
		alpha[0] = alpha[0] + 1;
		insertMiddleNode(CL, p, alpha);
	}

	int chose;
	while (true)
	{
		printf("1. 랜덤으로 단어장 열기 2. 종료");
		scanf("%d", &chose);
		if (chose == 1)
		{
			srand((unsigned)time(NULL));
			int y;
			y = rand();
			y = rand() % CL_SIZE;
			char note[20] = "notepad.exe ";
			char txt[10] = ".txt";
			char alp1[2] = "a";
			char alp2[10] = "a";
			alp1[0] = alp1[0] + y;
			alp2[0] = alp2[0] + y;
			strcat(note, alp1);
			strcat(note, txt);
			system(note);

			strcat(alp2, ".txt");// ex)a.txt 불러오기

			fp = fopen(alp2, "at+");
			
			
			fclose(fp);
		}
		else if (chose == 2)
		{
			printf("프로그램을 종료합니다.");
			break;

		}
	}
}

//void Input(linkedList_h* CL, FILE* fp1)
//{
//	FILE* fp2;
//	fp2 = fopen("allAlpha.txt", "at+");
//	int id, searchNum = 0;
//	char alphabet[15];
//	ListNode* p, *pre;
//	p = (listNode*)malloc(sizeof(listNode));
//	p = CL->head;
//
//	pre = NULL;
//	structCnt = 0;
//	while (!feof(fp1))
//	{
//		fscanf(fp1, "%d %s", &id, alphabet);
//		insertMiddleNode(CL, pre, id, alphabet, searchNum);
//		pre = searchNode(CL, alphabet);
//		structCnt++;
//	}
//	printList(CL, fp2);			//원형 연결리스트 출력
//
//	fprintf(fp2, "단어의 개수 : %d\n", structCnt);
//	fprintf(stdout, "단어의 개수 : %d\n", structCnt);
//	fprintf(fp2, "-----------------------\n");
//	fclose(fp2);
//	printf("---------------------------\n");
//}
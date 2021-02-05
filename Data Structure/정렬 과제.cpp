#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#define MAX_SIZE 100;
#define SWAP(x, y, t) ( (t)=(x), (x)=(y), (y)=(t) )


// 단순 연결 리스트의 노드 구조를 구조체로 정의
typedef struct ListNode {
	char name[10];
	int age;
	struct ListNode* link;
} listNode;

typedef struct Indexnumber {
	int num;
	struct ListNode* link;
}Index;


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



// 연결 리스트를 순서대로 출력하는 연산
void printList( Index *in) {
	int i = 0;

	for (i = 0; i < 10; i++)
	{
		printf("%d", in[i].num);
		printf("%s ", in[i].link->name);
		printf("%d\n", in[i].link->age);
	
	}
}

// 첫 번째 노드로 삽입하는 연산
void insertFirstNode(linkedList_h *L ,char *x, int a) {
	listNode* newNode;
	newNode = (listNode*)malloc(sizeof(listNode));	// 삽입할 새 노드 할당
	strcpy(newNode->name, x);						// 새 노드의 데이터 필드에 x 저장  
	newNode->age = a;
	newNode->link = L->head;
	L->head = newNode;
}





void selection_sort(Index *list, int n)
{
	int i, j, least;
	Index temp;
	for (i = 0; i<n - 1; i++) {
		least = i;
		for (j = i + 1; j<n; j++) // 최솟값 탐색
			if (list[j].num<list[least].num) least = j;
		SWAP(list[i].num, list[least].num, temp.num);
	}
}
void linkindex(linkedList_h *L, Index in, int n)
{
	
}

int main(void)
{
	Index in[10];

	linkedList_h* L;
	L = createLinkedList_h();


	printf("(1) 공백 리스트 생성하기! \n");


	insertFirstNode(L, "가가가", 20);
	in[0].num = 2;
	in[0].link = L->head;
	insertFirstNode(L, "나나나", 21);
	in[1].num = 4;
	in[1].link = L->head;
	insertFirstNode(L, "라라라", 22);
	in[2].num = 6;
	in[2].link = L->head;
	insertFirstNode(L, "다다다", 22);
	in[3].num = 8;
	in[3].link = L->head;
	insertFirstNode(L, "라라라", 22);
	in[4].num = 10;
	in[4].link = L->head;
	insertFirstNode(L, "마마마", 22);
	in[5].num = 9;
	in[5].link = L->head;
	insertFirstNode(L, "바바바", 22);
	in[6].num = 7;
	in[6].link = L->head;
	insertFirstNode(L, "사사사", 22);
	in[7].num = 5;
	in[7].link = L->head;
	insertFirstNode(L, "아아아", 22);
	in[8].num = 3;
	in[8].link = L->head;
	insertFirstNode(L, "자자자", 22);
	in[9].num = 1;
	in[9].link = L->head;

	printf("정렬 전\n");
	printList(in);

	selection_sort(in, 10);
	printf("정렬 후\n");
	printList(in);


}
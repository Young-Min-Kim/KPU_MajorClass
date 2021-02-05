#include<stdio.h> 
#include<stdlib.h>
#include<string.h>
#include <time.h>

typedef int element;		// 이진 탐색 트리 element의 자료형을 char로 정의
typedef struct treeNode {
	int num;
	char name[10];
	int age;
	double grade;
	char soge[30];
	clock_t start, finish;
	double duration;

	struct treeNode* left;	// 왼쪽 서브 트리 링크 필드
	struct treeNode* right;	// 오른쪽 서브 트리 링크 필드
} treeNode;

// 이진 탐색 트리에서 키값이 x인 노드의 위치를 탐색하는 연산
treeNode* searchBST(treeNode* root, int x) {
	treeNode* p;
	p = root;
	while (p != NULL) {
		if (x < p->num) p = p->left;
		else if (x == p->num) return p;
		else p = p->right;
	}
	printf("\n 찾는 키가 없습니다!");
	return p;
}

// 포인터 p가 가리키는 노드와 비교하여 노드 x를 삽입하는 연산
treeNode* insertNode(treeNode *p, int x, char *n, int a, double g, char *s) {
	treeNode *newNode;
	if (p == NULL) {
		newNode = (treeNode*)malloc(sizeof(treeNode));
		newNode->num = x;
		strcpy(newNode->name, n);
		newNode->age = a;
		newNode->grade = g;
		strcpy(newNode->soge, s);
		newNode->left = NULL;
		newNode->right = NULL;
		return newNode;				//이 코드의 의미는 가장 아래의 p->right에 새로운 노드를 추가하기 위함
	}
	else if (x < p->num)  p->left = insertNode(p->left, x, n, a, g, s);  //루트보다 앞의 문자인 경우
	else if (x > p->num)  p->right = insertNode(p->right, x, n, a, g, s);//루트보다 뒤의 문자인 경우
	else  printf("\n 이미 같은 키가 있습니다! \n");

	return p;		//다시 p를 return 해주는 이유는 재귀 호출 복귀시에 p->right에 데이터를 입력
}

//2019130323
//2018152011
//2018152017
//2019130044
//2017130042
//2016140323
//2015152011
//2018153017
//2017130045
//2019101042
//입력

int main() {
	FILE* fp;

	treeNode* root = NULL;
	treeNode* foundedNode = NULL;
	char choice;
	int num, number;
	int n = 0;
	char name[10];
	int age;
	double grade;
	char soge[30];

	clock_t start, finish;
	double duration;

	char tmp[15];

	int a=0;
	while (a < 10)
	{
		printf("트리를 작성할 학번을 10개 입력하세요 : ");
		scanf("%d", &n);
		sprintf(tmp, "%d", n);

		strcat(tmp, ".txt");//학번.txt

		if (fopen(tmp, "rt") == NULL)
		{
			printf("잘못 입력 하셨습니다.\n");
			return 0;
		}
		fp = fopen(tmp, "rt");

		fscanf(fp, "%s %d %d %d %s", name, &number, &age, &grade, soge);
		if (root == NULL) {
			root = insertNode(root, number, name, age, grade, soge);
		}
		else {
			insertNode(root, number, name, age, grade, soge);
		}
		a++;
	}

	char note1[30] = "notepad.exe ";
	char tmp1[15];

	printf("탐색할 노드 학번 입력 : ");
	scanf("%d", &num);

	sprintf(tmp1, "%d", num);

	strcat(tmp1, ".txt");//학번.txt
	strcat(note1, tmp1);//notepad.exe 학번.txt

	//if (fopen(tmp, "rt") == NULL)
	//{
	//	printf("찾는 학번 없음\n");
	//	return 0;
	//}
	//fp = fopen(tmp, "rt");

	//fscanf(fp, "%s %d %d %d %s", name, &number, &age, &grade, soge);

	start = clock();
	foundedNode = searchBST(root, root->num);
	if (foundedNode != NULL)
		printf("학번 탐색 성공\n");
	else  printf("찾는 학번 없음\n");
	
	finish = clock();
	system(note1);
	duration = (double)(finish - start) / CLOCKS_PER_SEC;

	printf("걸린 시간 : %lf초\n", duration);

	fclose(fp);

	return 0;
}
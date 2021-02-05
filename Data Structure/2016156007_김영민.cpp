
//구조체 배열 사용 도중 계속 오류가 나서 연결리스트로 변경 하였습니다.
#include<stdio.h> 
#include<stdlib.h>
#include<string.h>

typedef int element;		// 이진 탐색 트리 element의 자료형을 char로 정의

typedef struct treeNode {
	char name[10];
	int num;
	int guk;
	int eng;
	int math;

	double v;
	char hak;
	struct treeNode* left;	// 왼쪽 서브 트리 링크 필드
	struct treeNode* right;	// 오른쪽 서브 트리 링크 필드
} treeNode;


// 포인터 p가 가리키는 노드와 비교하여 노드 x를 삽입하는 연산
treeNode* insertNode(treeNode *p, int x, char* n, int g, int e, int m) {
	treeNode *newNode;
	double average;
	if (p == NULL) {
		newNode = (treeNode*)malloc(sizeof(treeNode));
		newNode->num = x;
		strcpy(newNode->name, n);
		newNode->guk = g;
		newNode->eng = e;
		newNode->math = m;

		newNode->v = (g + e + m) / 3;

		if (newNode->v >= 90)
			newNode->hak = 'A';
		else if (newNode->v >= 80)
			newNode->hak = 'B';
		else if (newNode->v >= 70)
			newNode->hak = 'c';
		else
			newNode->hak = 'F';


		newNode->left = NULL;
		newNode->right = NULL;
		return newNode;
	}
	else if (x < p->num)  p->left = insertNode(p->left, x, n, g, e, m);
	else if (x > p->num)  p->right = insertNode(p->right, x, n, g, e, m);
	else  printf("\n 이미 같은 키가 있습니다! \n");

	return p;
}


void deleteNode(treeNode *root, element num) {
	treeNode *parent, *p, *succ, *succ_parent;
	treeNode *child;

	parent = NULL;
	p = root;
	while ((p != NULL) && (p->num != num)) {
		parent = p;
		if (num < p->num) p = p->left;
		else p = p->right;
	}


	if (p == NULL) {
		printf("\n 찾는 키가 이진 트리에 없습니다!!");
		return;
	}


	if ((p->left == NULL) && (p->right == NULL)) {
		if (parent != NULL) {
			if (parent->left == p) parent->left = NULL;
			else parent->right = NULL;
		}
		else root = NULL;
	}


	else if ((p->left == NULL) || (p->right == NULL)) {
		if (p->left != NULL) child = p->left;
		else child = p->right;

		if (parent != NULL) {
			if (parent->left == p) parent->left = child;
			else parent->right = child;
		}
		else root = child;
	}

	else {
		succ_parent = p;
		succ = p->left;
		while (succ->right != NULL) {
			succ_parent = succ;
			succ = succ->right;
		}
		if (succ_parent->left == succ)  succ_parent->left = succ->left;
		else succ_parent->right = succ->left;
		p->num = succ->num;
		p = succ;
	}
	free(p);
}


void displayInorder(treeNode* root) {
	if (root) {
		displayInorder(root->left);

		printf("%s ", root->name);
		printf("%d ", root->num);
		printf("%.1lf ", root->v);
		printf("%c\n", root->hak);

		displayInorder(root->right);
	}
}

void menu() {
	printf("(1) 추가 (2) 수정 (3) 삭제 (4) 출력 (5) 종료\n");

}

int main() {

	treeNode* root = NULL;
	treeNode* foundedNode = NULL;



	char choice;
	char name[10];
	int num;
	int guk;
	int eng;
	int math;



	while (1) {
		menu();
		scanf_s(" %d", &choice);

		switch (choice) {
		case 1:
			printf("학생 데이터 입력하세요.\n");

			printf("학번 : ");
			scanf_s("%d", &num);
			printf("이름 : ");
			scanf("%s", name);
			printf("국어 : ");
			scanf_s("%d", &guk);
			printf("영어 : ");
			scanf_s("%d", &eng);
			printf("수학 : ");
			scanf_s("%d", &math);


			if (root == NULL) {
				root = insertNode(root, num, name, guk, eng, math);
			}
			else {
				insertNode(root, num, name, guk, eng, math);
			}

			break;

		case 2:	printf("수정할 학번을 입력하세요 : ");//이름 입력도중 계속 오류가 나서 학번으로 변경하였습니다.
			scanf_s("%d", &num);
			deleteNode(root, num);

			printf("학번 : ");
			scanf_s("%d", &num);
			printf("이름 : ");
			scanf("%s", name);
			printf("국어 : ");
			scanf_s("%d", &guk);
			printf("영어 : ");
			scanf_s("%d", &eng);
			printf("수학 : ");
			scanf_s("%d", &math);

			if (root == NULL) {
				root = insertNode(root, num, name, guk, eng, math);
			}
			else {
				insertNode(root, num, name, guk, eng, math);
			}

			break;

		case 3:	printf("삭제할 학번을 입력하세요 : ");
			scanf_s("%d", &num);
			deleteNode(root, num);
			break;

		case 4:
			displayInorder(root);


			break;

		case 5:
			printf("종료합니다.\n");

			return 0;
		default: printf("없는 메뉴입니다. 다시 선택하세요. \n");
			break;
		}
	}
}
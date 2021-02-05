
//출력된 note를 닫으면 값은 저장되어 있습니다.

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>
#include <time.h>
#define MAX(a,b) ((a>b)?a:b)

typedef int element;

typedef struct treeNode {
	element key;
	struct treeNode *left;
	struct treeNode *right;
}treeNode;

treeNode* LL_rotate(treeNode *parent) {
	treeNode *child = parent->left;
	parent->left = child->right;
	child->right = parent;
	return child;
}

treeNode* RR_rotate(treeNode *parent) {
	treeNode *child = parent->right;
	parent->right = child->left;
	child->left = parent;
	return child;
}

treeNode* LR_rotate(treeNode *parent) {
	treeNode *child = parent->left;
	parent->left = RR_rotate(child);
	return LL_rotate(parent);
}

treeNode* RL_rotate(treeNode *parent) {
	treeNode *child = parent->right;
	parent->right = LL_rotate(child);
	return RR_rotate(parent);
}

// 서브 트리의 높이를 구하는 연산
int getHeight(treeNode* p) {
	int height = 0;
	if (p != NULL) height = MAX(getHeight(p->left), getHeight(p->right)) + 1;
	return height;
}

// 서브 트리의 높이를 이용해 균형 인수 BF를 구하는 연산
int getBF(treeNode* p) {
	if (p == NULL) return 0;
	return getHeight(p->left) - getHeight(p->right);
}

// BF를 검사하여 불균형이 발생한 경우, 회전 연산 호출
treeNode* rebalance(treeNode** p) {
	int BF = getBF(*p);
	if (BF > 1) {
		if (getBF((*p)->left) > 0)
			*p = LL_rotate(*p);
		else    *p = LR_rotate(*p);
	}
	else if (BF < -1) {
		if (getBF((*p)->right) < 0)
			*p = RR_rotate(*p);
		else *p = RL_rotate(*p);
	}
	return *p;
}

// AVL 트리에 노드를 삽입하는 연산: 이진 탐색 연산처럼 삽입한 후에, rebalance() 호출 
treeNode* insert_AVL_Node(treeNode** root, element x) {
	if (*root == NULL) {
		*root = (treeNode*)malloc(sizeof(treeNode));
		(*root)->key = x;
		(*root)->left = NULL;
		(*root)->right = NULL;
	}
	else if (x < (*root)->key) {
		(*root)->left = insert_AVL_Node(&((*root)->left), x);
		*root = rebalance(root);
	}
	else if (x >(*root)->key) {
		(*root)->right = insert_AVL_Node(&((*root)->right), x);
		*root = rebalance(root);
	}
	else {
		printf("\n 이미 같은 키가 있습니다! \n");
		exit(1);
	}
	return *root;
}

// 이진 탐색 트리에 노드를 삽입하는 연산 : [예제 7-4]의 25~39행
treeNode* insert_BST_Node(treeNode *p, element x) {
	treeNode *newNode;
	if (p == NULL) {
		newNode = (treeNode*)malloc(sizeof(treeNode));
		newNode->key = x;
		newNode->left = NULL;
		newNode->right = NULL;
		return newNode;
	}
	else if (x < p->key)  p->left = insert_BST_Node(p->left, x);
	else if (x > p->key)  p->right = insert_BST_Node(p->right, x);
	else  printf("\n 이미 같은 키가 있습니다! \n");

	return p;
}

// 이진 탐색 트리와 AVL 트리에서 키값 x를 탐색하는 연산 : [예제 7-4]의 12~22행 수정
treeNode* searchTree(treeNode* root, element x) {
	treeNode* p;
	int count = 0;
	p = root;
	while (p != NULL) {
		count++;
		if (x < p->key) p = p->left;
		else if (x == p->key) {
			printf("탐색 성공");
			return p;
		}
		else p = p->right;
	}
	count++;
	printf("탐색 실패! 찾는 키가 없습니다!");
	return 1;
}

// 이진 탐색 트리를 중위 순회하면서 출력하는 연산 : [예제 7-4]의 098~104행
void displayInorder(treeNode* root) {
	if (root) {
		displayInorder(root->left);
		printf("_%d ", root->key);
		displayInorder(root->right);
	}
}

int main() {
	treeNode* root_AVL = NULL;
	treeNode* root_BST = NULL;

	//////////////////////////////////////////////////////////////////
	root_AVL = insert_AVL_Node(&root_AVL, 2019130323); // AVL 트리 만들기
	insert_AVL_Node(&root_AVL, 2018152011);
	insert_AVL_Node(&root_AVL, 2018152017);
	insert_AVL_Node(&root_AVL, 2019130044);
	insert_AVL_Node(&root_AVL, 2017130042);
	insert_AVL_Node(&root_AVL, 2016140323);
	insert_AVL_Node(&root_AVL, 2015152011);
	insert_AVL_Node(&root_AVL, 2018153017);
	insert_AVL_Node(&root_AVL, 2017130045);
	insert_AVL_Node(&root_AVL, 2019101042);



	/////////////////////////////////////////////////////////////////////////////
	root_BST = insert_BST_Node(root_BST, 2019130323); //BST 만들기
	insert_BST_Node(root_BST, 2018152011);
	insert_BST_Node(root_BST, 2018152017);
	insert_BST_Node(root_BST, 2019130044);
	insert_BST_Node(root_BST, 2017130042);
	insert_BST_Node(root_BST, 2016140323);
	insert_BST_Node(root_BST, 2015152011);
	insert_BST_Node(root_BST, 2018153017);
	insert_BST_Node(root_BST, 2017130045);
	insert_BST_Node(root_BST, 2019101042);




	FILE* fp1;

	fp1 = fopen("AVL.txt", "wt");

	int num;
	treeNode* foundedNode = NULL;

	clock_t start, finish;
	double duration1, duration2;


	printf("AVL과 이진트리로 탐색할 노드 학번 입력 : ");
	scanf("%d", &num);



	start = clock();
	
	foundedNode = searchTree(root_AVL, num);
	if (foundedNode == 1)
	{
		return 0;
	}
	finish = clock();

	duration1 = (double)(finish - start) / CLOCKS_PER_SEC;

	fprintf(fp1,"걸린 시간 : %lf초\n", duration1);
	system("notepad.exe AVL.txt");
	fclose(fp1);

	FILE* fp2;
	fp2 = fopen("BST.txt", "wt");

	start = clock();
	foundedNode = searchTree(root_BST, num);

	finish = clock();
	duration2 = (double)(finish - start) / CLOCKS_PER_SEC;

	fprintf(fp2, "걸린 시간 : %lf초\n", duration2);
	system("notepad.exe BST.txt");
	fclose(fp2);
	
	if (duration1 < duration2)
	{
		printf("AVL이 BST보다 %lf초 더 빠름", duration2-duration1);
	}
	else
	{
		printf("BST이 AVL보다 %lf초 더 빠름", duration1 - duration2);
	}

	return 0;
}
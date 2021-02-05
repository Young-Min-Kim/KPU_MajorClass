#pragma warning (disable : 4996)

#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>
#include "sqlite3.h" 

void output(FILE* fp2);

void input(FILE* fp3);
typedef struct gugu {

	int id;
	int piop1;
	char op1;
	int piop2;
	char op2;
	int result;
	struct gugu* link;

}GUGU;
GUGU* p[100];
int structCnt = 0;
int main()

{
	sqlite3 *db;
	sqlite3_stmt *stmt = NULL;
	int error = sqlite3_open("gugudan.db", &db);
	char *sql;
	char query[256];
	int i, j, result;

	int cnt = 0;



	FILE* fp;

	fp = fopen("1.txt", "w+");



	for (i = 9; i > 1; i--)

	{

		for (j = 9; j > 0; j--)

		{

			cnt = cnt + 1;

			result = i * j;

			//fprintf(stdout, "(%03d) %d * %d = %d \n", cnt, i, j, result);

			fprintf(fp, "%03d %d * %d = %d \n", cnt, i, j, result);

		}

		//fprintf(stdout, "\n---------------------\n");

		fprintf(fp, "---------------------\n");

	}
	output(fp);
	fclose(fp);
	fp = fopen("1.txt", "r+");
	input(fp);
	fclose(fp);


	if (error)
	{
		fprintf(stderr, "DB 접속 실패. (오류 %s)\n", sqlite3_errmsg(db));
	}

	fprintf(stdout, "DB 연결 완료.\n");
	sql = "CREATE TABLE IF NOT EXISTS gugudan (id INTEGER, piop1 INTEGER, op1 TEXT, piop2 INTEGER, op2 TEXT, result INTEGER)";

	if (sqlite3_prepare_v2(db, sql, -1, &stmt, 0) == SQLITE_OK)
	{
		sqlite3_step(stmt);
	}
	sqlite3_finalize(stmt);
	for (i = 0; i < structCnt; i++) {
		sprintf(query, "insert into gugudan values(%d, %d, '%c', %d, '%c', %d)", p[i]->id, p[i]->piop1, p[i]->op1, p[i]->piop2,p[i]->op2, p[i]->result);
		sql = query;
		if (sqlite3_prepare_v2(db, sql, -1, &stmt, 0) == SQLITE_OK)
		{
			sqlite3_step(stmt);
		}
		else
		{
			puts("테이블 값 입력에 실패하였습니다.");
		}
	}
	
	//sql = "INSERT INTO test VALUES(1, 'aaa')";
	sqlite3_finalize(stmt);
	sqlite3_close(db);
	system("notepad.exe 1.txt");
	return 0;

}



void output(FILE* fp2)

{
	fprintf(fp2, "만든이 : %s\n", "김영민");
}





void input(FILE* fp3)

{
	int id, piop1=-1, piop2 = -1, result; 
	char  op1, op2, line[40], temp; // temp는 개행 문자 제거용 변수

	while (1) {
		if (piop1 == 2 && piop2 == 1) // 구구단 끝 확인
			break;
		if (piop2 == 1) {  // 각 단의 끝 확인
			fgets(line, 40, fp3);
			piop2 = 9;
			fprintf(stdout,"%s",line);
		}
		else {
			p[structCnt] = malloc(sizeof(GUGU));
			fscanf(fp3, "%d %d %c %d %c %d %c", &id, &piop1, &op1, &piop2, &op2, &result, &temp);
			p[structCnt]->id = id;
			p[structCnt]->piop1 = piop1;
			p[structCnt]->op1 = op1;
			p[structCnt]->piop2 = piop2;
			p[structCnt]->op2 = op2;
			p[structCnt]->result = result;
			fprintf(stdout, "%03d %d %c %d %c %d\n", p[structCnt]->id, p[structCnt]->piop1, p[structCnt]->op1, p[structCnt]->piop2, p[structCnt]->op2, p[structCnt]->result);
			structCnt++;
		}
	}
	fprintf(stdout, "%s", line);
	fprintf(stdout, "만든이 : %s\n", "김영민");
}
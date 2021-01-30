//Calculator.cpp
#include"Calculator.h"

void Add::setValue(int x, int y)
{
	a = x;
	b = y;
}
int Add::calculate()//µ¡¼À ±¸Çö
{
	return a + b;
}

void Sub::setValue(int x, int y)
{
	a = x;
	b = y;
}
int Sub::calculate()//»¬¼À ±¸Çö
{
	return a - b;
}

void Mul::setValue(int x, int y)
{
	a = x;
	b = y;
}
int Mul::calculate()//°ö¼À ±¸Çö
{
	return a * b;
}

void Div::setValue(int x, int y)
{
	a = x;
	b = y;
}
int Div::calculate()//³ª´°¼À ±¸Çö
{
	return a / b;
}
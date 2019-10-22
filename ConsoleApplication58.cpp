// ConsoleApplication58.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


#include <iostream>
#include <time.h>
using namespace std;
template <class T>
class CMatrix//класс матрица
{
public:
	CMatrix()//конструктор 
	{
		row = 0;
		col = 0;
	}
	CMatrix(int rows, int cols)//конструктор  с параметрами
	{
		row = rows;
		col = cols;
		srand(time(0));
		data = new T*[rows];
		for (int i = 0; i < row; i++) //выделяем память под строки
		{
			data[i] = new T[cols];
		}

		for (int i = 0; i < row; i++) //идем в цикле и выделяем память под столбцы
		{
			for (int j = 0; j < cols; j++)//идем в цикле
			{
				data[i][j] = (float)rand() / (float)rand();//заполняем рандомом
			}
		}
	}

	void print();//вывод
	void print1(int c, int r);//вывод подматрицы
	void setRow(int r)//установка количества строк
	{//

		if (r>row)//если их больше, чем есть сейчас
		{
			for (int i = 0; i < r; i++) //выделяем память
			{
				data[i] = new T[col];
			}

			for (int i = 0; i < r; i++) //идем в цикле
			{
				for (int j = 0; j < col; j++) //идем в цикле
				{
					data[i][j] = (float)rand() / (float)rand();//заполняем рандомом
				}
			}
		}
		row = r;
	}
	void setCol(int c)//установка количества столбцов
	{
		if (c>col)//если их больше, чем есть сейчас
		{
			for (int i = 0; i < row; i++) //выделяем память
			{
				data[i] = new T[c];
			}

			for (int i = 0; i < row; i++)//идем в цикле
			{
				for (int j = 0; j < c; j++)//идем в цикле
				{
					data[i][j] = (float)rand() / (float)rand();//заполняем рандомом
				}
			}
		}
		col = c;
	}
	T& operator()(int row, int col);//конструктор копирования
private:
	T **data;//сама матрица
	int row, col;//строки и колонки
};

template <class T>//
void CMatrix<T>::print()//метод вывода на экран
{
	int i, j;

	for (i = 0; i < row; i++) //идем в цикле
	{
		for (j = 0; j < col; j++) //идем в цикле
		{
			printf("%.1f    ", (float)data[i][j]);//вывод на экран
		}
		printf("\n");
	}
}
template <class T>//
void CMatrix<T>::print1(int r, int c)//метод вывода сабматрицы на экран
{
	int i, j;
	if (r>row)//если r>row
	{
		r = row;
	}
	if (c>col)//если c>col
	{
		c = col;
	}
	for (i = 0; i < c; i++) //идем в цикле
	{
		for (j = 0; j < r; j++) //идем в цикле
		{
			printf("%.1f    ", (float)data[i][j]);//вывод сабматрицы
		}
		printf("\n");
	}
}

template<class T> T& CMatrix<T>::operator()(int row, int col)//
{
	return data[row][col];//
}
int main()//мейн
{
	int c, r;
	cout << "Input row: ";
	cin >> c;//
	cout << "Input column: ";
	cin >> r;	//
	CMatrix <float> m(c, r);//создаем матрицы
	while (true)//цикл
	{
		int ind;//выводим меню
		cout << "1)Output matrix\n";
		cout << "2)Output submatrix\n";
		cout << "3)Set Column\n";
		cout << "4)Set Rows\n";
		cout << "5)Exit\n";
		cin >> ind;
		if (ind == 1)//если выбрали 1 пункт - вызываем вывод
		{
			m.print();
		}
		if (ind == 2)//если выбрали 2 пункт - вызываем вывод сабматрицы
		{
			int c, r;
			cout << "Input row: ";
			cin >> c;
			cout << "Input column: ";
			cin >> r;
			m.print1(c, r);
		}
		if (ind == 3)//если выбрали 3 пункт - вызываем сменю кол-ва колонок
		{
			int c;
			cout << "Input column: ";
			cin >> c;
			m.setCol(c);
		}
		if (ind == 4)//если выбрали 4 пункт - вызываем сменю кол-ва столбцов
		{
			int r;
			cout << "Input row: ";
			cin >> r;
			m.setRow(r);
		}
		if (ind == 5)//если выбрали 5 пункт - выходим
		{
			break;
		}
	}
	system("pause");//
	return 0;
}
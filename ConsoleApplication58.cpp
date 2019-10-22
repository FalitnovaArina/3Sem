// ConsoleApplication58.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"


#include <iostream>
#include <time.h>
using namespace std;
template <class T>
class CMatrix//����� �������
{
public:
	CMatrix()//����������� 
	{
		row = 0;
		col = 0;
	}
	CMatrix(int rows, int cols)//�����������  � �����������
	{
		row = rows;
		col = cols;
		srand(time(0));
		data = new T*[rows];
		for (int i = 0; i < row; i++) //�������� ������ ��� ������
		{
			data[i] = new T[cols];
		}

		for (int i = 0; i < row; i++) //���� � ����� � �������� ������ ��� �������
		{
			for (int j = 0; j < cols; j++)//���� � �����
			{
				data[i][j] = (float)rand() / (float)rand();//��������� ��������
			}
		}
	}

	void print();//�����
	void print1(int c, int r);//����� ����������
	void setRow(int r)//��������� ���������� �����
	{//

		if (r>row)//���� �� ������, ��� ���� ������
		{
			for (int i = 0; i < r; i++) //�������� ������
			{
				data[i] = new T[col];
			}

			for (int i = 0; i < r; i++) //���� � �����
			{
				for (int j = 0; j < col; j++) //���� � �����
				{
					data[i][j] = (float)rand() / (float)rand();//��������� ��������
				}
			}
		}
		row = r;
	}
	void setCol(int c)//��������� ���������� ��������
	{
		if (c>col)//���� �� ������, ��� ���� ������
		{
			for (int i = 0; i < row; i++) //�������� ������
			{
				data[i] = new T[c];
			}

			for (int i = 0; i < row; i++)//���� � �����
			{
				for (int j = 0; j < c; j++)//���� � �����
				{
					data[i][j] = (float)rand() / (float)rand();//��������� ��������
				}
			}
		}
		col = c;
	}
	T& operator()(int row, int col);//����������� �����������
private:
	T **data;//���� �������
	int row, col;//������ � �������
};

template <class T>//
void CMatrix<T>::print()//����� ������ �� �����
{
	int i, j;

	for (i = 0; i < row; i++) //���� � �����
	{
		for (j = 0; j < col; j++) //���� � �����
		{
			printf("%.1f    ", (float)data[i][j]);//����� �� �����
		}
		printf("\n");
	}
}
template <class T>//
void CMatrix<T>::print1(int r, int c)//����� ������ ���������� �� �����
{
	int i, j;
	if (r>row)//���� r>row
	{
		r = row;
	}
	if (c>col)//���� c>col
	{
		c = col;
	}
	for (i = 0; i < c; i++) //���� � �����
	{
		for (j = 0; j < r; j++) //���� � �����
		{
			printf("%.1f    ", (float)data[i][j]);//����� ����������
		}
		printf("\n");
	}
}

template<class T> T& CMatrix<T>::operator()(int row, int col)//
{
	return data[row][col];//
}
int main()//����
{
	int c, r;
	cout << "Input row: ";
	cin >> c;//
	cout << "Input column: ";
	cin >> r;	//
	CMatrix <float> m(c, r);//������� �������
	while (true)//����
	{
		int ind;//������� ����
		cout << "1)Output matrix\n";
		cout << "2)Output submatrix\n";
		cout << "3)Set Column\n";
		cout << "4)Set Rows\n";
		cout << "5)Exit\n";
		cin >> ind;
		if (ind == 1)//���� ������� 1 ����� - �������� �����
		{
			m.print();
		}
		if (ind == 2)//���� ������� 2 ����� - �������� ����� ����������
		{
			int c, r;
			cout << "Input row: ";
			cin >> c;
			cout << "Input column: ";
			cin >> r;
			m.print1(c, r);
		}
		if (ind == 3)//���� ������� 3 ����� - �������� ����� ���-�� �������
		{
			int c;
			cout << "Input column: ";
			cin >> c;
			m.setCol(c);
		}
		if (ind == 4)//���� ������� 4 ����� - �������� ����� ���-�� ��������
		{
			int r;
			cout << "Input row: ";
			cin >> r;
			m.setRow(r);
		}
		if (ind == 5)//���� ������� 5 ����� - �������
		{
			break;
		}
	}
	system("pause");//
	return 0;
}
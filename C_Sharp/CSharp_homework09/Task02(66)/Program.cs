// Задача 66: Задайте значения M и N. Напишите программу,
// которая найдёт сумму натуральных элементов в промежутке от M до N.
// M = 1; N = 15 -> 120
// M = 4; N = 8. -> 30

using System;
using static System.Console;


// Ввод числа с консоли
int Prompt(string message)
{
    Write(message);
    return Convert.ToInt32(ReadLine()!);
}

// Нахождение суммы чисел в промежутке
int GetSumNumbers(int start, int end)
{
    if (start == end)
        return start;

    int result = start + GetSumNumbers(start + 1, end);
    return result;
}


int m = Prompt("M = ");
int n = Prompt("N = ");

if (m < n)
    Write(GetSumNumbers(m, n));
else
    Write(GetSumNumbers(n, m));

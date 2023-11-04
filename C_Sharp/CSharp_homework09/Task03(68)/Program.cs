// Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
// m = 2, n = 3 -> A(m,n) = 9
// m = 3, n = 2 -> A(m,n) = 29

using System;
using static System.Console;

// Ввод целого неотрицательного числа с консоли
int Prompt(string message)
{
    Write(message);
    int num = Convert.ToInt32(ReadLine()!);
    if (num < 0)
    {
        WriteLine("Число должно быть не меньше 0");
        num = Prompt(message); // Если введено отрицательное, программа предлагает повторить ввод.
    }
    return num;
}

// Функция Аккермана
int Ackerman(int m, int n)
{
    if (m == 0)
        return n + 1;
    else if (n == 0)
        return Ackerman(m - 1, 1);
    else
        return Ackerman(m - 1, Ackerman(m, n - 1));
}


int num1 = Prompt("m = ");
int num2 = Prompt("n = ");
Write(Ackerman(num1, num2));
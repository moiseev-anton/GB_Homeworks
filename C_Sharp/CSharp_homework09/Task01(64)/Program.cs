// Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.

// N = 5 -> "5, 4, 3, 2, 1"
// N = 8 -> "8, 7, 6, 5, 4, 3, 2, 1"

using System;
using static System.Console;

// Ввод натурального числа с консоли
int Prompt(string message)
{
    Write(message);
    int num = Convert.ToInt32(ReadLine()!);
    if (num < 1)  // Проверяем натуральное ли число введено
    {
        WriteLine("Введено не корректное значение");
        num = Prompt(message); // Если введено не натуральное число, программа предлагает повторить ввод.
    }
    return num;
}

// Сбор чисел от N до 1 в строку
string GetNumbers(int number)
{
    if (number == 1)
        return "1";
    
    string s = number.ToString() + ' ' + GetNumbers(number - 1);
    return s;
}


int n = Prompt("N = ");
Write(GetNumbers(n));
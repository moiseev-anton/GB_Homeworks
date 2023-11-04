// Задача 23: Напишите программу, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.

// 3 -> 1, 8, 27 
// 5 -> 1, 8, 27, 64, 125

Console.Clear();

Console.WriteLine("Введите число");
Console.Write("N = ");
int N = Convert.ToInt32(Console.ReadLine());

int i = 1;
if (N < 0)
{
    i = N;
    N = -1;
}

for (; i <= N; i++)
    Console.Write($"{Math.Pow(i, 3)} ");
// Задача 10: Напишите программу, которая принимает на вход трёхзначное число и на выходе показывает вторую цифру этого числа.
// 456 -> 5
// 782 -> 8 
// 918 -> 1

Console.Clear();

Console.WriteLine("Введите трехзначное число: ");
int num = Convert.ToInt32(Console.ReadLine());

if (num < 100 || num > 999)
{
    Console.WriteLine("Введено некорректное число");
    return;
}
num = (num % 100-num%10)/10;
Console.WriteLine($"Вторая цифра: {num}");
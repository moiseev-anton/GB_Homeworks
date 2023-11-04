// ЗАДАЧА 2: Напишите программу, которая на вход принимает 
// два числа и выдаёт, какое число большее, а какое меньшее.
// a = 5; b = 7 -> max = 7
// a = 2 b = 10 -> max = 10
// a = -9 b = -3 -> max = -3

Console.Clear();
Console.WriteLine("Введите два целых числа.");
Console.Write("Первое число: ");
int number1 = int.Parse(Console.ReadLine());
Console.Write("Второе число: ");
int number2 = int.Parse(Console.ReadLine());

if (number1 > number2)
    Console.WriteLine($"Max={number1} Min={number2}");
else
{
    if (number1 < number2)
        Console.WriteLine($"Max={number2} Min={number1}");
    else
        Console.WriteLine("Числа равны");
}
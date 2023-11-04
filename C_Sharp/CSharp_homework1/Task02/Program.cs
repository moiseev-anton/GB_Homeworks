// ЗАДАЧА 4: Напишите программу, которая принимает на вход три
// числа и выдаёт максимальное из этих чисел.
// 2, 3, 7 -> 7
// 44 5 78 -> 78
// 22 3 9 -> 22

Console.Clear();
Console.WriteLine("Введите три целых числа.");
Console.Write("Первое число: ");
int number1 = int.Parse(Console.ReadLine());
Console.Write("Второе число: ");
int number2 = int.Parse(Console.ReadLine());
Console.Write("Третье число: ");
int number3 = int.Parse(Console.ReadLine());

if (number1 > number2)                      
{
    if (number1 > number3)
        Console.WriteLine($"Max={number1}");
    else
        Console.WriteLine($"Max={number3}");
}   
else
{
    if (number2 > number3)
        Console.WriteLine($"Max={number2}");
    else
        Console.WriteLine($"Max={number3}");        
}
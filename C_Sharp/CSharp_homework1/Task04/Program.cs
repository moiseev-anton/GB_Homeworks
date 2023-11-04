// Задача 8: Напишите программу, которая на вход принимает число (N),
//  а на выходе показывает все чётные числа от 1 до N.
// 5 -> 2, 4
// 8 -> 2, 4, 6, 8

Console.Clear();
Console.Write("Введите натуральное число: ");
int number = int.Parse(Console.ReadLine());
int count = 1;
if (number < 1)
{
    Console.WriteLine("Введено неверное число");
    return;
}

while (count <= number)
{
    if (count % 2 == 0)
        Console.Write($"{count} ");
    count++;
}
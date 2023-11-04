// Задача 19: Напишите программу, которая принимает 
// на вход пятизначное число и проверяет, является ли 
// оно палиндромом.
// 14212 -> нет
// 23432 -> да
// 12821 -> да

Console.Clear();

Console.WriteLine("Введите пятизначное число: ");
string num = Convert.ToString(Console.ReadLine());

if (num.Length != 5)
{
    Console.WriteLine("Число НЕ пятизначное");
    return;
}

if (num[0] == num[4] && num[1] == num[3])
    Console.WriteLine("ДА, число палиндром");
else
    Console.WriteLine("НЕТ, число НЕ палиндром");


// // Математический способ решения
// Console.Clear();

// Console.WriteLine("Введите пятизначное число: ");
// int num = Convert.ToInt32(Console.ReadLine());

// if (num < 10000 || num > 99999)
// {
//     Console.WriteLine("Число НЕ пятизначное");
//     return;
// }

// int n1 = num / 10000;
// int n2 = (num / 1000) % 10;
// int n4 = (num % 100 - num % 10) / 10;
// int n5 = num % 10;

// if (n1 == n5 && n2 == n4)
//     Console.WriteLine("ДА, число палиндром");
// else
//     Console.WriteLine("НЕТ, число НЕ палиндром");


















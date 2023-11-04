// Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. 
// Напишите программу, которая покажет количество чётных чисел в массиве.
// [345, 897, 568, 234] -> 2

Console.Clear();
int[] array = GetArray(20, 100, 1000);                        // Задаём массив
Console.Write($"{String.Join(", ", array)}");    // Выводим массив в консоль
Console.WriteLine();
Console.Write($"Количество четных чисел = {PositivCount(array)}"); // Выводим результат


int[] GetArray(int size, int minVal, int maxVal)       // Метод задания массива случайных чисел.
{
    int[] arr = new int[size];

    for (int i = 0; i < size; i++)
        arr[i] = new Random().Next(minVal, maxVal);

    return arr;
}

int PositivCount(int[] arr)         // Метод подсчета чётных чисел массива
{
    int count = 0;

    foreach (int i in arr)          // Перебираем массив. Если элемент четный (без остатка делится на 2) -> счётчик + 1.
        if (i % 2 == 0)
            count++;
            
    return count;
}
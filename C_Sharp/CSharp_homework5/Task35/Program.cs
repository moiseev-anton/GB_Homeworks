// Задача 35: Задайте одномерный массив из 123 случайных чисел [0:1000]. Найдите количество элементов массива, значения которых лежат в отрезке [10,99]. 
// Пример для массива из 5, а не 123 элементов. В своём решении сделайте для 123
// [5, 18, 123, 6, 2] -> 1
// [1, 2, 3, 6, 2] -> 0
// [10, 11, 12, 13, 14] -> 5

Console.Clear();
int[] array = GetArray(123, 0, 1000);                // Задаем массив из 123 случайных чисел [0:1000)
Console.Write($"{String.Join(", ", array)}");        // Выводим массив в консоль
Console.WriteLine();
Console.Write($"Количество элементов лежащих в интервале [10,99] =  {CountInInterval(array, 10, 99)}");  // Находим количество значений [10,99] и выводим в консоль


int[] GetArray(int size, int minVal, int maxVal)                // Метод задания массива случайных чисел.
{
    int[] arr = new int[size];

    for (int i = 0; i < size; i++)
        arr[i] = new Random().Next(minVal, maxVal);

    return arr;
}

int CountInInterval(int[] arr, int minValue, int maxValue)     // Метод подсчета элементов
{
    int count = 0;
    
    foreach (int i in arr)                     // Перебираем все элементы массива
        if (i >= minValue && i <= maxValue)    // Условие: принаждежит ли элемент массива заданному интервалу
            count++;                           // Счетчик +1
            
    return count;                              // Возвращаем счетчик
}

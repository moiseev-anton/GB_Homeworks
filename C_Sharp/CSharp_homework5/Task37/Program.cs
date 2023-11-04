﻿// Задача 37: Найдите произведение пар чисел в одномерном массиве. 
// Парой считаем первый и последний элемент, второй и предпоследний и т.д.
// Результат запишите в новом массиве.
// [1 2 3 4 5] -> 5 8 3
// [6 7 3 6] -> 36 21

Console.Clear();
Console.WriteLine("Введите элементы массива через пробел");
string elements = Console.ReadLine()!;                        // Считываем строку из консоли 
int[] array = StringToArray(elements);                        // Переводим строку в массив целых чисел
int[] newArray = PairWiseMultiply(array);                     // Формируем новый массив попарно перемноженых элементов
Console.Write($"{String.Join(" ", newArray)}");               // Выводим новый массив



int[] StringToArray(string stringElements)                                          // Метод перевода строки в целочисленный массив
{
    string[] nums = stringElements.Split(" ", System.StringSplitOptions.RemoveEmptyEntries); // Делим строку в массив строк, задавая пробел как разделитель
    int[] result = new int[nums.Length];                                                     // Создаем новый пустой массив для целых чисел

    for (int i = 0; i < nums.Length; i++)                                                    // При помощи цикла for каждый элемента массива строк конвертируем в целое число
        result[i] = Convert.ToInt32(nums[i]);                                                //  и присваиваем получившееся значение каждому соответствующему элементу нового пустого массива

    return result;                                                                           // Возвращаем целочисленный массив 
}

int[] PairWiseMultiply(int[] arr)             // Метод попарного перемножения элементов массива                             
{
    int[] result;                                      // Массив, в который будем заносить результат.

    if (arr.Length % 2 == 0)                           // Если в исходном массиве количество элементов четное,
        result = new int[arr.Length / 2];              // то размер массива result задаём как половина размера исходного массива
    else
    {
        result = new int[arr.Length / 2 + 1];          //  а если НЕ четное, то размер массива result задаём как "половина+1".
        result[arr.Length / 2] = arr[arr.Length / 2];  // и можем сразу заполнить последний элемент нового массива. (средним элементом которому не нашлось пары)
    }

    for (int i = 0; i < arr.Length / 2; i++)           // Циклом for заполняем новый массив,
        result[i] = arr[i] * arr[arr.Length - 1 - i];  // попарно перемножая элементы исходного массива (первый и последний элемент, второй и предпоследний и т.д.)
    return result;                                     // Возвращаем получившийся массив
}
// Задача 41: Пользователь вводит с клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.

// 0, 7, 8, -2, -2 -> 2
// 1, -7, 567, 89, 223-> 3

Console.Clear();
Console.WriteLine("Введите числа через пробел");
string numsString = Console.ReadLine();
int[] array = StringToIntArray(numsString);
Console.Write(PositivCount(array));

int[] StringToIntArray(string stringValue)      // Метод перевода строки в целочисленный массив
{
    string[] stringArray = stringValue.Split(" ", System.StringSplitOptions.RemoveEmptyEntries);
    int[] result = new int[stringArray.Length];

    for (int i = 0; i < stringArray.Length; i++)
        result[i] = Convert.ToInt32(stringArray[i]);

    return result;
}

int PositivCount(int[] arr)         // Метод подсчёта положительных чисел в массиве
{
    int count = 0;
    foreach(int i in arr)
        count += i > 0 ? 1 : 0;
    return count;
}
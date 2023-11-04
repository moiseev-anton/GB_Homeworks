// Задача 38: Задайте массив вещественных чисел. 
// Найдите разницу между максимальным и минимальным элементов массива.
// [3 7 22 2 78] -> 76 

Console.Clear();
double[] array = GetArray(10, -10, 10);            // Задаём массив
OutPutArray(array);                                // Выводим массив в консоль при помощи метода
Console.WriteLine();
Console.Write($"Max - Min = {MinMaxDifference(array):f2}"); // Вычисляем и выводим результат


double[] GetArray(int size, double minVal, double maxVal)   // Метод задания массива случайных чисел.
{
    double[] arr = new double[size];
    for (int i = 0; i < size; i++)
        arr[i] = new Random().NextDouble() * (maxVal - minVal) + minVal;
    return arr;
}

double MinMaxDifference(double[] arr)     // Метод нахождения разницы между максимальным и минимальным элементами массива
{
    double min = arr[0];
    double max = arr[0];

    foreach (var i in arr)            // Перебираем массив и ищем минимальное и максимальное
    {
        min = i < min ? i : min;
        max = i > max ? i : max;
    }

    Console.WriteLine($"Min = {min:f2} Max = {max:f2}");   //необязателная стока (для наглядности)
    double dif = max - min;                                // Вычисляем разницу
    return dif;                                                //Возвращаем результат
}

void OutPutArray(double[] arr)    // Метод вывода элементов массива в консоль с двумя знаками после запятой
{
    foreach (var i in arr)
        Console.Write($"{i:f2} ");
}
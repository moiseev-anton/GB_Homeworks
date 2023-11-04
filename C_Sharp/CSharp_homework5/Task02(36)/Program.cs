// Задача 36: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.
// [3, 7, 23, 12] -> 19
// [-4, -6, 89, 6] -> 0

Console.Clear();
Console.Write("Введите количество элементов массива: ");
int num = Convert.ToInt32(Console.ReadLine());
int[] array = GetArray(num, 0, 10);               // Задаём массив
Console.Write($"{String.Join(", ", array)}");    // Выводим массив в консоль
Console.WriteLine();
Console.Write($"Cумма элементов на нечётных позициях = {UnevenSum(array)}"); // Подсчитываем сумму и выводим результат в консоль


int[] GetArray(int size, int minVal, int maxVal)    // Метод задания массива случайных чисел.
{
    int[] arr = new int[size];

    for (int i = 0; i < size; i++)
        arr[i] = new Random().Next(minVal, maxVal);

    return arr;
}

int UnevenSum(int[] arr)         // Метод подсчета суммы элементов на нечётных позициях
{
    int sum = 0;

    for (int i = 0; i < arr.Length; i += 2)          // Перебираем массив с шагом +2 и суммируем элементы 
        sum += arr[i];                              // Если я правильно понял, что нечетная позиция это 1-й элемент(индекс 0), 3-й элемент(индекс 2), ...

    return sum;
}
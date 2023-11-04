// Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + b1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.

// b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)

Console.Clear();
Console.WriteLine("Задайте первую прямую y = k1 * x + b1");
Console.Write("b1 = ");
double b1 = Convert.ToDouble(Console.ReadLine());
Console.Write("k1 = ");
double k1 = Convert.ToDouble(Console.ReadLine());
Console.WriteLine("Задайте вторую прямую y = k2 * x + b2");
Console.Write("b2 = ");
double b2 = Convert.ToDouble(Console.ReadLine());
Console.Write("k2 = ");
double k2 = Convert.ToDouble(Console.ReadLine());

Console.Write(CrossPoint(k1, k2, b1, b2));

string CrossPoint(double k1, double k2, double b1, double b2)
{
    string result = "";
    
    if (k1 == k2)
        return result = "Прямые не пересекаются";
    
    double x = (b2 - b1) / (k1 - k2);
    double y = k1 * x + b1;

    return result = $"({x}; {y})";
}
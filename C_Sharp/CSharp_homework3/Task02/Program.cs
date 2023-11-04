// Задача 21: Напишите программу, которая принимает 
// на вход координаты двух точек и находит расстояние между ними в 3D пространстве.

// A (3,6,8); B (2,1,-7), -> 15.84
// A (7,-5, 0); B (1,-1,9) -> 11.53

Console.Clear();

Console.WriteLine("Введите кординаты точки A");
Console.Write("x = ");
int xa = Convert.ToInt32(Console.ReadLine());
Console.Write("y = ");
int ya = Convert.ToInt32(Console.ReadLine());
Console.Write("z = ");
int za = Convert.ToInt32(Console.ReadLine());

Console.WriteLine("Введите кординаты точки B");
Console.Write("x = ");
int xb = Convert.ToInt32(Console.ReadLine());
Console.Write("y = ");
int yb = Convert.ToInt32(Console.ReadLine());
Console.Write("z = ");
int zb = Convert.ToInt32(Console.ReadLine());

double s = Math.Sqrt(Math.Pow((xb - xa), 2) + Math.Pow((yb - ya), 2) + Math.Pow((zb - za), 2));
Console.WriteLine($"A ({xa},{ya},{za});  B ({xb},{yb},{zb})  ->  {s:f2}");


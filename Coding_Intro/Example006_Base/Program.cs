int a = 1;
int b = 8;
int c = 16;
int d = 9;
int e = 6;

int max = a;

if (b > max) max = b;
if (c > max) max = c;
if (d > max) max = d;
if (e > max) max = e;

Console.Write("Max = ");
Console.WriteLine(max);
int count = 0;
int n = 2;
double time = 0;
double distance = 10000;
double speedF1 = 1;
double speedF2 = 2;
double speedDog = 5;

while (distance > 1)
{
    if (n > 1)
    {
        time = distance / (speedDog + speedF2);
        n = 1;
    }
    else
    {
        time = distance / (speedDog + speedF1);
        n = 2;
    }
    distance = distance - (speedF1 + speedF2) * time;
    count = count + 1;
}
Console.WriteLine("Собака пробежит " + count + " раз");
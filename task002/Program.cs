// Задача 2: Напишите программу, которая на вход принимает 
// два числа и выдаёт, какое число большее, а какое меньшее.

// a = 5; b = 7 -> max = 7
// a = 2 b = 10 -> max = 10
// a = -9 b = -3 -> max = -3

Console.WriteLine("Введите число a: ");
int numA = Convert.ToInt32(Console.ReadLine()); // Считываем число a

Console.WriteLine("Введите число b: ");

int numB = Convert.ToInt32(Console.ReadLine()); // Считываем число b
int max = 0; // переменная для хранения максимального значения

if (numA > numB) // сравниваем какое число больше
{
    max = numA; // Присваиваем значение максимуму
    Console.WriteLine($"Число a = {numA} больше числа b = {numB}"); // Выводим результат сравнения
    Console.WriteLine($"Max = {max}"); // Отдельно выводим максимальное число
}
else 
    if (numA < numB) 
{
    max = numB;
    Console.WriteLine("Число b больше числа a");
    Console.WriteLine($"Max = {max}");
}
    else // Отработка исключения когда два числа равны друг другу
    {
        Console.WriteLine("Число a равно числу b");
        
    }








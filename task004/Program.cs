// Задача 4: Напишите программу, которая принимает 
// на вход три числа и выдаёт максимальное из этих чисел.

// 2, 3, 7 -> 7
// 44 5 78 -> 78
// 22 3 9 -> 22

int[] numbers = new int[3]; //Задаем массив целых чисел
int max = numbers[0]; //Переменная для хранения максимума

Console.WriteLine("Введите 3 целых числа: ");

for (int index = 0; index < numbers.Length; index++) //Заполняем массив
{
    numbers[index] = Convert.ToInt32(Console.ReadLine());
  
    if(numbers[index] > max) // проверяем является ли введенное число максимальным
    {
        max = numbers[index];
    }
}

Console.WriteLine($"Максимальное число: {max}");



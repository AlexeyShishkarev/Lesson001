Console.Clear();

int ReadConsole(string message)
{
    Console.Write(message);
    int number = int.Parse(Console.ReadLine());
    return number;
}

#region input 
int length = ReadConsole("Введите длинну массива: ");
int min = ReadConsole("Введите min массива: ");
int max = ReadConsole("Введите max массива: ");
#endregion input

int[] FillArray(int length, int min, int max)
{
    int[] array = new int[length];
    Random rand = new();

    for (var i = 0; i < length; i++)
    {
        array[i] = rand.Next(min, max + 1);
    }
    return array;
}

void PrintArray(int[] array)
{
    Console.Write(string.Join(", ", array));
}

int[] array = FillArray(length, min, max);
PrintArray(array);
Console.WriteLine();

void Heapify (int[] array, int heapSize, int rootIndex){
    int largest = rootIndex;
    int leftChild = 2 * rootIndex + 1;
    int rightChild = 2 * rootIndex + 2;
    int temp;

    if (leftChild < heapSize && array[leftChild] > array[largest]){
        largest = leftChild;
    }

    if (rightChild < heapSize && array[rightChild] > array[largest]){
        largest = rightChild;
    }

    if (largest != rootIndex){
        temp = array[rootIndex];
        array[rootIndex] = array[largest];
        array[largest] = temp;

        Heapify(array, heapSize, largest);
    }

}

void Sort (int[] array){

    for (var i = array.Length / 2 - 1; i >= 0; i--)
    {
        Heapify(array, array.Length, i);
    }
    
    for (var i = array.Length - 1; i >= 0; i--)
    {
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;

        Heapify(array, i, 0);
    }

}



Sort(array);
PrintArray(array);
Console.WriteLine();




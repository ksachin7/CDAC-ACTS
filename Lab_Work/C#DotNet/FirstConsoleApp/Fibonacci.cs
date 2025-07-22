using System;

public class Fibonacci
{
    public static void CalculateFibonacci()
    {
        Console.WriteLine("Enter the number of terms in the Fibonnacci sequence:");
        int n = int.Parse(Console.ReadLine());
        int first = 0, second = 1, next;
        Console.WriteLine("Fibonacci Sequence!");
        for (int i = 0; i < n; i++)
        {
            Console.Write(first + " ");
            next = first + second;
            first = second;
            second = next;
        }
        Console.WriteLine();
    }
}
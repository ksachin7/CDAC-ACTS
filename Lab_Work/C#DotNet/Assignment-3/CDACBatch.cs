class CDACBatch
{
    double[] students;

    public void AcceptBatch(int batchNo = 1, int batchSize = 10)
    {
        Console.WriteLine("Number of students in the batch " + batchNo + ": " + batchSize);

        students = new double[batchSize];
        for (int i = 0; i < batchSize; i++)
        {
            Console.WriteLine("Enter the marks of student " + (i + 1));
            string input = Console.ReadLine();
            double marks;

            if (!double.TryParse(input, out marks) || marks < 0 || marks > 100)
            {
                Console.WriteLine("Invalid input. Please enter a valid mark between 0 and 100.");
                i--;
                continue;
            }

            students[i] = marks;
        }
    }

    public void DisplayBatch(int batchNo = 1)
    {
        Console.WriteLine("Batch " + batchNo + " marks:");
        foreach (var marks in students)
        {
            Console.Write(marks + " ");
        }
        Console.WriteLine();
    }
}
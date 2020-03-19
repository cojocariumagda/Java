package lab1;

public class compulsory {
    static String[] languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaSript", "PHP", "Swift", "Java"}; //2

    public static int sumOfDigits(int n)
    {
        int aux = n, sum = 0;
        while (aux != 0)
        {
            sum += aux%10;
            aux/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!"); //1

        int n = (int) (Math.random() * 1000000); //3

        n = n * 3;
        String numberStringToAdd = "10101";
        int numberToAdd = Integer.parseInt(numberStringToAdd, 2);
        n += numberToAdd;
        numberStringToAdd = "FF";
        numberToAdd = Integer.parseInt(numberStringToAdd, 16);
        n += numberToAdd;
        n *= 6; //4

        while (n > 9) //5
        {
            n = sumOfDigits(n);
        }

        /*solution 2 ex 5
        if (n == 0)
            n = 0;
        if (n % 9 == 0)
            n = 9;
        else
            n = sumOfDigits(n) % 9;
         */

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);



    }
}

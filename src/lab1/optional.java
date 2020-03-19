package lab1;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class optional {
    static int n, k, m;

    private static boolean isAlpha (String arg)
    {
        return arg.matches("[a-zA-Z]");
    }

    private static boolean isAdjacent (String str1, String str2)
    {
        boolean[] freqArray = new boolean[123];
        for (int i=0; i<str1.length(); i++)
        {
            freqArray[(int) str1.charAt(i)] = true;
        }

        for (int i = 0; i<str2.length(); i++)
        {
            if (freqArray[str2.charAt(i)])
                return true;
        }
        return false;
    }

    private static int sumOfNeighbors (boolean[][] mat, int index)
    {
        int sum = 0;
        for (int i=0; i<n; i++)
        {
            if (mat[index][i])
            {
                sum ++;
            }
        }
        return sum - 1 ;
    }

    //bonus
    private static void DFS (List<String> words, boolean[][]mat, boolean[] visited, int v)
    {
        visited[v] = true;
        System.out.print(words.get(v)+ " ");
        for (int i=0; i < n; i++)
        {
            if (mat[v][i] && !visited[i])
                DFS(words, mat, visited, i);
        }

    }

    private static void connectedComponents(List<String> words, boolean[][]mat)
    {
        boolean[] visited = new boolean[n];
        int nr = 1;
        for (int v = 0; v<n; v++)
        {
            if (!visited[v])
            {
                System.out.println();
                System.out.println("Componenta " + nr + ": ");
                nr++;
                DFS(words, mat, visited, v);
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        //initial time
        long startTime = System.nanoTime();

        // Validate the arguments
        String sn = args[0];
        if (!StringUtils.isNumeric(sn))
        {
            System.out.println("First argument is not integer");
            return;
        }
        n = Integer.parseInt(sn, 10);

        String sk = args[1];
        if (!StringUtils.isNumeric(sk))
        {
            System.out.println("Second argument is not integer");
            return;
        }

        k = Integer.parseInt(sk, 10);
        char[] chars = new char[args.length-2];
        List<String> words = new ArrayList<String>();
        m = 0;
        for(int i=2; i<args.length; i++)
        {
            if (!isAlpha(args[i]))
            {
                System.out.println(args[i] + " - paramatere no. " + i + " is not valid");
                return;
            }
            else
            {
                chars[m++] = args[i].charAt(0);
            }
        }

        System.out.println("All parameteres are valid");

        //create the array - words
        Random ran = new Random();

        for (int count=0; count<n; count++)
        {
            String currentWord = "";
            for (int ch=0; ch<k; ch++)
            {
                int randomChrIndex = ran.nextInt(m);
                currentWord += chars[randomChrIndex];
            }
            words.add(currentWord);
        }

        //display on the screen the generated array
        if ( n<= 100)
        {
            for (String s: words)
            {
                System.out.println(s);
            }
        }

        //n x n matrix
        boolean mat[][] = new boolean [n][n];
        int rowIndex = -1, columnIndex = -1;
        for(String row : words)
        {
            rowIndex++;
            for (String column : words)
            {
                columnIndex++;
                if (isAdjacent(row, column))
                    mat[rowIndex][columnIndex] = true;
            }
            columnIndex = -1;
        }

        if (n <= 10)
        {
            System.out.println();
            System.out.println("Matrix of adjacent words is: ");
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }

            int[] sumOnLine = new int [n];
            int max = 0, min = n;
            for (int index = 0; index < n; index++)
            {
                sumOnLine[index] = sumOfNeighbors(mat, index);
                if (sumOnLine[index] > max)
                    max = sumOnLine[index];
                if (sumOnLine[index] < min)
                    min = sumOnLine[index];
            }

            System.out.println();
            if (min == max)
            {
                System.out.println("All words have the same number of neighbors. Check here the words that have the most, respectively the least, number of neighbors");
                for (String s: words)
                {
                    System.out.println(s);
                }
            }
            else
            {
                System.out.println("Words that have the most number of neighbors: ");
                for (int index = 0; index < n; index++)
                {
                    if (sumOnLine[index] == max) {
                        System.out.println(words.get(index));
                    }
                }

                System.out.println();
                System.out.println("Words that have the least number of neighbors: ");
                for (int index = 0; index < n; index++)
                {
                    if (sumOnLine[index] == min) {
                        System.out.println(words.get(index));
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println();
        System.out.println("Timp de executie al aplicatiei " + totalTime + " in nanosecunde");
        System.out.println();

        System.out.println("Componentele conexe formate din cuvinte: ");
        connectedComponents(words, mat);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Koenkk
 */
public class TimeWaster
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String s = "typewriter";
        int runningTotal = 0;
        
        char input[] = s.toCharArray();
        char desired[] = "eeiprrttwy".toCharArray();
        
        for (int j = 0; j < 300; j++)
        {
            final long startTime = System.currentTimeMillis();

            for (int i = 0; i < Integer.MAX_VALUE; i++)
            {
                shuffle(input);

                if (Arrays.equals(desired, input))
                {
                    runningTotal += System.currentTimeMillis() - startTime;
                    break;
                }

                if (i == Integer.MAX_VALUE)
                {
                    i = 0;
                }
            }
        }
        
        System.out.println("Spent " + runningTotal + "ms for 300 tries. Average is: " + runningTotal / 300 + "ms");
    }
    
    private static Random rnd = new Random();
    
    public static void shuffle(char[] ar)
    {
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      char a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  
    }

    public static String shuffle(String input)
    {
        List<Character> characters = new ArrayList<Character>();
        for (char c : input.toCharArray())
        {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while (characters.size() != 0)
        {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }

        return output.toString();
    }

}

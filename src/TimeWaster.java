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
    private static int found = 0;

    private static boolean done = false;

    public static void main(String[] args) throws InterruptedException
    {

        final long startTime = System.currentTimeMillis();

        Runnable r = new Runnable()
        {

            @Override
            public void run()
            {

                String s = "typewriter";

                char desired[] = "eeiprrttwy".toCharArray();

                char[] input = s.toCharArray();
                Random rnd = new Random();

                for (int i = 0; i < Integer.MAX_VALUE; i++)
                {
                    shuffle(input, rnd);

                    if (Arrays.equals(desired, input))
                    {
                        found++;

                        if (found >= 300)
                        {
                            if (!done)
                            {
                                long timeSpent = System.currentTimeMillis() - startTime;
                                System.out.println("Spent " + timeSpent + "ms for " + found + " tries. Average is: " + timeSpent / found + "ms");
                                done = true;
                            }
                            break;
                        }
                    }

                    if (i == Integer.MAX_VALUE)
                    {
                        i = 0;
                    }
                }
            }
        };

        Thread threads[] = new Thread[8];

        for (int i = 0; i < 8; i++)
        {
            threads[i] = new Thread(r);
            threads[i].start();
        }

        while (!done)
        {
            Thread.sleep(1);

        }
    }

    public static void shuffle(char[] ar, Random random)
    {
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
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

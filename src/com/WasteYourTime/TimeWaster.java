/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.WasteYourTime;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koenkk
 */
public class TimeWaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "typewriter";
        final long startTime = System.currentTimeMillis();
        long attempts = 0;
        
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            s = shuffle(s);
            
            if (s.equals("eeiprrttwy")) {
                System.out.println(s);
                printWastedTime(startTime, attempts);
                break;
            }
            
            if (i == Integer.MAX_VALUE) {
                 i = 0;
                 printWastedTime(startTime, attempts);
                 System.out.println("Max integer reached!");
            }          
            
            attempts++;
        }
    }
    
    public static void printWastedTime(long beginTime, long attempts) {
        long wastedTime = System.currentTimeMillis() - beginTime;
        System.out.println("You wasted: " + wastedTime + " milliseconds (Attempts: " + attempts + ")");
    }
  
    
    public static String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        
        return output.toString();
    }
    
}

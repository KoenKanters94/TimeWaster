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
        
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            s = shuffle(s);
            
            if (s.equals("eeiprrttwy")) {
                System.out.println(s);
                printWastedTime(startTime);
                break;
            }
            
            if (i == Integer.MAX_VALUE) {
                 i = 0;
                 printWastedTime(startTime);
                 System.out.println("Max integer reached!");
            }            
        }
    }
    
    public static void printWastedTime(long beginTime) {
        long wastedTime = System.currentTimeMillis() - beginTime;
        System.out.println("You wasted: " + wastedTime + "milliseconds");
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

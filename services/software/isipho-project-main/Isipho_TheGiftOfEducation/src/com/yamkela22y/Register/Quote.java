//A list of jokes 
package com.yamkela22y.Register;

import java.util.Random;
import javax.swing.JLabel;

/**
 * @author yamkela
 * 
 */
public class Quote {

    //A list of Jokes 
    public static final String quotes[] = {
        "I know I did okay on today programming test.... \nWell ...because my teacher gave me C++",
        "I'm thinking about studying Programming next year. \nSo I can C# in 2023",
        "Unix is very user friendly... \nIt just very particular about who its friends are",
        "There is no place like 127.0.0.1",
        "Programmer While Coding:\nIt Doesn't Work.......  Why? \nIt Work......  Why?",
        "Why Programmers like dark mode? \nBecause light attracts bugs ",
        "Teacher: What is your level of programming? \nStudent: Low \nTeacher: Ok fine you can write programs in assembler then",
        "A programmer got stuck in the shower \nbecause the instructions given on the shampoo bottle said... \nLather, Rinse, Repeat.",
    };
    
    public static void getQuote(JLabel label) {
        Random random = new Random();
        label.setText(Quote.quotes[random.nextInt(Quote.quotes.length)]);
    }
    
    
    
}

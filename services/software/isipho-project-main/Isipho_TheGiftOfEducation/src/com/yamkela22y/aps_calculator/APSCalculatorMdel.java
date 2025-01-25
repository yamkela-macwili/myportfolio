/*
 * This class defines the model for the APS calculator.
 * It includes all the data members that are needed for the calculator.
 */
package com.yamkela22y.aps_calculator;

/**
 *
 * @author yamkela
 */
public class APSCalculatorMdel {
    
    private final int apsPoint;

    public APSCalculatorMdel() {
       apsPoint = 0;
    }

    public void setScore(int score) {
        if(score >=0 && score <=29){
            ApsCalulator.total += 1;
        }else if(score >29 && score <=39){
            ApsCalulator.total += 2;
        }else if(score >=39 && score <=49){
            ApsCalulator.total += 3;
        }else if(score >=49 && score <=59){
            ApsCalulator.total += 4;
        }else if(score >=59 && score <=69){
            ApsCalulator.total += 5;
        }else if(score >=69 && score <=79){
            ApsCalulator.total += 6;
        }else if(score >=79 && score <=100){
            ApsCalulator.total += 7;
        }
        ApsCalulator.count++;
    }   
    
}

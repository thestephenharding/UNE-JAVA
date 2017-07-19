
package averagerainfall;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageRainFall {
    
    static int monthsInYear = 12; //month declaration
    
    public static void main(String[] args) {
    
        List<Double> rainfallData = new ArrayList<>();
        int years;
        double monthRain;
        
        Scanner userInput = new Scanner (System.in);
        
        //Year input validation
        do {
            System.out.println("Enter a positive number of years: ");
            while(!userInput.hasNextInt()){
                System.out.println("Please enter a positive numerical value: ");
                userInput.next();
            }
            years = userInput.nextInt();            
        }            
        while (years <= 0);{
            System.out.println("Thank you! Confirming " + years + 
                    " years data will be captured \n");
        }
        
        //Rainfall input validation
        for (int y = 1; y <= years; y++){
            for (int m = 1; m <= monthsInYear; m++){            

                do {
                    System.out.println("Enter the rainfall, in centimetres, "
                            + "for each month.");
                    System.out.println("Year "+ y + ", month " + m + ":");
                    while(!userInput.hasNextDouble()){
                        System.out.println("Please enter a positive numerical value");
                        userInput.next();
                    }
                    monthRain = userInput.nextDouble();
                    if(monthRain < 0){
                        System.out.println("Invalid. Enter 0 or greater\n");
                    }
                    else{   
                    rainfallData.add(monthRain);
                    }
                }
                while (monthRain < 0);{
                }
                                    
            }
        }
        
        int totalMonths = years * monthsInYear;
       
        double totalRain = rainfallData.stream().mapToDouble(f -> f).sum();
        double rainAverage = totalRain / rainfallData.size();
        
        System.out.println("\nNumber of months data collected: " + totalMonths + " Months");
        System.out.println("The calculated total rainfall for " + totalMonths + " is: "
                + totalRain);
        System.out.println("The calculated average rainfall for " + years + " years"
                + " is: " + rainAverage);
    }
        
        
}
package project_4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ratingCalculator3 {

    /*MY APPROACH (For Rating from 1 to 5): The Approch is to give all Non-Respondents the rating 
                        of 4, since Most of the Angry and Very Happy customers will Definitely
                        Response, But Averagely satisfied Customers Don't feel to Respond.*/


    public static void main(String[] args) {
        //Sales=total Number of Sales
        //Responses=total Number of Responses From Verified Buyers
        //score= ((4*(Sales-Responses)) + Sum of all Customer Effort Score(from 1 to 5))/Sales

        float sum = 0, sales, ratings[] = new float[5], score = 0 ,final_score;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n\nPlease Enter Total Number of Sales : ");
            sales=scan.nextFloat();

            if(sales!=(int)sales ||sales<0) 
                System.out.println("\n\nPlease Enter a  Positive Integer");

        }while(sales!=(int)sales || sales < 0);

        do{
            sum=0;
            for (int i = 0; i < 5; i++) {
                do {
                    System.out.println("\n\nPlease Enter the Number of Feedbacks with rating " + (i + 1));
                    ratings[i] = scan.nextFloat();

                    if (ratings[i] != (int) ratings[i] || ratings[i]<0)
                        System.out.println("\n\nPlease Enter a Positive Integer");

                } while (ratings[i] != (int) ratings[i] || ratings[i] < 0);

                sum += ratings[i];
                if(sum>sales){
                    System.out.println("\n\nNumber of Feedbacks cannot Exceed Number of Total Sales\n\nTry Again!!!!.");
                    break;
                }

            }

        }while(sum>sales);

        for (int j = 0; j < 5; j++)
            score += ratings[j] * (j + 1); // Adding up all ratings


        final_score=(4*(sales-sum)+score)/sales;
        DecimalFormat n = new DecimalFormat("#.00");
        System.out.println("\n\nThe Score Using This Approach is   "+n.format(final_score));


        scan.close();
    
    }
}
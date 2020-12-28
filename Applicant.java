
import java.io.*;
import java.util.*;
/**
 * Write a description of class Applicant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Applicant
{
    private final double averageAdjust = 16.1;
    private final String[] programGroups = {"Biomedical and Software", "Computer, Electrical, Mechanical, Mechatronics, and Systems Design", "Architectural, Chemical, Civil, Environmental, Geological, Management, and Nanotechnology"};

    private int programGroup;
    private double average;
    private double adjustedAverage;
    private double realAdjustedAverage;
    private double adjustmentFactor;
    private double aifScore;
    private double interviewScore;
    private double chance;

    public Applicant()
    {
        programGroup = -1;
        average = -1;
        adjustedAverage = -1;
        adjustmentFactor = 16.1;
        aifScore = -1;
        interviewScore = -1;
        chance = -1;
    }

    public void testApplicant()
    {
        programGroup = 2;
        average = 94.5;
        adjustedAverage = -1;
        adjustmentFactor = 16.1;
        aifScore = 3;
        interviewScore = 2;
        chance = 0;
    }

    public void setAverage (double average)
    {
        this.average = average;
    }

    public void setAdjustmentFactor (double adjustmentFactor)
    {
        this.adjustmentFactor = adjustmentFactor;
    }

    public void setProgramGroup (int programGroup)
    {
        this.programGroup = programGroup;
    }

    public void setAIFScore (double aifScore)
    {
        this.aifScore = aifScore;
    }

    public void setInterviewScore (double interviewScore)
    {
        this.interviewScore = interviewScore;
    }

    public double returnAdjustedAverage()
    {
        System.out.println("Your Adjusted Admission Average is: " + adjustedAverage);
        return adjustedAverage;
    }

    public double returnRealAdjustedAverage()
    {
        System.out.println("Your Adjusted Admission Average including AIF and Interview is: " + realAdjustedAverage);
        return realAdjustedAverage;
    }

    public double returnChance()
    {
        System.out.println("Your Chance of Admission* is: " + chance + "%");
        return chance;
    }

    public String returnPrograms()
    {
        System.out.println("Your selected program group: " + programGroups[programGroup-1]);
        return programGroups[programGroup-1];
    }

    public void calculateChance()
    {
        adjustedAverage = average - adjustmentFactor + averageAdjust;
        adjustedAverage = round(adjustedAverage);
        double x = adjustedAverage + aifScore - 2;
        x = x + interviewScore - 2;
        x = round(x);
        if(x > 100) {
            x = 100;
        }
        else if (x < 80) {
            x = 80; 
        }
        realAdjustedAverage = x;
        switch(programGroup)
        {
            case 1:
            chance = -0.000000991665*Math.pow(x,6)+0.000712766582*Math.pow(x,5)-0.199337541744*Math.pow(x,4)+28.477751641706*Math.pow(x,3)-2221.069055798020*Math.pow(x,2)+90365.708229188000*x-1505792.893230060000;
            break;
            
            case 2:
            chance = 0.000007927378*Math.pow(x,6)-0.003815953092*Math.pow(x,5)+0.753733211049*Math.pow(x,4)-77.9121684881*Math.pow(x,3)+4421.4707888*Math.pow(x,2)-129515.4702471*x +1507941.8835368;
            break;
            
            case 3:
            chance = 0.0005942718*Math.pow(x,4) - 0.2085009655*Math.pow(x,3) + 27.0594414776*Math.pow(x,2) - 1532.9010505906*x + 31865.616776;
            break;
            
            default:
            break;
        }

        chance = round(chance);
    }

    public double round(double num)
    {
        double chance = num;
        chance = chance * 10;
        chance = Math.round(chance);
        chance = chance/10;
        return chance;
    }

    public static void main(String[] args) 
    {
        Applicant a = new Applicant();
        a.testApplicant();
        a.calculateChance();
        a.returnPrograms();
        a.returnAdjustedAverage();
        a.returnRealAdjustedAverage();
        a.returnChance();
    }
}

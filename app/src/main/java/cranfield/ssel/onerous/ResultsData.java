package cranfield.ssel.onerous;

import java.lang.reflect.Array;

/**
 * Created by diwash on 24/10/2016.
 */
public class ResultsData {
    private double lastTime;
    private double[] numbers = new double[30];
    private double[] cumulative = new double[30];
    private double mean;

    ResultsData()
    {
        lastTime = 0;
        for (int i =0; i<30; i++)
        {
            numbers[i]=0;
            cumulative[i]=0;
        }
        mean=0;
    }

    public void setLastTime (double lt) {lastTime = lt;}
    public void setMean (double m) {mean = m;}
    public void setNumbers (int i, double n) {numbers[i] = n;}
    public void setCumulative (int i, double c) {cumulative[i] = c;}

    public double getLastTime() {return lastTime;}
    public double getMean() {return mean;}
    public double getNumber (int i) {return numbers[i];}
    public double getCumulative (int i) {return cumulative[i];}
}

package cranfield.ssel.onerous;

/**
 * Created by diwash on 25/10/2016.
 */
public class ActivityDistribution {
    private int type;
    private double parameter1;
    private double parameter2;
    private double parameter3;
    private double parameter4;

    ActivityDistribution( int t, double p1, double p2, double p3, double p4)
    {
        type = t;
        parameter1 = p1;
        parameter2 = p2;
        parameter3 = p3;
        parameter4 = p4;
    }

    ActivityDistribution ()
    {

    }

    public int getType () {return type;}
    public double getParameter1 () {return parameter1;}
    public double getParameter2 () {return parameter2;}
    public double getParameter3 () {return parameter3;}
    public double getParameter4 () {return parameter4;}

    public void setType(int t){type = t;}
    public void setParameter1(double p1) {parameter1 = p1;}
    public void setParameter2(double p2) {parameter2 = p2;}
    public void setParameter3(double p3) {parameter3 = p3;}
    public void setParameter4(double p4) {parameter4 = p4;}
}

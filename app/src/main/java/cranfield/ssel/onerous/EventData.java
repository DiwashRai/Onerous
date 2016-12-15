package cranfield.ssel.onerous;

/**
 * Created by diwash on 20/10/2016.
 */
public class EventData {
    private double time;
    private int kind;

    EventData(double t, int k){time = t;kind = k;}

    EventData(){}

    @Override
    public String toString() {
        return "\n"+Double.toString(time) +", "+ Integer.toString(kind);
    }

    public double getTime() {return time;}

    public void setTime (double t)
    {
        time = t;
    }

    public void set (double t, int k){time = t;kind = k;}

    public int getKind () {return kind;}

    public void setKind (int k) {kind = k;}
}


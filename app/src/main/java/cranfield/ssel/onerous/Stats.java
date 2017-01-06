package cranfield.ssel.onerous;

import com.github.mikephil.charting.data.Entry;

import java.util.Random;

/**
 * Created by diwash on 21/10/2016.
 */
public class Stats {

    public double getDuration (ActivityDistribution sample)
    {
        Random r = new Random();
        double d = 0.0;

        switch (sample.getType()) {
            // Normally distributed value
            case 1: {
                for (boolean repeat = true; repeat==true;) {
                    // This is the original implementation of Onerous's normal distrubtion function. New value generated until it is within min and max
                    // With permission will change to something that is more accurately simulates real life i.e. values less than 0 will be set to 0 as engines can't breakdown before using.
                    // Values greater than max (25) will be set to max (25) as standard operating procedure is that engines have to be repaired every max (25) days. Generating new value would
                    // mean an engine that lasts over 25 days could be rerolled and set to a smaller value. This causes simulation to underestimate average engine life.
                    d = (r.nextGaussian() * sample.getParameter2() + sample.getParameter1());
                    if ((Double.compare(d,sample.getParameter3()) > 0) && (Double.compare(d,sample.getParameter4()) < 0)) repeat = false;
                }
                break;
            }
            // Uniformally distributed value
            case 2: {
                d = sample.getParameter1()+ ((sample.getParameter2()-sample.getParameter1())*r.nextDouble());
                break;
            }
            //Constant value
            case 3: {
                d = sample.getParameter1();
                break;
            }
            // Negative exponential
            case 4: {
                // unused code block?
                break;
            }
            default: {
                System.out.println("distrubtion type not found");
                break;
            }
        }
        return d;
    }

    public void updateStats (ResultsData info, int num)
    {
        if (info.getLastTime() < Variables.warmUp) info.setLastTime(Variables.warmUp);

        if (num > 30 || num < 0)
        {
            System.out.println("Update stats: Num out of range. Num = " + num);
        }
        else if (Variables.SimTime > info.getLastTime()){
            info.setNumbers(num, info.getNumber(num) + (Variables.SimTime - info.getLastTime()));
            info.setLastTime(Variables.SimTime);
        }

        if (Variables.endFlag) endStats(info);
    }

    public void endStats (ResultsData info)
    {
        int i;
        double total = 0;
        info.setMean(0.0);

        for (i = 0; i < 30; i++)
        {
            total = total + info.getNumber(i);
            info.setMean(info.getMean() + (info.getNumber(i) * i));
        }

        if (total > 0)
        {
            info.setMean(info.getMean()/total);
            for (i = 0;i < 30; i++) info.setNumbers(i, info.getNumber(i)*100/total);
        }

        info.setCumulative(29, info.getNumber(29));
        for (i = 28; i>-1; i--) info.setCumulative(i, info.getNumber(i)+ info.getCumulative(i+1));
    }

    public void setupMSRDworkingStats ()
    {
        //Section that adds converts MSRDidle stats to MSRDworking stats
        for (int i = 0; i <= Variables.MSRD; i++)
        {
            Variables.MSRDWorkingStats.setNumbers(i, Variables.MSRDIdleStats.getNumber(Variables.MSRD-i));
        }
        Variables.MSRDWorkingStats.setCumulative(29, Variables.MSRDWorkingStats.getNumber(29));
        for (int i = 28; i>-1; i--)
            Variables.MSRDWorkingStats.setCumulative(i, Variables.MSRDWorkingStats.getNumber(i)+ Variables.MSRDWorkingStats.getCumulative(i+1));

        if (Variables.MSRDIdleStats.getMean() > 0){
            Variables.MSRDWorkingStats.setMean(Variables.MSRD - Variables.MSRDIdleStats.getMean());
        }else{
            Variables.MSRDWorkingStats.setMean(0);
        }

        //Section that adds converts MSRDidle graph data to MSRDworking graph data
        for (int i = 0; i < 4000; ++i) {
            if ((Variables.msrdIdleQGraphData[i][0] != 0) || (Variables.msrdIdleQGraphData[i][1] != 0)) {
                Variables.msrdWorkingGraphData[i][0] = Variables.msrdIdleQGraphData[i][0];
                Variables.msrdWorkingGraphData[i][1] = Variables.MSRD - Variables.msrdIdleQGraphData[i][1];
            }
        }
    }

    public void finalStats ()
    {
        updateStats(Variables.operationalStats, Variables.numOperational );
        updateStats(Variables.qforRemovalStats, Variables.numQforRemoval);
        updateStats(Variables.removalStats, Variables.numRemoval);
        updateStats(Variables.qHelisNoEngineStats, Variables.numQHelisNoEngine);
        updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
        updateStats(Variables.qforToWorkshopStats, Variables.numQforToWorkshop);
        updateStats(Variables.toWorkshopStats, Variables.numToWorkshop);
        updateStats(Variables.qforRepairStats, Variables.numQforRepair);
        updateStats(Variables.repairStats, Variables.numRepair);
        updateStats(Variables.repairTeamsIdleStats, Variables.numRepairTeamsIdle);
        updateStats(Variables.qforToOperationStats, Variables.numQforToOperation);
        updateStats(Variables.toOperationStats, Variables.numToOperation);
        updateStats(Variables.qforRefitStats, Variables.numQforRefit);
        updateStats(Variables.refitStats, Variables.numRefit);
        updateStats(Variables.qforOperationalStats, Variables.numQforOperational);
        setupMSRDworkingStats();
    }
}

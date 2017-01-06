package cranfield.ssel.onerous;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 * Created by diwash on 01/11/2016.
 */

public class SimMethods {
    Stats stats = new Stats();
    View view;
    Handler handler;

    public SimMethods (View v, Handler h){view = v; handler = h;}

    public void runSim(){
        Events Events = new Events(view, handler);

        initVariables();
        initDataVariables();
        resetAllStats();
        resetAllGraphData();

        Variables.SimTime = 0.0;
        Variables.endFlag = false;

        final TextView days = (TextView)view.findViewById(R.id.daysValue);
        handler.post(new Runnable() {
            @Override
            public void run() {
                days.setText(Double.toString(Math.round(Variables.SimTime*100.0)/100.0));
            }
        });

        initList();
        printList(); //prints list of events in schedule to console. Just a tool for dev to monitor execution

        for (Variables.endFlag = false; Variables.endFlag == false;)
        {
            getEvent();
            if (Variables.SimTime > Variables.RunTime)
            {
                System.out.print("Terminate");
                Variables.endFlag = true;
                break;
            }
            else
            {
                switch (Variables.newEvent.getKind()){
                    case 1: Events.engineFails();
                            break;
                    case 2: Events.endRemoval();
                            break;
                    case 3: Events.endToWorkshop();
                            break;
                    case 4: Events.endRefit();
                            break;
                    case 5: Events.endRepair();
                            break;
                    case 6: Events.endToOperation();
                            break;
                    case 7: System.out.println("Got here case");
                            break;
                    default: System.out.println("Event kind not understood");
                            break;
                }//End of event cases
            }//end of if
            if (Variables.graphicsOn)
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        days.setText(Double.toString(Math.round(Variables.SimTime*100.0)/100.0));
                    }
                });
            }
        }

        Variables.SimTime = Variables.RunTime;
        handler.post(new Runnable() {
            @Override
            public void run() {
                days.setText(Double.toString(Variables.SimTime));
                Button runsimbtn = (Button) view.findViewById(R.id.runSimButton);
                runsimbtn.setClickable(true);
            }
        });

        stats.finalStats();
    }

    public void initVariables ()
    {
        if (Variables.helicopters <= Variables.maxHelicopters)
        {
            Variables.numOperational  = Variables.helicopters;
            Variables.numQforOperational = 0;
        }
        else
        {
            Variables.numOperational = Variables.maxHelicopters;
            Variables.numQforOperational = Variables.helicopters - Variables.maxHelicopters;
        }

        Variables.numQforRemoval = 0;
        Variables.numRemoval = 0;
        Variables.numQHelisNoEngine = 0;
        Variables.numMSRDIdle = Variables.MSRD;
        Variables.numQforToWorkshop = 0;
        Variables.numToWorkshop = 0;
        Variables.numQforRepair = 0;
        Variables.numRepair = 0;
        Variables.numRepairTeamsIdle = Variables.repairTeams;
        Variables.numQforToOperation = 0;
        Variables.numToOperation = 0;
        Variables.numQforRefit = Variables.spareEngines;
        Variables.numRefit = 0;
    }

    public void initList ()
    {
        // This is where the list of events is initialised. Based on number of helicopters, the breakdown events for all of their
        // engines is scheduled and added to the list
        Variables.list.clear();
        Stats stats = new Stats();
        for (int i = 0; i<Variables.numOperational;i++)
        {
            Variables.newEvent = (new EventData (stats.getDuration(Variables.operationalTime),1));  //Integer value here denotes "kind" of event. (1 here = engine failure event)
            addEvent(Variables.list, Variables.newEvent);
        }
    }

    public void initDataVariables()
    {
        Variables.operationalTime.setType(1);
        Variables.operationalTime.setParameter1(15);
        Variables.operationalTime.setParameter2(3.9);
        Variables.operationalTime.setParameter3(0);
        Variables.operationalTime.setParameter4(25);

        Variables.removalTime.setType(3);
        Variables.removalTime.setParameter1(0.5);
        Variables.removalTime.setParameter2(0);
        Variables.removalTime.setParameter3(0);
        Variables.removalTime.setParameter4(0);

        Variables.toWorkshopTime.setType(3);
        Variables.toWorkshopTime.setParameter1(0.5);
        Variables.toWorkshopTime.setParameter2(0);
        Variables.toWorkshopTime.setParameter3(0);
        Variables.toWorkshopTime.setParameter4(0);

        Variables.repairTime.setType(2);
        Variables.repairTime.setParameter1(1);
        Variables.repairTime.setParameter2(8);
        Variables.repairTime.setParameter3(0);
        Variables.repairTime.setParameter4(0);

        Variables.toOperationTime.setType(3);
        Variables.toOperationTime.setParameter1(0.5);
        Variables.toOperationTime.setParameter2(0);
        Variables.toOperationTime.setParameter3(0);
        Variables.toOperationTime.setParameter4(0);

        Variables.refitTime.setType(3);
        Variables.refitTime.setParameter1(0.5);
        Variables.refitTime.setParameter2(0);
        Variables.refitTime.setParameter3(0);
        Variables.refitTime.setParameter4(0);
    }

    public void resetStats (ResultsData info)
    {
        Variables.opheliGraphPointNum =0;
        info.setLastTime(0.0);
        info.setMean(0.0);
        for (int i =0; i<30; i++)
        {
            info.setNumbers(i, 0.0);
            info.setCumulative(i, 0.0);
        }
    }

    public void resetAllStats () {
        resetStats(Variables.operationalStats);

        resetStats(Variables.qforRemovalStats);
        resetStats(Variables.removalStats);
        resetStats(Variables.qHelisNoEngineStats);
        resetStats(Variables.MSRDIdleStats);
        resetStats(Variables.qforToWorkshopStats);
        resetStats(Variables.toWorkshopStats);
        resetStats(Variables.qforRepairStats);
        resetStats(Variables.repairStats);
        resetStats(Variables.repairTeamsIdleStats);
        resetStats(Variables.qforToOperationStats);
        resetStats(Variables.toOperationStats);
        resetStats(Variables.qforRefitStats);
        resetStats(Variables.refitStats);
        resetStats(Variables.qforOperationalStats);

        resetStats(Variables.MSRDWorkingStats);
    }

    public void resetAllGraphData()
    {
        resetGraphData(Variables.opHeliGraphData);
        resetGraphData(Variables.msrdWorkingGraphData);
        resetGraphData(Variables.failedQGraphData);
        resetGraphData(Variables.removeEngGraphData);
        resetGraphData(Variables.toRepairGraphData);
        resetGraphData(Variables.badEngQGraphData);
        resetGraphData(Variables.engRepairGraphData);
        resetGraphData(Variables.toOperationGraphData);
        resetGraphData(Variables.goodEngQGraphData);
        resetGraphData(Variables.refitEngGraphData);
        resetGraphData(Variables.qForOpGraphData);
        resetGraphData(Variables.heliAwaitEngGraphData);
        resetGraphData(Variables.msrdIdleQGraphData);
        resetGraphData(Variables.repairTeamIdleGraphData);
    }

    public void resetGraphData(double [][] graphData){
        for (int i=0; i<Variables.maxGraphPoints; ++i){
            graphData[i][0] = 0;
            graphData[i][1] = 0;
        }
    }

    public void getEvent ()
    {
        if (!Variables.list.isEmpty())
        {
            Variables.newEvent = Variables.list.get(0);
            Variables.SimTime = Variables.newEvent.getTime();
            Variables.list.remove(0);
        }
        else
        {
            Variables.endFlag = true;
            System.out.println("ArrayList of events is empty");
        }
    }

    public void printList()
    {
        System.out.println("EVENT LIST");
        for (int i = 0; i < Variables.list.size(); i++)
        {
            BigDecimal bd = new BigDecimal(Variables.list.get(i).getTime());
            bd = bd.round(new MathContext(16));
            System.out.print("[" + bd +  " , " + Variables.list.get(i).getKind() + "]");
            System.out.println();
        }
        System.out.println();
    }

    // Custom print functions to monitor simulation in console. Not necessary for final application

    public void printEvent(EventData e)
    {
        BigDecimal bd = new BigDecimal(e.getTime());
        bd = bd.round(new MathContext(16));
        System.out.println("[" + bd + ", " + e.getKind() + "]");
    }

    public void printResultsData (ResultsData r)
    {
        System.out.println("----------");
        System.out.println("RESULTS");
        System.out.println("----------");
        System.out.println("Mean = " + r.getMean());
        System.out.println("|NUMBER OF N          |            % TIME N AVAILABLE      |            % TIME N OR MORE AVAILABLE|");
        for (int i = 28; i > -1; i--)
        {
            if (r.getCumulative(i) > 0)
            {
                System.out.println(i + "                     "+r.getNumber(i)+"                                     "+ r.getCumulative(i));
            }
        }
    }

    static public void addEvent (ArrayList<EventData> l, EventData n) {

        // this function adds new events to the list of events scheduled. It places the events in order as the come so sorting is never required.
        // next closest event is at the top and furthest event away is bottom.
        if (l.size() == 0) l.add(n);
        else {
            for (int i = 0; i < l.size(); i++) {
                if (n.getTime() <= l.get(i).getTime()) {
                    l.add(i, n);
                    break;
                }
                if ((n.getTime() > l.get(i).getTime()) && (i == (l.size() - 1))) {
                    l.add(n);
                    break;
                }
            }
        }
    }
}

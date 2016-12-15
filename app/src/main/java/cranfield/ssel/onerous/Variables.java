package cranfield.ssel.onerous;

import java.util.ArrayList;

/**
 * Created by diwash on 21/10/2016.
 */
public class Variables {

    // This class contains all the variables that need to be accessed by the various different parts of the application.

    static double SimTime;
    static boolean endFlag = false;
    static EventData newEvent = new EventData();
    static double RunTime = 250.0;
    static ArrayList<EventData> list = new ArrayList();

    static int warmUp = 25;
    static int helicopters = 10;
    static int maxHelicopters = 10;
    static int spareEngines = 1;
    static int MSRD = 1;
    static int repairTeams = 1;

    static boolean graphicsOn = true;
    static boolean animationsOn = true;
    static boolean stopNow = false;

    static int numOperational = 0;
    static int numQforRemoval = 0;
    static int numRemoval = 0;
    static int numMSRDIdle = 0;
    static int numQHelisNoEngine = 0;
    static int numQforToWorkshop = 0;
    static int numToWorkshop  =0;
    static int numQforRepair = 0;
    static int numQforRefit = 0;
    static int numRefit = 0;
    static int numQforOperational = 0;
    static int numRepairTeamsIdle = 0;
    static int numRepair = 0;
    static int numQforToOperation = 0;
    static int numToOperation = 0;

    static ActivityDistribution operationalTime = new ActivityDistribution();
    static ActivityDistribution removalTime = new ActivityDistribution();
    static ActivityDistribution toWorkshopTime = new ActivityDistribution();
    static ActivityDistribution repairTime = new ActivityDistribution();
    static ActivityDistribution toOperationTime = new ActivityDistribution();
    static ActivityDistribution refitTime = new ActivityDistribution();

    static ResultsData operationalStats = new ResultsData();

    static ResultsData qforRemovalStats = new ResultsData();
    static ResultsData removalStats = new ResultsData();
    static ResultsData qHelisNoEngineStats = new ResultsData();
    static ResultsData MSRDIdleStats = new ResultsData();
    static ResultsData qforToWorkshopStats = new ResultsData();
    static ResultsData toWorkshopStats = new ResultsData();
    static ResultsData qforRepairStats = new ResultsData();
    static ResultsData repairStats = new ResultsData();
    static ResultsData repairTeamsIdleStats = new ResultsData();
    static ResultsData qforToOperationStats = new ResultsData();
    static ResultsData toOperationStats = new ResultsData();
    static ResultsData qforRefitStats = new ResultsData();
    static ResultsData refitStats = new ResultsData();
    static ResultsData qforOperationalStats = new ResultsData();

    static ResultsData MSRDWorkingStats = new ResultsData();
}

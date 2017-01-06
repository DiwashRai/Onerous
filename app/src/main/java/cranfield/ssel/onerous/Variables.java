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

    static final int maxGraphPoints = 4000;

    //Section that initialises the 2D arrays that hold the coordinates to output as graphs

    static double [][] opHeliGraphData = new double [maxGraphPoints][2];
    static double [][] msrdWorkingGraphData = new double [maxGraphPoints][2];
    static double [][] failedQGraphData = new double [maxGraphPoints][2];
    static double [][] removeEngGraphData = new double [maxGraphPoints][2];
    static double [][] toRepairGraphData = new double [maxGraphPoints][2];
    static double [][] badEngQGraphData = new double [maxGraphPoints][2];
    static double [][] engRepairGraphData = new double [maxGraphPoints][2];
    static double [][] toOperationGraphData = new double [maxGraphPoints][2];
    static double [][] goodEngQGraphData = new double [maxGraphPoints][2];
    static double [][] refitEngGraphData = new double [maxGraphPoints][2];
    static double [][] qForOpGraphData = new double [maxGraphPoints][2];
    static double [][] heliAwaitEngGraphData = new double [maxGraphPoints][2];
    static double [][] msrdIdleQGraphData = new double [maxGraphPoints][2];
    static double [][] repairTeamIdleGraphData = new double [maxGraphPoints][2];

    //Initialise integer objects that count which

    static int opheliGraphPointNum = 0;
    //msrdWorkingGraphPointNum would go here but is irrelevant.the Graph data is generated using msrdIdleGraphData
    static int failedQGraphPointNum = 0;
    static int removeEngGraphPointNum = 0;
    static int toRepairGraphPointNum = 0;
    static int badEngQGraphPointNum = 0;
    static int engRepairGraphPointNum = 0;
    static int toOperationGraphPointNum = 0;
    static int goodEngQGraphPointNum = 0;
    static int refitEngGraphPointNum = 0;
    static int qForOpGraphPointNum = 0;
    static int heliAwaitEngGraphPointNum = 0;
    static int msrdIdleQGraphPointNum = 0;
    static int repairTeamIdleGraphPointNum = 0;
}

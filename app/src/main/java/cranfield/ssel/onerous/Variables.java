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

    static ActivityDistribution operationalTime = new ActivityDistribution(1,15,3.9,0,25);
    static ActivityDistribution removalTime = new ActivityDistribution(3,0.5,0,0,0);
    static ActivityDistribution toWorkshopTime = new ActivityDistribution(3,0.6,0,0,0);
    static ActivityDistribution repairTime = new ActivityDistribution(2,1,8,0,0);
    static ActivityDistribution toOperationTime = new ActivityDistribution(3,0.5,0,0,0);
    static ActivityDistribution refitTime = new ActivityDistribution(3,0.5,0,0,0);

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

    // GraphArrayLength has to be limited to stop app from using too much memory
    static final int maxGraphPoints = 4000;

    //Section that initialises the 2D arrays that hold the coordinates to output as graphs

    static float [][] opHeliGraphData = new float [maxGraphPoints][2];
    static float [][] msrdWorkingGraphData = new float [maxGraphPoints][2];
    static float [][] failedQGraphData = new float [maxGraphPoints][2];
    static float [][] removeEngGraphData = new float [maxGraphPoints][2];
    static float [][] toRepairGraphData = new float [maxGraphPoints][2];
    static float [][] badEngQGraphData = new float [maxGraphPoints][2];
    static float [][] engRepairGraphData = new float [maxGraphPoints][2];
    static float [][] toOperationGraphData = new float [maxGraphPoints][2];
    static float [][] goodEngQGraphData = new float [maxGraphPoints][2];
    static float [][] refitEngGraphData = new float [maxGraphPoints][2];
    static float [][] qForOpGraphData = new float [maxGraphPoints][2];
    static float [][] heliAwaitEngGraphData = new float [maxGraphPoints][2];
    static float [][] msrdIdleQGraphData = new float [maxGraphPoints][2];
    static float [][] repairTeamIdleGraphData = new float [maxGraphPoints][2];

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

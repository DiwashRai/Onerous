package cranfield.ssel.onerous;


import android.os.Handler;
import android.view.View;

/**
 * Created by diwash on 20/10/2016.
 */
public class Events {
    Stats stats = new Stats();

    View view;
    Handler handler;
    SimMethods sim = new SimMethods(view, handler);

    SimGraphics graphics = new SimGraphics(view);
    SimAnimations anims = new SimAnimations(view);

    public Events (View v, Handler h) {view = v; handler = h; graphics.setView(view); anims.setView(view);}

    public void engineFails ()
    {
        stats.updateStats(Variables.operationalStats, Variables.numOperational );
        doGraphic("Operational",Variables.numOperational,false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveOpToFailed();
                }
            });
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        Variables.numOperational = Variables.numOperational - 1;

        stats.updateStats(Variables.qforRemovalStats, Variables.numQforRemoval);
        doGraphic("Failed",Variables.numQforRemoval,true);
        Variables.numQforRemoval = Variables.numQforRemoval + 1;

        startOperational();
        startRemoval();
    }

    public void startRemoval ()
    {
        double t;
        EventData N = new EventData();

        if ((Variables.numQforRemoval > 0) && (Variables.numMSRDIdle > 0))
        {
            stats.updateStats(Variables.qforRemovalStats, Variables.numQforRemoval);
            doGraphic("Failed",Variables.numQforRemoval,false);
            Variables.numQforRemoval = Variables.numQforRemoval - 1;
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveFailedToRemove();
                    }
                });
                try {Thread.sleep(2000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            stats.updateStats(Variables.removalStats, Variables.numRemoval);
            Variables.numRemoval = Variables.numRemoval + 1;
            doGraphic("RemoveEng", Variables.numRemoval, true);

            stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
            doGraphic("MSRDidle", Variables.numMSRDIdle,false);
            Variables.numMSRDIdle = Variables.numMSRDIdle - 1;
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveMSRDtoRemove();
                    }
                });
                try {Thread.sleep(2500);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RemoveMSRD", Variables.numRemoval, true);

            t = stats.getDuration(Variables.removalTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(2);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endRemoval ()
    {
        stats.updateStats(Variables.qHelisNoEngineStats, Variables.numQHelisNoEngine);
        Variables.numQHelisNoEngine = Variables.numQHelisNoEngine + 1;
        doGraphic("RemoveEng", Variables.numRemoval, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveRemoveToHeliWait();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        doGraphic("HeliWait",Variables.numQHelisNoEngine, true);

        stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
        Variables.numMSRDIdle = Variables.numMSRDIdle + 1;
        doGraphic("RemoveMSRD",Variables.numRemoval, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveRemovetoMSRDidle();
                }
            });
            try {Thread.sleep(2500);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        doGraphic("MSRDidle",Variables.numMSRDIdle, true);

        stats.updateStats(Variables.qforToWorkshopStats, Variables.numQforToWorkshop);
        Variables.numQforToWorkshop = Variables.numQforToWorkshop + 1;
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveRemovetoDQ1();
                }
            });
            try {Thread.sleep(2400);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        doGraphic("DummyQ1", Variables.numQforToWorkshop, true);

        stats.updateStats(Variables.removalStats, Variables.numRemoval);
        Variables.numRemoval = Variables.numRemoval - 1;

        startToWorkshop();
        startRefit();
        startRemoval();
    }

    public void startToWorkshop ()
    {
        double t;
        EventData N = new EventData();

        if (Variables.numQforToWorkshop > 0)
        {
            stats.updateStats(Variables.qforToWorkshopStats, Variables.numQforToWorkshop);
            doGraphic("DummyQ1", Variables.numQforToWorkshop, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveDQ1toTransport();
                    }
                });
                try {Thread.sleep(2400);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            Variables.numQforToWorkshop = Variables.numQforToWorkshop - 1;

            stats.updateStats(Variables.toWorkshopStats, Variables.numToWorkshop);
            Variables.numToWorkshop = Variables.numToWorkshop + 1;
            doGraphic("ToWorkshop",Variables.numToWorkshop, true);

            t = stats.getDuration(Variables.toWorkshopTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(3);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endToWorkshop ()
    {
        stats.updateStats(Variables.toWorkshopStats, Variables.numToWorkshop);
        doGraphic("ToWorkshop",Variables.numToWorkshop, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveTransportToBadEng();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        Variables.numToWorkshop = Variables.numToWorkshop - 1;

        stats.updateStats(Variables.qforRepairStats, Variables.numQforRepair);
        Variables.numQforRepair = Variables.numQforRepair + 1;
        doGraphic("BadEngine",Variables.numQforRepair, true);

        startRepair();
    }

    public void startRefit ()
    {
        double t;
        EventData N = new EventData();

        if ((Variables.numQHelisNoEngine > 0) && (Variables.numMSRDIdle > 0) && (Variables.numQforRefit > 0))
        {
            stats.updateStats(Variables.refitStats, Variables.numRefit);
            Variables.numRefit = Variables.numRefit + 1;

            stats.updateStats(Variables.qHelisNoEngineStats, Variables.numQHelisNoEngine);
            doGraphic("HeliWait", Variables.numQHelisNoEngine, false);
            Variables.numQHelisNoEngine = Variables.numQHelisNoEngine - 1;
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveHeliToRefit();
                    }
                });
                try {Thread.sleep(3000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RefitHeli",Variables.numRefit, true);

            stats.updateStats(Variables.qforRefitStats, Variables.numQforRefit);
            doGraphic("GoodEngine",Variables.numQforRefit, false);
            Variables.numQforRefit = Variables.numQforRefit - 1;
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveEngToRefit();
                    }
                });
                try {Thread.sleep(2300);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RefitEng", Variables.numRefit, true);

            stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
            doGraphic("MSRDidle", Variables.numMSRDIdle, false);
            Variables.numMSRDIdle = Variables.numMSRDIdle - 1;
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveMSRDToRefit();
                    }
                });
                try {Thread.sleep(2500);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RefitMSRD", Variables.numRefit, true);

            t = stats.getDuration(Variables.refitTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(4);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endRefit ()
    {
        doGraphic("RefitEng", Variables.numRefit, false);
        doGraphic("RefitMSRD", Variables.numRefit,false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveMSRDRefitToIdle();
                }
            });
            try {Thread.sleep(2500);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
        Variables.numMSRDIdle = Variables.numMSRDIdle + 1;
        doGraphic("MSRDidle",Variables.numMSRDIdle, true);

        doGraphic("RefitHeli", Variables.numRefit, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveHeliToQforOp();
                }
            });
            try {Thread.sleep(2000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.qforOperationalStats, Variables.numQforOperational);
        Variables.numQforOperational = Variables.numQforOperational + 1;
        doGraphic("OperationalQ",Variables.numQforOperational, true);

        stats.updateStats(Variables.refitStats, Variables.numRefit);
        Variables.numRefit = Variables.numRefit -1;

        startOperational();
        startRefit();
        startRemoval();
    }

    public void startRepair ()
    {
        double t;
        EventData N = new EventData();
        if ((Variables.numQforRepair > 0) && (Variables.numRepairTeamsIdle > 0))
        {
            stats.updateStats(Variables.qforRepairStats, Variables.numQforRepair);
            doGraphic("BadEngine", Variables.numQforRepair,false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveBadEngToRepair();
                    }
                });
                try {Thread.sleep(1000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            Variables.numQforRepair = Variables.numQforRepair - 1;

            stats.updateStats(Variables.repairStats, Variables.numRepair);
            Variables.numRepair = Variables.numRepair +1;
            doGraphic("RepairEngine", Variables.numRepair, true);
            stats.updateStats(Variables.repairTeamsIdleStats, Variables.numRepairTeamsIdle);
            doGraphic("RepairTeamIdle", Variables.numRepairTeamsIdle, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveTeamToRepair();
                    }
                });
                try {Thread.sleep(3000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            Variables.numRepairTeamsIdle = Variables.numRepairTeamsIdle - 1;
            doGraphic("RepairTeam", Variables.numRepair, true);

            t = stats.getDuration(Variables.repairTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(5);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endRepair ()
    {
        doGraphic("RepairTeam",Variables.numRepair, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveTeamFromRepair();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.repairTeamsIdleStats, Variables.numRepairTeamsIdle);
        Variables.numRepairTeamsIdle = Variables.numRepairTeamsIdle + 1;
        doGraphic("RepairTeamIdle", Variables.numRepairTeamsIdle, true);

        doGraphic("RepairEngine", Variables.numRepair, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveFromRepairToDQ2();
                }
            });
            try {Thread.sleep(1400);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.repairStats, Variables.numRepair);
        Variables.numRepair = Variables.numRepair - 1;

        stats.updateStats(Variables.qforToOperationStats, Variables.numQforToOperation);
        Variables.numQforToOperation = Variables.numQforToOperation +1;
        doGraphic("DummyQ2", Variables.numQforToOperation, true);

        startToOperation();
        startRepair();
    }

    public void startToOperation ()
    {
        double t;
        EventData N = new EventData();

        if (Variables.numQforToOperation > 0)
        {
            stats.updateStats(Variables.qforToOperationStats, Variables.numQforToOperation);
            doGraphic("DummyQ2", Variables.numQforToOperation, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveDQ2ToTransport();
                    }
                });
                try {Thread.sleep(3000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            Variables.numQforToOperation = Variables.numQforToOperation - 1;

            stats.updateStats(Variables.toOperationStats, Variables.numToOperation);
            Variables.numToOperation = Variables.numToOperation + 1;
            doGraphic("ToOperation", Variables.numToOperation, true);

            t = stats.getDuration(Variables.toOperationTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(6);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endToOperation ()
    {
        stats.updateStats(Variables.toOperationStats, Variables.numToOperation);
        doGraphic("ToOperation", Variables.numToOperation, false);
        Variables.numToOperation = Variables.numToOperation -1;
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveTransportToGoodEng();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }

        stats.updateStats(Variables.qforRefitStats, Variables.numQforRefit);
        Variables.numQforRefit = Variables.numQforRefit +1;
        doGraphic("GoodEngine", Variables.numQforRefit, true);

        startRefit();
    }

    public void startOperational()
    {
        double t;
        EventData N = new EventData();

        if ((Variables.numQforOperational > 0) && (Variables.numOperational < Variables.maxHelicopters))
        {
            stats.updateStats(Variables.qforOperationalStats, Variables.numQforOperational);
            doGraphic("OperationalQ",Variables.numQforOperational, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveHeliToOp();
                    }
                });
                try {Thread.sleep(1000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            Variables.numQforOperational = Variables.numQforOperational -1;

            stats.updateStats(Variables.operationalStats, Variables.numOperational );
            Variables.numOperational = Variables.numOperational + 1;
            doGraphic("Operational", Variables.numOperational, true);

            t = stats.getDuration(Variables.operationalTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(1);
            sim.addEvent(Variables.list, N);
        }
    }

    public void doGraphic(final String x, final int y, final boolean z)
    {
        if ((Variables.graphicsOn)&& (!Variables.stopNow)) {
            if (!Variables.animationsOn)
            {
                try {Thread.sleep(500);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    graphics.switchImage(x,y,z);
                }
            });
        }
    }
}

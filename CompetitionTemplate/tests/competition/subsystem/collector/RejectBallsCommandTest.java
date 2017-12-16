package competition.subsystem.collector;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import competition.subsystems.drive.PickUpBallsSubsystem;
import competition.subsystems.drive.commands.RejectBallsCommand;
import xbot.common.injection.BaseWPITest;

public class RejectBallsCommandTest extends BaseWPITest{

    PickUpBallsSubsystem pubs;
    RejectBallsCommand rbc;
    
    @Override
    public void setUp() {
        // TODO Auto-generated method stub
        super.setUp();
        
        pubs = injector.getInstance(PickUpBallsSubsystem.class);
        rbc= injector.getInstance(RejectBallsCommand.class);
        
    }

    @Test
    public void testMotorResponse() {
        
        
        assertEquals(0, pubs.motorCollector.get(), 0.001);
        
       rbc.initialize();
       rbc.execute();
        
        assertEquals(-1,pubs.motorCollector.get() ,0.001); 
 
        
    }
    
    
    
}

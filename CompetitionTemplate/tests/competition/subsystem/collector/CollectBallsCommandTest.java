package competition.subsystem.collector;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import competition.subsystems.drive.PickUpBallsSubsystem;
import competition.subsystems.drive.commands.CollectBallsCommand;
import xbot.common.injection.BaseWPITest;

public class CollectBallsCommandTest extends BaseWPITest{
  
    PickUpBallsSubsystem pubs;
    CollectBallsCommand cbc;
    
    @Override
    public void setUp() {
        // TODO Auto-generated method stub
        super.setUp();
        
        pubs = injector.getInstance(PickUpBallsSubsystem.class);
        cbc= injector.getInstance(CollectBallsCommand.class);
        
    }

    @Test
    public void testMotorResponse() {
        
        assertEquals(0, pubs.motorCollector.get(), 0.001);
        
       cbc.initialize();
       cbc.execute();
        
        assertEquals(1,pubs.motorCollector.get() ,0.001); 
 
        
    }
    
    
}

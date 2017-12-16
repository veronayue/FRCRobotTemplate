package competition.subsystem.collector;

import xbot.common.injection.BaseWPITest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import competition.subsystems.drive.PickUpBallsSubsystem;
import competition.subsystems.drive.commands.CollectBallsCommand;

public class CollectorSubsystemTest extends BaseWPITest {

    PickUpBallsSubsystem pubs;
    
    @Override
    public void setUp() {
        // TODO Auto-generated method stub
        super.setUp();
        
        pubs = injector.getInstance(PickUpBallsSubsystem.class);
        
    }
    
    
    
    @Test
    public void testMotorResponse() {
        pubs.collect();
        
        assertEquals(1,pubs.motorCollector.get() ,0.001); 
        
        pubs.reject();
        
        assertEquals(-1,pubs.motorCollector.get() ,0.001); 
        
        
    }
    
    
}

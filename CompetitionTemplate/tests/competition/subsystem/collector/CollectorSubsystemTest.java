package competition.subsystem.collector;

import xbot.common.injection.BaseWPITest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import competition.subsystems.drive.PickUpBallsSubsystem;

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
        pubs.collectBall();
        
        assertEquals(-1,pubs.motorCollector.get() ,0.001);
    }
}

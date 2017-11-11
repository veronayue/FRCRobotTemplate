package competition.subsystems.drive.commands;

import org.junit.Test;

import competition.subsystems.drive.DriveSubsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import xbot.common.injection.BaseWPITest;

public class Rotate90Test extends BaseWPITest{
 
    @Test
    public void testo() {
        
        Turn90DegreeLeftCommand command =  injector.getInstance(Turn90DegreeLeftCommand.class);
        DriveSubsystem drive =  injector.getInstance(DriveSubsystem.class);
        
        this.mockRobotIO.setGyroHeading(0);
        
        command.initialize();
        command.execute();
        
        assertEquals(-1, drive.leftMaster.get(), 0.001);
        assertEquals(1, drive.rightMaster.get(), 0.001);
        assertFalse(command.isFinished());
        
        this.mockRobotIO.setGyroHeading(90);
        command.execute();
        
        assertEquals(1,drive.leftMaster.get(), 0.001);
        assertEquals(-1, drive.rightMaster.get(), 0.001);
        
        command.execute();
                
        // what should you test here?
        assertEquals(0,drive.leftMaster.get(),0.001);
        assertEquals(0, drive.rightMaster.get(),0.001);
        
        assertTrue(command.isFinished());
    }
}

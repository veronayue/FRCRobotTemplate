package competition.subsystems;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.drive.PickUpBallsSubsystem;
import competition.subsystems.drive.commands.StopTheCollectorCommand;
import competition.subsystems.drive.commands.TankDriveWithJoysticksCommand;

@Singleton
public class SubsystemDefaultCommandMap {
    // For setting the default commands on subsystems

    @Inject
    public void setupDriveSubsystem(
            DriveSubsystem driveSubsystem, 
            TankDriveWithJoysticksCommand command) {
        
        driveSubsystem.setDefaultCommand(command);
    }
    
    @Inject
    public void setupPickUpBallsSubsystem(
        PickUpBallsSubsystem pickUpBallsSubsystem,
        StopTheCollectorCommand command) {
        
        pickUpBallsSubsystem.setDefaultCommand(command);
    }
    
    
    
}

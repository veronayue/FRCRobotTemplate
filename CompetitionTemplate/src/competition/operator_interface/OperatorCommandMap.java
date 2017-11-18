package competition.operator_interface;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.drive.commands.CollectBallsCommand;
import competition.subsystems.drive.commands.RejectBallsCommand;
import competition.subsystems.drive.commands.StopTheCollectorCommand;
import competition.subsystems.drive.commands.Turn90DegreeLeftCommand;

@Singleton
public class OperatorCommandMap {
    // For mapping operator interface buttons to commands

    // Example for setting up a command to fire when a button is pressed:
    
    @Inject
    public void setupDriveCommands(
            OperatorInterface operatorInterface,
            Turn90DegreeLeftCommand Turn90Command, StopTheCollectorCommand StopTheCollect)
    {
        operatorInterface.leftButtons.getIfAvailable(1).whenPressed(Turn90Command);
        operatorInterface.leftButtons.getIfAvailable(2).whenPressed(StopTheCollect);
    }
    
    @Inject
    public void setupCollectorCommands(
            
            OperatorInterface operatorInterface,
            
            CollectBallsCommand CollectBallsCommand,
            RejectBallsCommand RejectBallsCommand)
    {
        operatorInterface.leftButtons.getIfAvailable(3).whileHeld(CollectBallsCommand);
        operatorInterface.leftButtons.getIfAvailable(4).whileHeld(RejectBallsCommand);

    }
    
}

package competition.operator_interface;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.drive.commands.Turn90DegreeLeftCommand;

@Singleton
public class OperatorCommandMap {
    // For mapping operator interface buttons to commands

    // Example for setting up a command to fire when a button is pressed:
    
    @Inject
    public void setupMyCommands(
            OperatorInterface operatorInterface,
            Turn90DegreeLeftCommand myCommand)
    {
        operatorInterface.leftButtons.getIfAvailable(1).whenPressed(myCommand);
    }
    
}

package competition.subsystems.drive.commands;

import competition.subsystems.drive.PickUpBallsSubsystem;
import xbot.common.command.BaseCommand;
import xbot.common.properties.XPropertyManager;

public class StopTheCollectorCommand extends BaseCommand{
    
    @Inject
    public StopTheCollectorCommand(PickUpBallsSubsystem pickUpBallsSubsystem){
        requires(pickUpBallsSubsystem);
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }

    
    
    

}

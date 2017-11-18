package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.subsystems.drive.PickUpBallsSubsystem;
import xbot.common.command.BaseCommand;


public class CollectBallsCommand extends BaseCommand{
    
    PickUpBallsSubsystem pickUp;
    
    @Inject
    public CollectBallsCommand(PickUpBallsSubsystem p){
    
        requires(p);
        pickUp=p;
       
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        pickUp.collect();
        
    }

}

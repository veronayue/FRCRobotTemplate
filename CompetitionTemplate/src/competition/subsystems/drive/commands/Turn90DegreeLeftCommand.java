package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.drive.DriveSubsystemTest;
import xbot.common.command.BaseCommand;
import xbot.common.math.ContiguousHeading;

public class Turn90DegreeLeftCommand extends BaseCommand{

    ContiguousHeading goalDegree;
    ContiguousHeading currentDegree;
    double error;
    final DriveSubsystem drive;
    double speed;

    
    
    @Inject
    public Turn90DegreeLeftCommand(DriveSubsystem d) {
        // TODO Auto-generated constructor stub
        drive=d;
    }
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        currentDegree=drive.getHeading();
        goalDegree=currentDegree.shiftValue(90);
     
    
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub

        currentDegree=drive.getHeading();
        error=goalDegree.difference(currentDegree);
        
        
   
    }

}

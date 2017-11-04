package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.drive.DriveSubsystemTest;
import xbot.common.command.BaseCommand;
import xbot.common.math.ContiguousHeading;

public class Turn90DegreeLeftCommand extends BaseCommand{

    ContiguousHeading goalDegree;
    ContiguousHeading startDegree;
    ContiguousHeading currentDegree;
    
    final DriveSubsystem drive;
    double oldError;
    double currentError;
    double errorVelocity;
    
    
    
    @Inject
    public Turn90DegreeLeftCommand(DriveSubsystem d) {
        // TODO Auto-generated constructor stub
        drive=d;
    }
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        startDegree=drive.getHeading();
        goalDegree=currentDegree.shiftValue(90);
     
    
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub

        currentDegree=drive.getHeading();
        currentError=goalDegree.difference(currentDegree);
        errorVelocity=oldError-currentError;
        
        double power=currentError/13-errorVelocity/2;
        //drive.tankDrive ()
        oldError=currentError;
        
      
   
    }

}

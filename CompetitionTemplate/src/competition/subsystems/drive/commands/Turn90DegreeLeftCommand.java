package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;
import xbot.common.math.ContiguousHeading;
import xbot.common.math.MathUtils;
import xbot.common.math.PIDFactory;
import xbot.common.math.PIDManager;
import xbot.common.properties.DoubleProperty;
import xbot.common.properties.XPropertyManager;

public class Turn90DegreeLeftCommand extends BaseCommand{

    ContiguousHeading goalDegree;
    ContiguousHeading startDegree;
    ContiguousHeading currentDegree;
    
    final DriveSubsystem drive;
    double oldError;
    double currentError;
    double errorVelocity;
    PIDManager pid;
    final DoubleProperty headingprop;
    
    
    
    @Inject
    public Turn90DegreeLeftCommand(DriveSubsystem d,PIDFactory p,XPropertyManager xpm) {
        // TODO Auto-generated constructor stub
        drive=d; //important to call DriveSubsystem
        pid = p.createPIDManager("turn90Left", 0.076, 0, 0.5);
        pid.setEnableDerivativeThreshold(true);
        pid.setEnableErrorThreshold(true);
        
        pid.setErrorThreshold(1);
        pid.setDerivativeThreshold(1);
        headingprop=xpm.createEphemeralProperty("gyroHeading",0);
        
        requires(drive);
    }
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        startDegree=drive.getHeading();
        currentDegree= drive.getHeading();
        goalDegree = currentDegree.clone();
        goalDegree.shiftValue(90);
     
        currentError=-goalDegree.difference(currentDegree);
        oldError = currentError;
        
        pid.reset();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub

        currentDegree=drive.getHeading();
        currentError=-goalDegree.difference(currentDegree);
        
        headingprop.set(currentDegree.getValue());
        
        double power = -pid.calculate(0, currentError);
        drive.tankDrive(-power, power);
        //error
       /* currentError=-goalDegree.difference(currentDegree);
        errorVelocity=oldError-currentError;
        
        double power=currentError*1/13-errorVelocity*1/2;
        
        power = MathUtils.constrainDoubleToRobotScale(power);
        
        drive.tankDrive(-power, power);
        oldError=currentError;*/
     
        
    }
    
    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        //return Math.abs(currentError)<1 && Math.abs(errorVelocity)<1;
        return pid.isOnTarget();
    }
}

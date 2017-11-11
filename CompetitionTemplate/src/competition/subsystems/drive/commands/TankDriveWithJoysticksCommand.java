package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import xbot.common.command.BaseCommand;
import xbot.common.properties.BooleanProperty;
import xbot.common.properties.DoubleProperty;
import xbot.common.properties.XPropertyManager;

public class TankDriveWithJoysticksCommand extends BaseCommand {

    final DriveSubsystem driveSubsystem;
    final OperatorInterface oi;
    final DoubleProperty leftProperty;
    final DoubleProperty rightProperty;
    final DoubleProperty headingprop;
    BooleanProperty broken;
    BooleanProperty connected;

 
    @Inject
    public TankDriveWithJoysticksCommand(OperatorInterface oi, DriveSubsystem driveSubsystem, XPropertyManager propertyManager, XPropertyManager xpm) {
        this.oi = oi;
        this.driveSubsystem = driveSubsystem;
        this.requires(this.driveSubsystem);
        this.leftProperty = propertyManager.createEphemeralProperty("leftY", 0);
        this.rightProperty = propertyManager.createEphemeralProperty("rightY", 0);      
        headingprop=xpm.createEphemeralProperty("gyroHeading",0);
        broken=propertyManager.createEphemeralProperty("isBroken", false);
        connected=propertyManager.createEphemeralProperty("isConnected", false);
        
    }

    @Override
    public void initialize() {
    }

    @Override
 
    public void execute() {
        
        double leftY = oi.leftJoystick.getVector().y;
        
        leftProperty.set(leftY);
        
        double rightY = -oi.leftJoystick.getRawAxis(5); //oi.rightJoystick.getVector().y;
        
        rightProperty.set(rightY);
        
        headingprop.set(driveSubsystem.getHeading().getValue());
        
   
       broken.set(driveSubsystem.isBroken());
       connected.set(driveSubsystem.isConnected());
        
       
        driveSubsystem.tankDrive(leftY, rightY);//equal???

    }

}

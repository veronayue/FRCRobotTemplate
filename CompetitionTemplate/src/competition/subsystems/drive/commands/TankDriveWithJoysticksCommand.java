package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;
import xbot.common.properties.DoubleProperty;
import xbot.common.properties.XPropertyManager;

public class TankDriveWithJoysticksCommand extends BaseCommand {

    final DriveSubsystem driveSubsystem;
    final OperatorInterface oi;
    final DoubleProperty leftProperty;
    final DoubleProperty rightProperty;

    @Inject
    public TankDriveWithJoysticksCommand(OperatorInterface oi, DriveSubsystem driveSubsystem, XPropertyManager propertyManager) {
        this.oi = oi;
        this.driveSubsystem = driveSubsystem;
        this.requires(this.driveSubsystem);
        this.leftProperty = propertyManager.createEphemeralProperty("leftY", 0);
        this.rightProperty = propertyManager.createEphemeralProperty("rightY", 0);        
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
        
        driveSubsystem.tankDrive(leftY, rightY);//equal???

    }

}

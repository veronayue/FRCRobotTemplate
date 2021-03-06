package competition.subsystems.drive;

import org.apache.log4j.Logger;

import com.ctre.CANTalon.TalonControlMode;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XCANTalon;
import xbot.common.controls.actuators.XSolenoid;
import xbot.common.controls.actuators.XSpeedController;
import xbot.common.controls.sensors.NavImu.ImuType;
import xbot.common.controls.sensors.XGyro;
import xbot.common.injection.wpi_factories.WPIFactory;
import xbot.common.math.ContiguousHeading;
import xbot.common.properties.XPropertyManager;

@Singleton
public class DriveSubsystem extends BaseSubsystem {
    private static Logger log = Logger.getLogger(DriveSubsystem.class);

    public final XCANTalon leftMaster;
    public final XCANTalon leftFollower;
    public final XCANTalon rightMaster;
    public final XCANTalon rightFollower;
    public final XSolenoid shift;
    public final XGyro rotationGyroDetector; 
    
    @Inject
    public DriveSubsystem(WPIFactory factory, XPropertyManager propManager) {
        log.info("Creating DriveSubsystem");
        
        leftMaster=factory.getCANTalonSpeedController(34);
        leftFollower=factory.getCANTalonSpeedController(35);
        rightMaster=factory.getCANTalonSpeedController(21);
        rightFollower=factory.getCANTalonSpeedController(20);
        
        leftMaster.setInverted(true);

        leftFollower.setControlMode(TalonControlMode.Follower);
        leftFollower.set(34);
        rightFollower.setControlMode(TalonControlMode.Follower);
        rightFollower.set(21);
        
        this.shift = factory.getSolenoid(1);
        this.shift.setInverted(true);
        
        rotationGyroDetector= factory.getGyro(ImuType.navX);
        
        leftMaster.setControlMode(TalonControlMode.PercentVbus);
        rightMaster.setControlMode(TalonControlMode.PercentVbus);
       
    }

    public ContiguousHeading getHeading(){
        
        return rotationGyroDetector.getYaw();
    }  
    public boolean isBroken(){
          return rotationGyroDetector.isBroken();
    }
      
      public boolean isConnected(){
         return rotationGyroDetector.isConnected();
     }
       
    public void tankDrive(double leftPower, double rightPower) {
       
        leftMaster.set(leftPower);
        rightMaster.set(rightPower);
        
        
    }
}
 
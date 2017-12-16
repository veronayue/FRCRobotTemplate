package competition.subsystems.drive;

import org.apache.log4j.Logger;

import com.ctre.CANTalon.TalonControlMode;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XCANTalon;
import xbot.common.injection.wpi_factories.WPIFactory;
import xbot.common.properties.DoubleProperty;
import xbot.common.properties.XPropertyManager;

@Singleton
public class PickUpBallsSubsystem extends BaseSubsystem {
    

    private static Logger log = Logger.getLogger(DriveSubsystem.class);
    
    public final XCANTalon motorCollector;
    final DoubleProperty theCollectPower;
    final DoubleProperty theRejectPower;

    
    @Inject
    public PickUpBallsSubsystem(WPIFactory factory, XPropertyManager propertyManager) {
        log.info("Creating PickUpBallsSubsystem");
        
        
              this.theCollectPower=propertyManager.createPersistentProperty("collectPower", 1);
              this.theRejectPower=propertyManager.createPersistentProperty("rejectPower", -1);
                 
        motorCollector=factory.getCANTalonSpeedController(30);
        motorCollector.setInverted(true);
        motorCollector.setControlMode(TalonControlMode.PercentVbus);
   
    }
    
    public void collect(){
        motorCollector.set(theCollectPower.get());//get double from different property
    }
    
        public void reject(){
  
        motorCollector.set(theRejectPower.get());

    }   
    
    public void stop() {
        motorCollector.set(0);
    }
    
}
 
    



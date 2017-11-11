package competition.subsystems.drive;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XCANTalon;
import xbot.common.injection.wpi_factories.WPIFactory;
import xbot.common.properties.XPropertyManager;

@Singleton
public class PickUpBallsSubsystem extends BaseSubsystem {
    

    private static Logger log = Logger.getLogger(DriveSubsystem.class);
    
    public final XCANTalon motorCollector;
    
    @Inject
    public PickUpBallsSubsystem(WPIFactory factory, XPropertyManager propManager) {
        log.info("Creating PickUpBallsSubsystem");
        
        motorCollector=factory.getCANTalonSpeedController(30);
        
    }
}        
    



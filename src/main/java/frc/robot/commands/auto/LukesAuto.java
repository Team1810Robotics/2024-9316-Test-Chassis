package frc.robot.commands.auto;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.utility.Drive;
import frc.robot.subsystems.DriveSubsystem;
public class LukesAuto extends SequentialCommandGroup {

     public LukesAuto(DriveSubsystem driveSubsystem) {

        addCommands(

            //drive back
            new Drive(driveSubsystem, -.5, -.5, false).withTimeout(2) 
            
          
    );

    
    }
    
}




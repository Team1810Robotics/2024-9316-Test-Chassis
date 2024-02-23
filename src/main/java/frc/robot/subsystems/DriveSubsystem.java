package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix.sensors.Pigeon2;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.util.PathPlannerLogging;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.proto.Kinematics;
import com.pathplanner.lib.util.ReplanningConfig;
import edu.wpi.first.math.kinematics.Odometry;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class DriveSubsystem extends SubsystemBase {
    
    private Talon leftMotors;
    private Talon rightMotors;
    
    private IntakeSubsystem intakeSubsystem;
    public Pigeon2 pg;

    private DifferentialDriveOdometry m_Odometry;

    

    // private Kinematics kinematics;

     
    public Pose2d getPose(){
    return m_Odometry.getPoseMeters();
    }


    public ChassisSpeeds getRobotRelativeSpeeds(){
      //TD_KINEMATICS

      // NEED WHEEL DIAMETER
      
      ChassisSpeeds spd = new ChassisSpeeds(.5,0,0);
    return spd;
    }

    public void driveRobotRelative(){
    
    }

    public DriveSubsystem() {
        leftMotors = new Talon(DriveConstants.LEFT_MOTORS);
        rightMotors = new Talon(DriveConstants.RIGHT_MOTORS);


        leftMotors.setInverted(DriveConstants.LEFT_INVERTED);
        rightMotors.setInverted(DriveConstants.RIGHT_INVERTED);

        pg = new Pigeon2(DriveConstants.GYRO);
        pg.configFactoryDefault();


         AutoBuilder.configureRamsete(
            this::getPose, // Robot pose supplier
            this::resetPose, // Method to reset odometry (will be called if your auto has a starting pose)
            this::getRobotRelativeSpeeds, // Current ChassisSpeeds supplier
            this::drive, // Method that will drive the robot given ChassisSpeeds
            new ReplanningConfig(), // Default path replanning config. See the API for the options here
            () -> {
              // Boolean supplier that controls when the path will be mirrored for the red alliance
              // This will flip the path being followed to the red side of the field.
              // THE ORIGIN WILL REMAIN ON THE BLUE SIDE

              var alliance = DriverStation.getAlliance();
              if (alliance.isPresent()) {
                return alliance.get() == DriverStation.Alliance.Red;
              }
              return false;
            },
            this // Reference to this subsystem to set requirements
    );
    }

    public void zeroGyro(){
    pg.setYaw(0);
    }

  

    public void driveAutoGrab() {
        boolean noteCurrent = intakeSubsystem.getNoteDetector();
         if (!noteCurrent) {
            drive(-.5, -.5);
         } else {
            drive(.5, .5);
         }
    }
    

    public void stop() {
        leftMotors.stopMotor();
        rightMotors.stopMotor();
    }

    private void resetPose(Pose2d pose2d1) {
    }

     public void drive(double leftSpeed, double rightSpeed) {
        leftSpeed = MathUtil.applyDeadband(leftSpeed, .02);
        rightSpeed = MathUtil.applyDeadband(rightSpeed, .02);

        var speeds = DifferentialDrive.tankDriveIK(leftSpeed, rightSpeed, true);

        leftMotors.set(speeds.left);
        rightMotors.set(speeds.right);
    }
    
    private void drive(ChassisSpeeds chassisspeeds1) {



        double  DirectionSpeed = MathUtil.applyDeadband(chassisspeeds1.vxMetersPerSecond, .02);
        double  TurnSpeed = MathUtil.applyDeadband(chassisspeeds1.omegaRadiansPerSecond, .02);

        DifferentialDrive.arcadeDriveIK(DirectionSpeed, TurnSpeed, true);

    }

  
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.VisionSubsystem;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer robotContainer;


  private final Field2d m_field = new Field2d();

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    CameraServer.startAutomaticCapture();
    SmartDashboard.putData("Field", m_field);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    m_field.setRobotPose(robotContainer.visionSubsystem.getRobotPose().toPose2d());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    //  double time = Timer.getFPGATimestamp();
    //  if (time < 3){
    //    // Cross Line
    //  m_robotContainer.driveSubsystem.drive(1, 1);
    //  } else {
    //     if (time > 12){
    //          if (time < 15){
    //              m_robotContainer.driveSubsystem.drive(0.4, 0.6);
               
    //        // Moving, and turning right
    //          } else {
    //              m_robotContainer.driveSubsystem.stop();
    //       // Auto Complete
    //          }
    //       } else {
    //         // Cross Line Complete, Awaiting Next Move
    //         m_robotContainer.driveSubsystem.stop();
    //       }
    //  }  
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}

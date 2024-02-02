// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Climb;
import frc.robot.commands.Intake;
import frc.robot.commands.Shooter;
import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  private DriveSubsystem driveSubsystem = new DriveSubsystem();
  private IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private ClimbSubsystem climbSubsystem = new ClimbSubsystem();

  private Joystick leftJoystick = new Joystick(OperatorConstants.LEFT_JOYSTICK_PORT);
  private Joystick rightJoystick = new Joystick(OperatorConstants.RIGHT_JOYSTICK_PORT);

  private XboxController xboxController = new XboxController(OperatorConstants.XBOX_CONTROLLER_PORT);

  private final JoystickButton manipulatorXbox_A = new JoystickButton(xboxController, 0);
  private final JoystickButton manipulatorButton_Y = new JoystickButton(xboxController, 3);
  private final JoystickButton manipulatorXbox_B = new JoystickButton(xboxController, 1); //TODO: Double check this

  private final JoystickButton manipulatorXbox_LB = new JoystickButton(xboxController, 5);
   private final JoystickButton manipulatorXbox_RB = new JoystickButton(xboxController, 6);   

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(
      new TankDrive(
        () -> -leftJoystick.getY(),
        () -> -rightJoystick.getY(),
        driveSubsystem)
    );
    
    //TODO: BIG PROBLEM. Need to find a way to run both Intake and Shooter at the same time
    intakeSubsystem.setDefaultCommand(new Intake(manipulatorXbox_B.getAsBoolean(), intakeSubsystem));
    shooterSubsystem.setDefaultCommand(new Shooter(shooterSubsystem, intakeSubsystem, manipulatorXbox_LB.getAsBoolean(), manipulatorXbox_RB.getAsBoolean()));

    climbSubsystem.setDefaultCommand(new Climb(climbSubsystem, manipulatorXbox_A.getAsBoolean(), manipulatorButton_Y.getAsBoolean()));

    configureBindings();
  }

  private void configureBindings() {




  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

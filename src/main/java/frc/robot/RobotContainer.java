// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Climb;
import frc.robot.commands.Intake;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShootSpeaker;
import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
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

  private CommandXboxController xboxController = new CommandXboxController(OperatorConstants.XBOX_CONTROLLER_PORT);

  


  public RobotContainer() {
    driveSubsystem.setDefaultCommand(
      new TankDrive(
        () -> leftJoystick.getY(),
        () -> rightJoystick.getY(),
        driveSubsystem)
    );
    

    configureBindings();

    setShuffleboard();
  }

  private void configureBindings() {
    xboxController.rightBumper().onTrue(new Shoot(shooterSubsystem, intakeSubsystem));
    // manipulatorXbox_RB.whileFalse(new ShootSpeaker(shooterSubsystem));

    xboxController.b().onTrue(new Intake(intakeSubsystem, false, false));
    xboxController.x().whileTrue(new Intake(intakeSubsystem, true, true));

    xboxController.a().whileTrue(new Climb(climbSubsystem, false));
    xboxController.y().whileTrue(new Climb(climbSubsystem, true));
  }

  public void setShuffleboard() {
    Shuffleboard.getTab("Gen").addBoolean("Note Detector", () -> intakeSubsystem.getNoteDetector());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

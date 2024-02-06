// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Climb;
import frc.robot.commands.Intake;
import frc.robot.commands.ShootSpeaker;
import frc.robot.commands.TankDrive;
import frc.robot.commands.auto.Offline;
import frc.robot.commands.auto.ScoreOffline;
import frc.robot.commands.auto.ScoreOfflineScore;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
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

  private XboxController xboxController = new XboxController(OperatorConstants.XBOX_CONTROLLER_PORT);

  private final JoystickButton manipulatorXbox_A = new JoystickButton(xboxController, 1);
  private final JoystickButton manipulatorXbox_Y = new JoystickButton(xboxController, 4);
  private final JoystickButton manipulatorXbox_B = new JoystickButton(xboxController, 2); 

  private final JoystickButton manipulatorXbox_LB = new JoystickButton(xboxController, 5);
  private final JoystickButton manipulatorXbox_RB = new JoystickButton(xboxController, 6);

  private SendableChooser<Command> autoChooser = new SendableChooser<>();
  


  public RobotContainer() {
    driveSubsystem.setDefaultCommand(
      new TankDrive(
        () -> leftJoystick.getY(),
        () -> rightJoystick.getY(),
        driveSubsystem)
    );

    autoChooser.setDefaultOption("No Auto", new InstantCommand());
    autoChooser.addOption("offline", new Offline(driveSubsystem));
    autoChooser.addOption("scoreOffline", new ScoreOffline(driveSubsystem, intakeSubsystem, shooterSubsystem));
    autoChooser.addOption("scoreOfflineScore", new ScoreOfflineScore(shooterSubsystem, intakeSubsystem, driveSubsystem));
    
    Shuffleboard.getTab("Auto").add("Auto Chooser", autoChooser);

    configureBindings();
  }

  private void configureBindings() {
    manipulatorXbox_RB.whileTrue(new ShootSpeaker(shooterSubsystem));

    manipulatorXbox_A.onTrue(new Intake(intakeSubsystem, false, false));
    manipulatorXbox_B.whileTrue(new Intake(intakeSubsystem, true, true));
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shooter extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;

    private boolean shotChoice;

    public Shooter(boolean shotChoice, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem){
        this.shotChoice = shotChoice;
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(shooterSubsystem, intakeSubsystem);
    }

    @Override
    public void execute(){
        shooterSubsystem.shoot(shotChoice);

        new WaitCommand(1);

        intakeSubsystem.intake();

        new WaitCommand(.5);
    }

    @Override
    public boolean isFinished(){
        return true; //TODO: this
    }

    @Override
    public void end(boolean interrupted){
        shooterSubsystem.stop();
    }
}

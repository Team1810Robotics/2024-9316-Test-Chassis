package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shooter extends Command {
    private ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intakeSubsystem;


    public Shooter(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem){
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;

        addRequirements(shooterSubsystem, intakeSubsystem);
    }

    @Override
    public void execute(){
        shooterSubsystem.shoot();
    }

    @Override
    public boolean isFinished(){
        return false; //TODO: this
    }

    @Override
    public void end(boolean interrupted){
        shooterSubsystem.stop();
    }
}

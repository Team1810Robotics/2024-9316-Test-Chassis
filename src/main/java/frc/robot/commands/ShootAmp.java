package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootAmp extends Command {
    private ShooterSubsystem shooterSubsystem;

    public ShootAmp(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        shooterSubsystem.setAmpSpeed();
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stop();
    }
    
}

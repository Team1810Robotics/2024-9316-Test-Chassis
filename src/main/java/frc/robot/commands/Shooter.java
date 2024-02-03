package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class Shooter extends Command {

    private ShooterSubsystem shooterSubsystem;

    private boolean lb_Input;
    private boolean rb_Input;


    public Shooter(ShooterSubsystem shooterSubsystem, boolean lb_Input, boolean rb_Input){
        this.shooterSubsystem = shooterSubsystem;
        this.lb_Input = lb_Input;
        this.rb_Input = rb_Input;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute(){
        shooterSubsystem.shoot(rb_Input, lb_Input);
    }

    @Override
    public boolean isFinished(){
        return false; 
    }

    @Override
    public void end(boolean interrupted){
        shooterSubsystem.stop();
    }
}

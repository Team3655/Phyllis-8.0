package com.company.commands.Auto;

import com.company.subsystems.DriveTrainSubsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.*;


public class SwitchAuto extends Command {

    public SwitchAuto() {
        super("SwitchAuto");
    }


    @Override
    protected void initialize() {
        driveRight1.set(ControlMode.MotionMagic, 0);
        driveLeft1.set(ControlMode.MotionMagic, 0);
        super.initialize();
    }

    protected void execute() {
        //driveRight1.set();
        //driveLeft1.set();
    }
        protected boolean isFinished () {
        return (false);
        }

        protected void end () {
        }

        protected void interrupted () {
        }
    }
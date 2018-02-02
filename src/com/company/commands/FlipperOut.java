package com.company.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.MainDrive;

public class FlipperOut extends Command {
    public FlipperOut() {
        super("FlipperOut");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

            MainDrive.AutoDrive(0.5, 0);
        }
    protected boolean isFinished () {
        return (true);
    }
    protected void end () {
    }

    protected void interrupted () {
    }
}

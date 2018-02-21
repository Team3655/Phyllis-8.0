package com.company.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.flipperLeft;

//import static com.company.RobotMap.FlipperDrive;

public class FlipperOut extends Command {
    public FlipperOut() {
        super("FlipperOut");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

        flipperLeft.set(1);

        }
    protected boolean isFinished () {
        return (false);
    }
    protected void end () {
        flipperLeft.set(0);
    }

    protected void interrupted () {
        end();
    }
}

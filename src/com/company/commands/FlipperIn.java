package com.company.commands;


import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.FlipperDrive;

public class FlipperIn extends Command {
    public FlipperIn() {
        super("FlipperIn");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {
        //FlipperDrive.FlipperDrive(-0.9, 0);
    }
    protected boolean isFinished () {
        return (true);
    }
    protected void end () {
    }

    protected void interrupted () {
    }
}

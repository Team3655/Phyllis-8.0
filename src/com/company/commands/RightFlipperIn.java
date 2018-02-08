package com.company.commands;

import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.FlipperDrive;

public class RightFlipperIn extends Command {
    public RightFlipperIn() {
        super("RightFlipperIn");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

        //FlipperDrive.FlipperDrive(-0.0, -0.9);
    }
    protected boolean isFinished () {
        return (true);
    }
    protected void end () {
    }

    protected void interrupted () {
    }
}

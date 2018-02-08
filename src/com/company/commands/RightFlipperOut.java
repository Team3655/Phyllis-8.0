package com.company.commands;

import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.FlipperDrive;


public class RightFlipperOut extends Command {
    public RightFlipperOut() {
        super("RightFlipperOut");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

       // FlipperDrive.FlipperDrive(0.0, 0.9);
    }
    protected boolean isFinished () {
        return (true);
    }
    protected void end () {
    }

    protected void interrupted () {
    }
}

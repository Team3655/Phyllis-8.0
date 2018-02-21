package com.company.commands;

import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.flipperRight;

//import static com.company.RobotMap.FlipperDrive;

public class RightFlipperIn extends Command {
    public RightFlipperIn() {
        super("RightFlipperIn");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

        flipperRight.set(0.5);
    }
    protected boolean isFinished () {
        return(false);
    }
    protected void end () {
        flipperRight.set(0);
    }

    protected void interrupted () {
        end();
    }
}

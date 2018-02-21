package com.company.commands;


import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.flipperLeft;

public class FlipperIn extends Command {
    public FlipperIn() {
        super("FlipperIn");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {
        flipperLeft.set(-.5);
    }

    protected boolean isFinished() {
        return (false);
    }

    protected void end() {
        flipperLeft.set(0);
    }

    protected void interrupted() {
        end();
    }
}

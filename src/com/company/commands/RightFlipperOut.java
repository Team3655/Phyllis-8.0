package com.company.commands;

import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.flipperRight;

public class RightFlipperOut extends Command {
    public RightFlipperOut() {
        super("RightFlipperOut");
    }


    @Override
    protected void initialize() {
        super.initialize();
    }

    protected void execute() {

        flipperRight.set(-1);
    }
    protected boolean isFinished () {
        return(false);
    }
    protected void end (){
        flipperRight.set(0);
    }

    protected void interrupted () {
        end();
    }
}

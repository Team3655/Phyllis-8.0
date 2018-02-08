package com.company.commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup{
    Timer timer = new Timer();
    public  AutonomousCommand() {
        timer.start();
        if(timer.get() < 3)
        addSequential(new SwitchAuto());
    }
}

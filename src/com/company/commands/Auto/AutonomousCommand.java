package com.company.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
            addSequential(new SwitchAuto());
        }
    }

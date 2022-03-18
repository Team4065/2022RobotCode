// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous.GroupCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriverControl.setShooterMotors;
import frc.robot.commands.autonomous.Utilitycommands.CommandTime;
import frc.robot.commands.autonomous.Utilitycommands.setDrivePosition;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SimpleAuto extends SequentialCommandGroup {
  /** Creates a new SimpleAuto. */
  public SimpleAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new setShooterMotors(0.33), new CommandTime(1500), new setShooterMotors(0.0), new CommandTime(1500), new setDrivePosition(-100000.0)); 
  }
}

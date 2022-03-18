// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous.Utilitycommands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CommandTime extends CommandBase {
  /** Creates a new CommandTime. */
  int m_time;
  public CommandTime(int time) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_time = time;

  }
  Boolean FIN = false;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Waiting for " + m_time);
    try {
      Thread.sleep(m_time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    FIN = true;
    end(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return FIN;
  }
}

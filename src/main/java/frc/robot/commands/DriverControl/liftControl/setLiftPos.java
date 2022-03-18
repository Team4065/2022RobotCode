// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControl.liftControl;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class setLiftPos extends CommandBase {
  /** Creates a new setLiftPos. */
  Double m_pos;
  public setLiftPos(Double POS) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pos = POS;
    addRequirements(RobotContainer.m_lift);
  }
  Boolean FIN  = false;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_lift.getLiftSwitch() == false) {
      RobotContainer.m_lift.setMotorsZero();
    }
    if (m_pos <= 0) {
      RobotContainer.m_lift.Elli_R.selectProfileSlot(0, 0);
      RobotContainer.m_lift.setElliMotorsPos(m_pos);
      System.out.println("lift set: " + m_pos);
      System.out.println("lift at: " + RobotContainer.m_lift.getElliPos());
    } else {
      RobotContainer.m_lift.Elli_R.selectProfileSlot(1, 0);
      RobotContainer.m_lift.setElliMotorsPos(m_pos);
      System.out.println("lift set: " + m_pos);
      System.out.println("lift at: " + RobotContainer.m_lift.getElliPos());
    }
    FIN = true;
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous.Utilitycommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class setDrivePosition extends CommandBase {
  /** Creates a new setDrivePosition. */
  double m_distance;
  public setDrivePosition(double dist) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
    m_distance = dist;
  }
  boolean FIN = false;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_driveTrain.setRobotPos(m_distance);
    FIN = true;

    // if (RobotContainer.m_driveTrain.getRightPos() <= m_distance) {
    //   RobotContainer.m_driveTrain.setRobotPos(m_distance);
    //   FIN = true;
    // } else if (RobotContainer.m_driveTrain.getRightPos() >= m_distance) {
    //   RobotContainer.m_driveTrain.setRobotPos(m_distance);
    //   FIN = true;
    // } else if (RobotContainer.m_driveTrain.getRightPos() >= m_distance || RobotContainer.m_driveTrain.getRightPos() - 500 < m_distance || RobotContainer.m_driveTrain.getRightPos() + 500 > m_distance) {
    //   FIN = true;
    //   end(true);
    // }

    // RobotContainer.m_driveTrain.setAllMotors(ControlMode.PercentOutput, -0.4);
    // try {
    //   Thread.sleep(1000);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // RobotContainer.m_driveTrain.setAllMotors(ControlMode.PercentOutput, 0.0);
    // FIN = true;
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

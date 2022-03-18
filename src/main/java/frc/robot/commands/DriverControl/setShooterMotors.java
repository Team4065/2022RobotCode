// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControl;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class setShooterMotors extends CommandBase {
  /** Creates a new setShooterMotors. */
  double m_value;
  public setShooterMotors(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_flyWheel, RobotContainer.m_Beltsystem);
    m_value = speed;
  }
  Boolean FIN = false;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_value > 0) {
      RobotContainer.m_flyWheel.setShootMotors(ControlMode.PercentOutput, m_value);
      try {
        Thread.sleep(600);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      RobotContainer.m_Beltsystem.setAllBelts(0.5);
      FIN = true;
    }
    if (m_value < 0) {
      RobotContainer.m_flyWheel.setShootMotors(ControlMode.PercentOutput, -0.5);
      RobotContainer.m_Beltsystem.setAllBelts(0.5);
      FIN = true;
    }
    if (m_value == 0) {
      RobotContainer.m_Beltsystem.setAllBelts(0.0);
      RobotContainer.m_flyWheel.setShootMotors(ControlMode.PercentOutput, 0.0);
      FIN = true;
    }
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

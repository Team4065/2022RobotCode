// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControl.liftControl;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class setLiftAngle extends CommandBase {
  /** Creates a new setLiftAngle. */
  boolean m_deploy;
  boolean FIN = false;
  public setLiftAngle(boolean DEPLOY) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_air_systems);
    m_deploy = DEPLOY;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_deploy) {
      //Extend the lift
      RobotContainer.m_air_systems.liftSolenoid.set(true);;
    } else {
      //Pull back the lift
      RobotContainer.m_air_systems.liftSolenoid.set(false);
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

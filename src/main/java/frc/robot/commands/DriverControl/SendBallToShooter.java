// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControl;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SendBallToShooter extends CommandBase {
  /** Creates a new SendBallToShooter. */
  public SendBallToShooter() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Beltsystem);
  }
  Boolean FIN = false ;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_Beltsystem.setBelt1(1.0);
    RobotContainer.m_Beltsystem.setBelt2(0.5);
    RobotContainer.m_Beltsystem.setBelt3(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_BeamBreaks.getBeamBreak(1) == false) {
      RobotContainer.m_Beltsystem.setBelt1(0.7);
      RobotContainer.m_Beltsystem.setBelt2(0.5);
      RobotContainer.m_Beltsystem.setBelt3(0.5);
      //System.out.println("BB1 has been hit: " + RobotContainer.m_BeamBreaks.getBeamBreak(1));
      if (RobotContainer.m_BeamBreaks.getBeamBreak(2) == false) {
        RobotContainer.m_Beltsystem.setBelt1(0.0);
        RobotContainer.m_Beltsystem.setBelt2(0.0);
        RobotContainer.m_Beltsystem.setBelt3(0.0);
        //System.out.println("BB2 has been hit: " + RobotContainer.m_BeamBreaks.getBeamBreak(2));
        FIN = true;
      }
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

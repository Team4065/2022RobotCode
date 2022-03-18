// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous.Cameracommands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Cameras.IntakeLimeLight;

public class autoBall extends CommandBase {
  /** Creates a new autoBall. */
  public autoBall() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //pipeline 1 for blue balls
    //pipeline 2 for red balls
    IntakeLimeLight.setPipeline(3);
  }
  boolean FIN = false;


  //allowed error
  double offset = 0.5;

  //stage one marker
  double stage1 = 20;
  //stage two marker
  double stage2 = 10;
  //stage three marker
  double stage3 = 5;

  //turn speed 1
  double speed1 = 0.5;
  //turn speed 2
  double speed2 = 0.3;
  //turn speed 3
  double speed3 = 0.15;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (IntakeLimeLight.hasTarget() == true) {
      //stage 1
      if (IntakeLimeLight.getHorizontalOffset() > 20 || IntakeLimeLight.getHorizontalOffset() < -20) {
        if (IntakeLimeLight.getHorizontalOffset() > stage1){
          RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, speed1);
          RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, -speed1);
        }
        if (IntakeLimeLight.getHorizontalOffset() < -stage1){
          RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, -speed1);
          RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, speed1);
        }
      }
      //stage 2
      if (IntakeLimeLight.getHorizontalOffset() > 10 || IntakeLimeLight.getHorizontalOffset() < -10) {
        if (IntakeLimeLight.getHorizontalOffset() > stage2){
          RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, speed2);
          RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, -speed2);
        }
        if (IntakeLimeLight.getHorizontalOffset() < -stage2){
          RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, -speed2);
          RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, speed2);
        }
      }

      //stage 3
      if (IntakeLimeLight.getHorizontalOffset() > 5 || IntakeLimeLight.getHorizontalOffset() < -5) {
        if (IntakeLimeLight.getHorizontalOffset() > stage3){
          RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, speed3);
          RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, -speed3);
        }
        if (IntakeLimeLight.getHorizontalOffset() < -stage3){
          RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, -speed3);
          RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, speed3);
        }
      }

      if (IntakeLimeLight.getHorizontalOffset() > -offset && IntakeLimeLight.getHorizontalOffset() < offset){
        RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, 0);
        RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, 0);
        System.out.println("zero: " + IntakeLimeLight.getHorizontalOffset());
        end(true);
        FIN = true;
      }
    } else {
      //sentry
      RobotContainer.m_driveTrain.setLeftMotors(ControlMode.PercentOutput, speed3);
      RobotContainer.m_driveTrain.setRightMotors(ControlMode.PercentOutput, speed3);
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

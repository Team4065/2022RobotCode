// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public Intake() {}

  private Talon ITM = new Talon(Constants.INTAKE_MOTOR);
  
  public void setIntakeMotor(double speed) {
    ITM.set(speed);
  }
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

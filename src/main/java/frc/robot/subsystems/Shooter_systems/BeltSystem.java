// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BeltSystem extends SubsystemBase {
  /** Creates a new BeltSystem. */
  public BeltSystem() {}

  private Talon Belt1 = new Talon(Constants.BELT1);
  private Talon Belt2 = new Talon(Constants.BELT2);
  private Talon Belt3 = new Talon(Constants.BELT3);

  public void setBelt1 (Double speed) {
    Belt1.set(speed);
  }

  public void setBelt2 (Double speed) {
    Belt2.set(-speed);
  }

  public void setBelt3 (Double speed) {
    Belt3.set(speed);
  }

  public void setAllBelts (double speed) {
    Belt1.set(speed);
    Belt2.set(speed);
    Belt3.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

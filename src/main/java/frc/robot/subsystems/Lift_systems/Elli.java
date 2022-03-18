// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Lift_systems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elli extends SubsystemBase {
  /** Creates a new Elli. */
  public Elli() {
    // SupplyCurrentLimitConfiguration cfg = new SupplyCurrentLimitConfiguration(true, 50, 50, 0);
    // Elli_L.configSupplyCurrentLimit(cfg);
    // Elli_R.configSupplyCurrentLimit(cfg);
  }

  public TalonFX Elli_R = new TalonFX(Constants.ELLI_R);
  public TalonFX Elli_L = new TalonFX(Constants.ELLI_L);

  public DigitalInput LiftSwitch = new DigitalInput(Constants.LIFT_LIMIT_SWITCH);

  public int elli_pos = 0;

  public void setElliMotorsPos(double pos) {
    Elli_R.set(ControlMode.Position, pos);
    Elli_L.setInverted(true);
    Elli_L.follow(Elli_R);
  }

  public void setElliMotorsPercent(double pos) {
    Elli_R.set(ControlMode.PercentOutput, pos);
    Elli_L.setInverted(true);
    Elli_L.follow(Elli_R);
  }

  public void setMotorsZero () {
    Elli_R.setSelectedSensorPosition(0, 0, 0);
    Elli_L.setSelectedSensorPosition(0, 0, 0);
    System.out.println("Lift Zero");
  }

  public double getElliPos () {
    return Elli_R.getSelectedSensorPosition();
  }

  public Boolean getLiftSwitch () {
    return LiftSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

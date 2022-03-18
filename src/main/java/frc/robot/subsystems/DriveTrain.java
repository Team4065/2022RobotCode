// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  public static final Double Gro = null;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    //  RM.configOpenloopRamp(0.5);
    //  RS.configOpenloopRamp(0.5);
    //  LM.configOpenloopRamp(0.5);
    //  LS.configOpenloopRamp(0.5);
     RM.setNeutralMode(NeutralMode.Brake);
     LM.setNeutralMode(NeutralMode.Brake);
     setDriveMotorsZero();
  }
  // Extras
  SlewRateLimiter filter = new SlewRateLimiter(1);
  double PO = 0.4;
//Define DriveTrain Motors
  public final static TalonFX RM = new TalonFX(Constants.R_MASTER);
  public final static TalonFX RS = new TalonFX(Constants.R_SLAVE);
  public final static TalonFX LM = new TalonFX(Constants.L_MASTER);
  public final static TalonFX LS = new TalonFX(Constants.L_SLAVE);
//Define Rio Gyro
  //public AHRS GRO = new AHRS(SPI.Port.kMXP);

//Driver EX
double factor = 9;
double outP = 0;

public double EXPout (double input) {
  outP = Math.pow(input, factor);
  return outP;
}

//Setting public Functions
  //Setting the Rights motors control mode/speed
  public void setRightMotors(ControlMode CM ,double unit) {
    RM.set(CM, unit);
    RS.follow(RM);
  }
  //Setting the Left motors control mode/speed
  public void setLeftMotors(ControlMode CM ,double unit) {
    LM.set(CM, unit);
    LS.follow(LM);
  }

  public void setAllMotors(ControlMode CM,double unit) {
    setRightMotors(CM, unit);
    setLeftMotors(CM, -unit);
  }

  public void TurnNine() {
    setRightMotors(ControlMode.Position, 26624);
    setLeftMotors(ControlMode.Position, 26624);
  }

  //Getting the Motor POS/Dis
  public double getRightPos () {
    double RMPOS = RM.getSelectedSensorPosition();
    return RMPOS;
  }
  public double getLeftPos () {
    return LM.getSelectedSensorPosition();
  }

  public void setDriveMotorsZero () {
    RM.setSelectedSensorPosition(0);
    LM.setSelectedSensorPosition(0);
    RS.setSelectedSensorPosition(0);
    LS.setSelectedSensorPosition(0);
  }


  public void setRobotPos(double unit) {
    setAllMotors(ControlMode.Position, unit);
  }

  public void setRobotPosFT(double unit) {
    setAllMotors(ControlMode.Position, MotorAlg(unit));
    System.out.println("Position set to: " + MotorAlg(unit));
    System.out.println("Position at: " + getRightPos() + ", " + getRightPos());
  }

  private float MotorAlg(double feet) {
    float unit = (float) (25416.706444 * feet );
    return unit;
  }

  // Gear Ratio
  //4096 ticks = 1 rotation of the motor
  //11:60
  //6.5:1
  //one rotation = 26,624 ticks
  //4in wheels
  //2pi2in = 12.57in
  //- 12708.35322198
  //

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

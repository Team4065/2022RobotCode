// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Cameras;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeLimeLight extends SubsystemBase {
  /** Creates a new IntakeLimeLight. */
  public IntakeLimeLight() {}

  static public final edu.wpi.first.networktables.NetworkTable limelight = NetworkTableInstance.getDefault().getTable("10.40.65.12");

  //returns

  public static boolean hasTarget() {
    return (limelight.getEntry("tv").getDouble(Double.NaN) > 0) ? true : false;
  }

  public static double getHorizontalOffset() {
    return (limelight.getEntry("tx").getDouble(Double.NaN));
  }

  public static double getVerticalOffset() {
    return (limelight.getEntry("ty").getDouble(Double.NaN));
  }

  public static double getArea() {
    return (limelight.getEntry("ta").getDouble(Double.NaN));
  }

  public static double getRotation() {
    return (limelight.getEntry("ts").getDouble(Double.NaN));
  }

  //sets

  public static void setLEDMode(int mode) {
    limelight.getEntry("ledMode").setNumber(mode);
  }

  public static void enableVisionProcessing() {
    limelight.getEntry("camMode").setNumber(0.0);
  }

  public static void disableVisionProcessing() {
    limelight.getEntry("camMode").setNumber(1.0);
  }

  //pipeline

  public static void setPipeline(int pipeline) {
    limelight.getEntry("pipeline").setNumber(pipeline);
  }

  public static int getPipeline() {
    return(int)limelight.getEntry("pipeline").getDouble(Double.NaN);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

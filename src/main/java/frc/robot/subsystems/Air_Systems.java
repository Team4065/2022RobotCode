// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Air_Systems extends SubsystemBase {
  /** Creates a new Air_Systems. */
  public Air_Systems() {
    //setting the Compressor psi
    pHub.makeCompressor().enableAnalog(110, 120);
  }
  //making new Pnumatic Hub
   public PneumaticHub pHub = new PneumaticHub(Constants.PneumaticHub);

   //making new Solenoid
   public Solenoid intakeSolenoid = pHub.makeSolenoid(1);

   public Solenoid liftSolenoid = pHub.makeSolenoid(9);
  @Override
  public void periodic() {
  }
    // This method will be called once per scheduler run

}
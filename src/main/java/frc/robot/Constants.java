// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

//CAN connections
    //Drive Train Motors
    public static final int R_MASTER = 1;
    public static final int R_SLAVE = 2;
    public static final int L_MASTER = 3;
    public static final int L_SLAVE = 4;

    //Shooter Motors
    public static final int R_SHOOTER = 5;
    public static final int L_SHOOTER = 6;
    // public static final int SHOOTER_KICKER = 7;
    // public static final int TURRET_MOTOR = 8;
    
    //Lift Motors
    public static final int ELLI_R = 13;
    public static final int ELLI_L = 14;

    //Pneumatic Hub
    public static final int PneumaticHub = 16;

//RIO connections
    //Intake Motors
    public static final int INTAKE_MOTOR = 8;
    public static final int BELT1 = 7;
    public static final int BELT2 = 9;
    public static final int BELT3 = 6;
//DIO
    //Beam Break Port
    public static final int BB1 = 0;
    public static final int BB2 = 1;
    //lift switches
    public static final int LIFT_LIMIT_SWITCH = 5;

//PC
    // PC Connections
    public static final int JOYSTICK_PORT = 1;
    public static final int BOTTON_BOX_PORT = 0;
//Values
    //Robot Consts
    public static final Double LIFT_MAX = 488000.0; // 50:1
    // public static final Double LIFT_MAX = 390400.0; // 40:1
    public static final Double INNTAKE_SPEED = 0.28;
    public static final double UNLOAD = -0.6;
    public static final double HIGH_GOAL = 0.33;
    public static final double LOW_GOAL = 0.3;

}
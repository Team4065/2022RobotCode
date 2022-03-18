// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriverControl.DriveType.ArcadeDrive;
import frc.robot.commands.DriverControl.DriveType.TankDrive;
import frc.robot.commands.DriverControl.DeployIntake;
import frc.robot.commands.DriverControl.SendBallToShooter;
import frc.robot.commands.DriverControl.setShooterMotors;
import frc.robot.commands.DriverControl.liftControl.setLiftAngle;
import frc.robot.commands.DriverControl.liftControl.setLiftPos;
import frc.robot.commands.autonomous.GroupCommands.SimpleAuto;
import frc.robot.subsystems.Air_Systems;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift_systems.Elli;
import frc.robot.subsystems.Shooter_systems.BeamBreaks;
import frc.robot.subsystems.Shooter_systems.BeltSystem;
import frc.robot.subsystems.Shooter_systems.FlyWheel;
import frc.robot.subsystems.Shooter_systems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Subsystems
  public final static DriveTrain m_driveTrain = new DriveTrain();
  public final static Elli m_lift = new Elli();
  public final static Intake m_intake = new Intake();
  public final static Air_Systems m_air_systems = new Air_Systems();
  public final static FlyWheel m_flyWheel = new FlyWheel();
  public final static BeltSystem m_Beltsystem = new BeltSystem();
  public final static BeamBreaks m_BeamBreaks = new BeamBreaks();

  //AutoCommands
  private final SimpleAuto m_auto = new SimpleAuto();

  

//Button Box
  public static Joystick BottonBox = new Joystick(Constants.BOTTON_BOX_PORT);

  public static JoystickButton REDR = new JoystickButton(BottonBox, 2);
  public static JoystickButton REDL = new JoystickButton(BottonBox, 1);
  public static JoystickButton BLUER = new JoystickButton(BottonBox, 4);
  public static JoystickButton BLUEL = new JoystickButton(BottonBox, 3);
  public static JoystickButton YELLOWR = new JoystickButton(BottonBox, 5);
  public static JoystickButton YELLOWL = new JoystickButton(BottonBox, 6);
  public static JoystickButton GREENR = new JoystickButton(BottonBox, 7);
  public static JoystickButton GREENL = new JoystickButton(BottonBox, 8);
  
//Controller
  public static Joystick XboxC = new Joystick(Constants.JOYSTICK_PORT);

  public static double getDeadZone (int axis){
    if (Math.abs(XboxC.getRawAxis(axis)) < 0.1) {
      return 0.0;
    } else {
      return XboxC.getRawAxis(axis);
    }
  }
  
  //Controller buttons
  public static JoystickButton AB = new JoystickButton(XboxC, 1);
  public static JoystickButton BB = new JoystickButton(XboxC, 2);
  public static JoystickButton XB = new JoystickButton(XboxC, 3);
  public static JoystickButton YB = new JoystickButton(XboxC, 4);
  public static JoystickButton LB = new JoystickButton(XboxC, 5);
  public static JoystickButton RB = new JoystickButton(XboxC, 6);
  public static JoystickButton HB = new JoystickButton(XboxC, 7);
  public static JoystickButton ZB = new JoystickButton(XboxC, 8);
  public static JoystickButton LJB = new JoystickButton(XboxC, 9);
  public static JoystickButton RJB = new JoystickButton(XboxC, 10);
  //Dpad
  public static POVButton up = new POVButton(XboxC, 0);
  public static POVButton right = new POVButton(XboxC, 90);
  public static POVButton down = new POVButton(XboxC, 180);
  public static POVButton left = new POVButton(XboxC, 270);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Button Box Configs
    //..........................................................................
    REDL.whenPressed(new DeployIntake(Constants.INNTAKE_SPEED, true));
    REDR.whenPressed(new DeployIntake(0.0, false));

    YELLOWR.whenPressed(new setLiftPos(0.0));
    YELLOWL.whenPressed(new setLiftPos(Constants.LIFT_MAX));

    BLUEL.whenPressed(new setLiftAngle(true));
    BLUER.whenPressed(new setLiftAngle(false));

    GREENL.whenPressed(new setShooterMotors(Constants.UNLOAD));
    GREENL.whenReleased(new setShooterMotors(0));
    
    GREENR.whenPressed(new setLiftPos(Constants.LIFT_MAX * 0.85));

    //Controller Configs
    //..........................................................................
    AB.whenPressed(new setLiftPos(0.0));
    YB.whenPressed(new setLiftPos(Constants.LIFT_MAX));
    
    XB.whenPressed(new DeployIntake(Constants.INNTAKE_SPEED, true));
    BB.whenPressed(new DeployIntake(0.0, false));

    LB.whenPressed(new SendBallToShooter());
    RB.whenPressed(new setShooterMotors(0.6));
    RB.whenReleased(new setShooterMotors(0.0));

    HB.whenPressed(new setLiftAngle(true));
    ZB.whenPressed(new setLiftAngle(false));

    up.whenPressed(new setShooterMotors(Constants.HIGH_GOAL));
    up.whenReleased(new setShooterMotors(0));

    down.whenPressed(new setShooterMotors(Constants.LOW_GOAL));
    down.whenReleased(new setShooterMotors(0));

    left.whenPressed(new setShooterMotors(Constants.UNLOAD));
    left.whenReleased(new setShooterMotors(0));

    RJB.whenPressed(new ArcadeDrive());
    LJB.whenPressed(new TankDrive());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_auto;
  }
}
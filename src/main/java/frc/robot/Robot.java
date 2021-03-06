// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.math.MathUtil;
// import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends TimedRobot {

  //Create WheelDrives for each wheel
  //Parameters to pass are angle motor, speed motor, and angle encoder value for each wheel
  private WheelDrive backRight = new WheelDrive (6, 7, 3);
  private WheelDrive backLeft = new WheelDrive (0, 1, 0);
  private WheelDrive frontRight = new WheelDrive (4, 5, 2);
  private WheelDrive frontLeft = new WheelDrive (2, 3, 1);

  //private Joystick joystick = new Joystick (0); //!!May be redundant!!

  private SwerveDrive swerveDrive = new SwerveDrive (backRight, backLeft, frontRight, frontLeft);


   private XboxController joystick = new XboxController(0);
  // private final Drivetrain m_swerve = new Drivetrain();

  // // Slew rate limiters to make joystick inputs more gentle; 1/3 sec from 0 to 1.
  // private final SlewRateLimiter m_xspeedLimiter = new SlewRateLimiter(3);
  // private final SlewRateLimiter m_yspeedLimiter = new SlewRateLimiter(3);
  // private final SlewRateLimiter m_rotLimiter = new SlewRateLimiter(3);

  @Override
  public void autonomousPeriodic() {
    // driveWithJoystick(false);
    // m_swerve.updateOdometry();
  }

  @Override
  public void teleopPeriodic(){
    /** 
    Swerve Drive
    Uses 2 joysticks - "strafing" and "rotating"
    "Strafing" controls forward, backward, and lateral movement
    "Rotating" controls robot's angle
    For swerveDrive.drive, pass in the x and y value of the strafing joystick as well as the x value of the rotating joystick
    **/
    swerveDrive.drive (joystick.getX(Hand.kLeft), joystick.getY(Hand.kLeft), joystick.getX(Hand.kRight));
    //driveWithJoystick(true);
  }
 
   


  // private void driveWithJoystick(boolean fieldRelative) {
  //   // Get the x speed. We are inverting this because Xbox controllers return
  //   // negative values when we push forward.
  //   final var xSpeed = -m_xspeedLimiter.calculate(MathUtil.applyDeadband(m_controller.getLeftY(), 0.02)) * Drivetrain.kMaxSpeed;

  //   // Get the y speed or sideways/strafe speed. We are inverting this because
  //   // we want a positive value when we pull to the left. Xbox controllers
  //   // return positive values when you pull to the right by default.
  //   final var ySpeed = -m_yspeedLimiter.calculate(MathUtil.applyDeadband(m_controller.getLeftX(), 0.02)) * Drivetrain.kMaxSpeed;
      
  //         }
        }

    
    // Get the rate of angular rotation. We are inverting this because we want a
    // positive value when we pull to the left (remember, CCW is positive in
    // mathematics). Xbox controllers return positive values when you pull to
    // the right by default.

    //fix this later 
  /*  final var rot =
        -m_rotLimiter.calculate(MathUtil.applyDeadband(m_controller.getRightX(), 0.02))
            * Drivetrain.kMaxAngularSpeed;

    m_swerve.drive(xSpeed, ySpeed, rot, fieldRelative);
  }
}
*/
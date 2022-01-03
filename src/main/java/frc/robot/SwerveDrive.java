package frc.robot;

import edu.wpi.first.wpilibj.Encoder;

public class SwerveDrive {

    public final double L = 7; //Length between each wheel axle
    public final double W = 13; //Width between each wheel axle

    private WheelDrive backRight;
    private WheelDrive backLeft;
    private WheelDrive frontRight;
    private WheelDrive frontLeft;

    public SwerveDrive (WheelDrive backRight, WheelDrive backLeft, WheelDrive frontRight, WheelDrive frontLeft){
        this.backRight = backRight;
        this.backLeft = backLeft;
        this.frontRight = frontRight;
        this.frontLeft = frontLeft;
    }
    
    
    /**  
    Parameters:
    x1 = strafing joystick x axis
    y1 = strafing joystick y axis
    x2 = rotation joystick x axis    
    **/
    public void drive (double x1, double y1, double x2) {
        double r = Math.sqrt ((L * L) + (W * W));
        y1 *= -1;

        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 - x2 * (W / r);

        /**
        Set up speeds for each motor
        Speeds here are between 0 and 1, transformations may be necessary depending on speed range of motors
        **/
        double backRightSpeed = Math.sqrt ((a * a) + (d * d));
        double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
        double frontRightSpeed = Math.sqrt ((b * b) + (c * c));
        double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));

        /** 
        Calculate wheel angles
        These will be in a range of -1 to 1, if you wish to turn this range into real degrees, multiply by 180
        **/
        double backRightAngle = Math.atan2 (a , d) / Math.PI;
        double backLeftAngle = Math.atan2 (a , c) / Math.PI;
        double frontRightAngle = Math.atan2 (b , d) / Math.PI;
        double frontLeftAngle = Math.atan2 (b , c) / Math.PI;

        //Call each wheel's drive method
        backRight.drive (backRightSpeed, backRightAngle);
        backLeft.drive (backLeftSpeed, backLeftAngle);
        frontRight.drive (frontRightSpeed, frontRightAngle);
        frontLeft.drive (frontLeftSpeed, frontLeftAngle);
    }

}
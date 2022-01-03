package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWMTalonFX;
import edu.wpi.first.wpilibj.controller.PIDController;

public class WheelDrive{ 
    private PWMVictorSPX angleMotor;
    private PWMTalonFX speedMotor;
    private PIDController pidController;

    private final double MAX_VOLTS = 4.95;//!!IMPORTANT!! Set this equal to the maximum voltage the swerve module takes

    public WheelDrive(int angleMotor, int speedMotor, int encoder){
        this.angleMotor = new PWMVictorSPX(angleMotor);
        this.speedMotor = new PWMTalonFX(speedMotor);
        pidController = new PIDController(1, 0, 0);

        pidController.enableContinuousInput(-1, 1);
    }

    public void drive (double speed, double angle){
        speedMotor.set(speed);

        double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5);// Optimization offset can be calculated here.
        if (setpoint < 0){
            setpoint = MAX_VOLTS + setpoint;
        }
        if (setpoint > MAX_VOLTS){
            setpoint = setpoint - MAX_VOLTS;
        }

        pidController.setSetpoint(setpoint);
    }
}

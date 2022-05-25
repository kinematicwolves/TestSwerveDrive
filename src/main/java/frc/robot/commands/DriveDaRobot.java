package frc.robot.commands;

import java.sql.DriverAction;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDaRobot extends CommandBase {
    
    private final Drivertrain m_drivetrain;
    private final XboxController m_driverController;

    public DriveDaRobot(Drivetrain drivetrain, XboxController driverController) {
        m_drivetrain = drivetrain;
        addRequirements(m_drivetrain);
        m_driverController = driverController;
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_drivetrain.Drive(m_driverController);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}

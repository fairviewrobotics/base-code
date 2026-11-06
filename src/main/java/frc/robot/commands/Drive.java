package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;

import java.util.function.DoubleSupplier;

public class Drive extends Command {
    private final Tank tank;
    private final DoubleSupplier driveVolts, turnVolts;
    public Drive(Tank tank, DoubleSupplier driveVolts, DoubleSupplier turnVolts) {
        this.tank = tank;
        this.driveVolts = driveVolts;
        this.turnVolts = turnVolts;

        addRequirements(tank);
    }

    @Override
    public void execute() {
        double driveV = driveVolts.getAsDouble();
        double turnV = turnVolts.getAsDouble();

        driveV = MathUtil.applyDeadband(driveV, 0.1);
        turnV = MathUtil.applyDeadband(turnV, 0.1);

        driveV = Math.min(driveV, 2);
        turnV = Math.min(turnV, 2);

        tank.drive(driveV, turnV);
    }

    @Override
    public void end(boolean interrupted) {
        tank.drive(0, 0);
    }
}

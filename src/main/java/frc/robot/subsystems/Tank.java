package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;



public class Tank extends SubsystemBase {
    private SparkMax left1 = new SparkMax(0, SparkLowLevel.MotorType.kBrushless);
    private SparkMax left2 = new SparkMax(0, SparkLowLevel.MotorType.kBrushless);
    private SparkMax right1 = new SparkMax(0, SparkLowLevel.MotorType.kBrushless);
    private SparkMax right2 = new SparkMax(0, SparkLowLevel.MotorType.kBrushless);

    public void runLeft1Volts(double volts) {
        left1.setVoltage(volts);
    }

    public void runLeft2Volts(double volts) {
        left2.setVoltage(volts);
    }

    public void runRight2Volts(double volts) {
        right2.setVoltage(volts);
    }

    public void runRight1Volts(double volts) {
        right1.setVoltage(volts);
    }

    public void drive(double driveVolts, double turnVolts) {
        double RightVolts = -driveVolts - turnVolts;
        double LeftVolts = driveVolts - turnVolts;

        right1.setVoltage(RightVolts);
        right2.setVoltage(RightVolts);

        left1.setVoltage(LeftVolts);
        left2.setVoltage(LeftVolts);
    }
}

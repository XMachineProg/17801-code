package org.firstinspires.ftc.teamcode.loopController;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDController {
    private double Kp, Ki, Kd;   // Ki, Kd and Kp
    private int targetPosition;  // Target position
    private int currentPosition; // Current position
    private double integralSum = 0; // The integral of the errors over time

    private boolean firstDice = true;

    public double getDerivative() {
        int lastError = getError();
        return (getError() - lastError) / new ElapsedTime().milliseconds();
    }
    public double getIntegralSum() {
        integralSum = integralSum + (getError() * new ElapsedTime().milliseconds());
        return integralSum;
    }
    public double dice() { // The output of the PID

        return (getError() * getKp()) + (getIntegralSum() * getKi()) + (getDerivative() * getKd());
    }
    public int getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(int newCurrentPosition) {
        currentPosition = newCurrentPosition;
    }
    public int getTargetPosition() {
        return targetPosition;
    }
    public void setTargetPosition(int targetPosition) {
        this.targetPosition = targetPosition;
    }
    public double getKd() {
        return Kd;
    }
    public double getKp() {
        return Kp;
    }
    public double getKi() {
        return Ki;
    }
    public void setKd(double kd) {
        Kd = kd;
    }

    public void setKi(double ki) {
        Ki = ki;
    }

    public void setKp(double kp) {
        Kp = kp;
    }
    private int getError() {
        return getTargetPosition() - getCurrentPosition();
    }

    public PIDController(double Kp, double Ki, double Kd) {
        this.Kd = Kd;
        this.Ki = Ki;
        this.Kp = Kp;
    }
}

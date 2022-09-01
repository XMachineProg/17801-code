package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class Robot {
    private HardwareMap hwMap;

    public SampleMecanumDrive drive;

    public Robot(HardwareMap hwMap) {
        this.hwMap = hwMap;
         drive = new SampleMecanumDrive(hwMap);
    }

    protected void init() {

    }

    public void moveMecanumWheels(Gamepad gamepad1) {
        drive.setWeightedDrivePower(
                new Pose2d(
                        -gamepad1.left_stick_y,
                        -gamepad1.left_stick_x,
                        -gamepad1.right_stick_x
                )
        );

        drive.update();
    }
}

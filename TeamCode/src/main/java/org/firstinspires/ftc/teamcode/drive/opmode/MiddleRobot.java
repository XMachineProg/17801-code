package org.firstinspires.ftc.teamcode.drive.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Bruno robot", group = "test")
public class MiddleRobot extends LinearOpMode {

    DcMotor firstMainMotor = null;
    DcMotor secondMainMotor = null;
    DcMotor midMotor = null;
    DcMotor duckMotor = null;

    @Override
    public void runOpMode() throws InterruptedException {
        firstMainMotor = hardwareMap.get(DcMotor.class, "leftFront");
        secondMainMotor = hardwareMap.get(DcMotor.class, "rightFront");
        midMotor = hardwareMap.get(DcMotor.class, "leftRear");

        duckMotor = hardwareMap.get(DcMotor.class,"DuckMotor");

        waitForStart();
        while (opModeIsActive()) {
            double mainWheel = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double midWheel = gamepad1.left_stick_y - gamepad1.left_stick_x;
            firstMainMotor.setPower(mainWheel);
            secondMainMotor.setPower(mainWheel);
            midMotor.setPower(midWheel);

        }
    }
}

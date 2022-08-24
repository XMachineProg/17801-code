package org.firstinspires.ftc.teamcode.servers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Autonomous
public class LinearServer extends LinearOpMode {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startServer(int port) {
        try {

            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            } else {
                out.println("unrecognised greeting");
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void stopServer() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        startServer(666);
        while (opModeIsActive()) {
            if (isStopRequested()) {
                stopServer();
            }
        }


    }
}

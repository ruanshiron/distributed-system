package com.hust.soict.vinh.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9898);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(in.readLine());
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter array: ");
            String input = scanner.nextLine();
            System.out.println(input);
            if (input == null || input.isBlank()){
                System.out.println("Finish!");
                break;
            }else {
                out.println(input);
                System.out.println("Sorted Array:" +in.readLine());
            }
        }
        socket.close();
        scanner.close();
    }
}

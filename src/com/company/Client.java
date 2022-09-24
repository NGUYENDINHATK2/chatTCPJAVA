package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000)){
            System.out.println("Connected to server");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;
            String clientName = "empty";
            ClientThread thread = new ClientThread(socket);
            thread.start();
            do{
                if(clientName.equals("empty")){
                    System.out.println("Enter your name: ");
                    echoString = scanner.nextLine();
                    clientName = echoString;
                    output.println(echoString);
                    if(echoString.equals("exit")){
                        break;
                    }
                }
                else {
                    String mess = ("(" + clientName + "): ");
                    System.out.println("Enter message: ");
                    echoString = scanner.nextLine();
                    output.println(mess + echoString);
                    if(echoString.equals("exit")){
                        break;
                    }
                }
            }while (!echoString.equals("exit"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader reader;

    public ClientThread(Socket s) throws IOException {
        this.socket = s;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true){
                String message = reader.readLine();
                if (message == null){
                    break;
                }
                System.out.println(message +"eeeeeeeeee");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String showmes(){
        String message = null;
        try {
            message = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
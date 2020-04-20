package com.fly.ops.agent;

import com.fly.ops.socket.SocketClient;
import com.fly.ops.socket.SocketServer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @Classname MyAgent
 * @Description
 * @Date 2020/4/20
 * @Created by luox
 */
public class MyAgent {

    public static void agentmain(String args, Instrumentation inst) throws IOException {
        System.out.println("Agent is working ----------------: " + args);
        try {
            SocketServer.initSocketServer();
            System.out.println("------------------client working-----------------");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

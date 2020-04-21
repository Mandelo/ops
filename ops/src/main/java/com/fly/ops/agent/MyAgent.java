package com.fly.ops.agent;

import com.fly.ops.socket.SocketClient;
import com.fly.ops.socket.SocketServer;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

/**
 * @Classname MyAgent
 * @Description 系统运行探针
 * @Date 2020/4/20
 * @Created by luox
 */
public class MyAgent {

    public static void agentmain(String args, Instrumentation inst) throws IOException {
        System.out.println("Agent is working ----------------: " + args);
        try {
            Thread server = new Thread(new SocketServer(8087));
            server.start();
//            Thread client = new Thread(new SocketClient(8087,"[系统信息获取线程]"));
//            client.start();
            System.out.println("------------------client working-----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

package com.fly.ops.socket;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;

/**
 * @Classname SocketClient
 * @Description
 * @Date 2020/4/20
 * @Created by luox
 */
@Component
public class SocketClient {

    public static void initClient() throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);  //超时时间

        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 8082), 3000);

        System.out.println("已发起链接");
        System.out.println("客户端,IP:" + socket.getLocalAddress() + ",port:" + socket.getLocalPort());
        System.out.println("服务器,IP:" + socket.getInetAddress() + ",port:" + socket.getPort());

        try {
            todo(socket);
        } catch (IOException e) {
            System.out.println("出现异常");
        } finally {
            socket.close();
            System.out.println("客户端退出");
        }
    }

    private static void todo(Socket socket) throws IOException{
        InputStream in = System.in;
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        //得到Socket输出流，并转换为打印流
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        //获取Socket的输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;
        do {
            String s = input.readLine();    //获取键盘输入
            printStream.println(s);         //打印流打印键盘输入

            String back = bufferedReader.readLine();        //获取服务端的返回结果    获取服务端的返回结果就是获取服务端输入给客户端的消息，所以用输入流
            if("bye".equals(back)){
                flag = false;
            }
            System.out.println(back);
        } while (flag);

        printStream.close();
        bufferedReader.close();
    }
}

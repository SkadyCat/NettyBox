package com.netty;

import com.sun.javafx.collections.MappingChange;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private  final int port ;
    public  App(int port)
    {

        this.port = port;
    }

    public static void main( String[] args ) throws  Exception
    {

        System.out.println( "Hello World!" );

        int port = 9989;
        new App(port).start();
    }





    public  void start() throws  Exception{


        EventLoopGroup group = new NioEventLoopGroup(

        );
        try{
            ServerBootstrap b = new ServerBootstrap();

            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            EchoServerHandler serverHandler = new EchoServerHandler();
                            socketChannel.pipeline().addLast(serverHandler);



                            System.out.println("有一个链接进入！");

                        }
                    });
            ChannelFuture f  = b.bind().sync();
            f.channel().closeFuture().sync();
        }finally {

            group.shutdownGracefully().sync();
        }


    }
}

package com.netty;

import com.netty.OPStrategy.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;


@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    public ChannelHandlerContext context;
    public  static HashMap<String,EchoServerHandler> serverHandlerHashMap = new HashMap<String,EchoServerHandler>();
    public String handlerID;

    public  String getID(){


        Random random = new Random();

        String value = "";


        for (int i =0;i<10;i++)
        {
            value += ""+Math.abs( random.nextInt()%10);

        }

        this.handlerID = value;
        this.context.writeAndFlush(this.handlerID.getBytes());
        this.context.flush();

        System.out.println(value);
        return  this.handlerID;

    }
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        Random random = new Random();
        this.context = ctx;
        serverHandlerHashMap.put( this.getID(),this);


        
    }

    byte[] buffer = new byte[1024];


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf)msg;
        byte[] req = new byte[in.readableBytes()];
        in.readBytes(req);
        OPStrategy strategy = null;

        switch (req[0])
        {
            case 0:


                strategy = new OP_0();
                break;

            case  1:
                strategy = new OP_1();
                break;

            case  2:

                strategy = new OP_2();
                break;

            case  3:
                strategy = new OP_3();
                break;

            case  126:

                strategy = new OP_126();
                break;



            case 127:
                strategy = new
                        OP_127();
                break;
        }

        if (strategy!= null)
        {
            strategy.doSomething(this,req);

        }else
        {

            System.out.println("stratygy为空");
        }


        strategy = null;

    }



    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

       // ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

        System.out.println("异常处理");
        ctx.close();

    }
}


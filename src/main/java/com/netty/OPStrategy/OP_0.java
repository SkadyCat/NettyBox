package com.netty.OPStrategy;

import com.netty.EchoServerHandler;
import com.netty.Tool.ClientTool;
import com.netty.Tool.DataModel;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;

public class OP_0  extends OPStrategy{

    DataModel model ;


    int index =0;
    @Override
    public void doSomething(EchoServerHandler handler, byte[] data) {
        model = ClientTool.analysis(data);
        switch (model.subCode)
        {

            case 0:
                index++;

                System.out.println("请求获取当前的随机ID");
                handler.context.writeAndFlush(Unpooled.copiedBuffer(getSendModel((byte)0,(byte
                        )1,handler.handlerID,new ArrayList<Float>())));
               // handler.context.writeAndFlush(Unpooled.copiedBuffer((handler.handlerID).getBytes()));

                //getSendModel
                //System.out.println(model.toString()+"<><>"+index);

                break;


            case  1:

                break;

            case 3:



                break;


            default:

                break;
        }
    }
}

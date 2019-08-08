package com.netty.OPStrategy;

import com.netty.BattleGround.BattleGround;
import com.netty.EchoServer;
import com.netty.EchoServerHandler;
import com.netty.Tool.ClientTool;
import com.netty.Tool.DataModel;
import io.netty.buffer.Unpooled;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.xml.crypto.Data;

public abstract class OPStreategyEX extends  OPStrategy {
    public DataModel model;
    public EchoServerHandler handler;
    @Override
    public void doSomething(EchoServerHandler handler, byte[] data) {
        this.handler = handler;
          model = ClientTool.analysis(data);

        doSomething(model.subCode);


    }

    public  abstract  void  doSomething(byte subCode);

    public void broadCast(byte[] data)
    {
        for (EchoServerHandler handler: EchoServerHandler.serverHandlerHashMap.values()
             ) {

            handler.context.writeAndFlush(Unpooled.copiedBuffer(data));

        }

    }
    public void broadCast(BattleGround ground, byte[] data)
    {
        for (EchoServerHandler handler: ground.battleGroundMap.values()
        ) {
            if(handler!= null)
            handler.context.writeAndFlush(Unpooled.copiedBuffer(data));

        }

    }

    public  void  SingleSend(String strValue,int mainCode,int subCode)
    {

        byte[] md = getSendModel(mainCode,subCode,strValue);
        handler.context.writeAndFlush(Unpooled.copiedBuffer(md));



    }


}

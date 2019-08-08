package com.netty.OPStrategy;

import com.netty.EchoServerHandler;
import io.netty.buffer.Unpooled;
import javafx.embed.swt.SWTFXUtils;

///玩家交流
public class OP_1 extends  OPStreategyEX {


    @Override
    public void doSomething(byte subCode) {
        switch (subCode)
        {
            case 0:

                System.out.println(handler.handlerID+":"+model.strData);

                for (EchoServerHandler han : EchoServerHandler.serverHandlerHashMap.values()
                     ) {
                    han.context.writeAndFlush(Unpooled.copiedBuffer(getSendModel(1,1,handler.handlerID+":"+model.strData)));
                }
                break;

        }
    }
}

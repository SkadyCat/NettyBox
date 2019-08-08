package com.netty.OPStrategy;

import com.netty.BattleGround.BattleManager;
import com.netty.EchoServerHandler;
import javafx.embed.swt.SWTFXUtils;

public class OP_127 extends OPStreategyEX{
    @Override
    public void doSomething(byte subCode) {
        switch (subCode)
        {
            case 0:

                EchoServerHandler.serverHandlerHashMap.remove(handler.handlerID);
                BattleManager.logOutBattleRoom(handler.handlerID);
                handler.context.close();
                System.out.println("关闭该链接");

                break;

        }
    }
}

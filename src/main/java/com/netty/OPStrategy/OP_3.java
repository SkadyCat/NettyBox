package com.netty.OPStrategy;

import com.netty.BattleGround.BattleGround;
import com.netty.BattleGround.BattleManager;
import javafx.embed.swt.SWTFXUtils;
import org.bouncycastle.jcajce.provider.symmetric.CAST5;

public class OP_3 extends OPStreategyEX {

    BattleGround bgd = null;
    @Override
    public void doSomething(byte subCode) {
        switch (subCode)
        {
            case 0:

                broadCast(BattleManager.battleMap.get(model.strData),
                        getSendModel(3,0,BattleManager.getRoomAllPlayerID(BattleManager.battleMap.get(model.strData))));

                break;

            case  1:

                //System.out.println("接受到的float数据= "+model.floatListConvertString());
                bgd = BattleManager.getBattleGroundByPlayerID(handler.handlerID);
                if (bgd!= null)
                {
                    broadCast(bgd,model.data);
                }


                break;

            case 2:
                bgd = BattleManager.getBattleGroundByPlayerID(handler.handlerID);
                if (bgd!= null)
                {
                    broadCast(bgd,getSendModel(3,2,handler.handlerID,model.floatList));
                }

                break;

                default:
                    break;

        }
    }
}

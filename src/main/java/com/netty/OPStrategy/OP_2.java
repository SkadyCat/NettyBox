package com.netty.OPStrategy;

import com.netty.BattleGround.BattleGround;
import com.netty.BattleGround.BattleManager;
import org.bouncycastle.jcajce.provider.symmetric.CAST5;

public class OP_2 extends OPStreategyEX {

    BattleGround bgd = null;
    @Override
    public void doSomething(byte subCode) {

        String battleMapList = "";

        switch (subCode) {
            case 0:

                BattleManager.logOutBattleRoom(handler.handlerID);
               BattleGround ground = BattleManager.InsNewBattleGround(handler.handlerID);
               ground.add2BattleGround(this.handler.handlerID,this.handler);

                battleMapList = "";
                for (String gd: BattleManager.battleMap.keySet()
            ) {
                battleMapList+= gd+"&";
            }
                //battleMapList+= "*"+BattleManager.battleMasterMap.get(handler.handlerID)+"*";
                broadCast(getSendModel(2,1,battleMapList));
                break;

            case 1:
                battleMapList = "";
                for (String gd: BattleManager.battleMap.keySet()
                     ) {
                    battleMapList+= gd+"&";
                }

                SingleSend(battleMapList,2,1);
                break;

            case  2:

                System.out.println("加入房间 = "+model.strData);
                BattleGround bg = BattleManager.add2Room(model.strData,this.handler.handlerID,this.handler);


                broadCast(BattleManager.battleMap.get(model.strData),getSendModel(2,2,BattleManager.getRoomAllPlayerID(bg)));



                break;

            case 3:

                if (BattleManager.battleMasterMap.containsKey(model.strData)){
                SingleSend(BattleManager.getRoomID(handler.handlerID),2,3);


            }

                break;


            case 4:

                bgd = BattleManager.battleMap.get(model.strData);
                broadCast(bgd,getSendModel(2,
                        4,BattleManager.getRoomAllPlayerID(bgd)));

                break;


            default:

                break;

        }
    }
}

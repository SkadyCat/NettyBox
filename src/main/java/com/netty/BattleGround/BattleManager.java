package com.netty.BattleGround;

import com.netty.EchoServerHandler;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Random;
import java.util.logging.Handler;

public class BattleManager {

    public static HashMap<String ,BattleGround> battleMap = new HashMap<String,BattleGround>();

    public static HashMap<String,String> battleMasterMap = new HashMap<String, String>();

    public static HashMap<String,String> player2BattleGroundMap = new HashMap<String, String>();



    public static BattleGround getBattleGroundByPlayerID(String ID)
    {

        return battleMap.get(player2BattleGroundMap.get(ID));


    }
    public static BattleGround InsNewBattleGround(String creator) {
        String randomID = "";

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randomID += Math.abs(random.nextInt() % 10);

        }
        BattleGround ground = new BattleGround();
        ground.ID = randomID;
        battleMap.put(randomID, ground);

        battleMasterMap.put(creator,ground.ID);
        return ground;
    }

    public static String getRoomAllPlayerID(BattleGround gd)
    {
        String value = "";

        for (String key: gd.battleGroundMap.keySet()
             ) {
            value += key+"&";

        }
        return  value;

    }
    public static BattleGround add2Room(String roomID, String playerID, EchoServerHandler handler){

        battleMap.get(roomID).battleGroundMap.put(playerID,handler);
        player2BattleGroundMap.put(playerID,roomID);
        return battleMap.get(roomID);

    }

    public static String getRoomID(String creatID)
    {
        if(battleMasterMap.containsKey(creatID))
        {

            return battleMasterMap.get(creatID);
        }
        return "none";

    }
    public static void logOutBattleRoom(String createrID)
    {
        if(battleMasterMap.containsKey(createrID) == true)
        {
            battleMap.remove(battleMasterMap.get(createrID));
            battleMasterMap.remove(createrID);

        }



    }

}

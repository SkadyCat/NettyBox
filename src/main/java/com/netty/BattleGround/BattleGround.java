package com.netty.BattleGround;

import com.netty.EchoServerHandler;
import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;

public class BattleGround {
    public HashMap<String, EchoServerHandler> battleGroundMap;
    public String ID;
    public BattleGround()
    {
        battleGroundMap = new HashMap<String,EchoServerHandler>();


    }

    public void  add2BattleGround(String ID,EchoServerHandler handler)
    {
        battleGroundMap.put(ID,handler);


    }

    public  void  removeFromBattleGround(String ID){

        battleGroundMap.remove(ID);

    }



}

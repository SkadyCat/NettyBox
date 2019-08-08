package com.netty.OPStrategy;

import com.netty.EchoServerHandler;
import com.netty.Tool.DataModel;
import io.netty.channel.ChannelHandlerContext;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

public abstract class OPStrategy {

    public abstract void doSomething(EchoServerHandler handler, byte[] data);
    public byte[] getSendModel(int mainCode, int subCode, String strData,  ArrayList<Float> floatList)
    {

        DataModel md = new DataModel((byte)mainCode,(byte)subCode,strData,floatList);

        return  md.data;
    }


    public byte[] getSendModel(int mainCode, int subCode, String strData)
    {

        DataModel md = new DataModel((byte)mainCode,(byte)subCode,strData,new  ArrayList<Float> ());

        return  md.data;
    }
}

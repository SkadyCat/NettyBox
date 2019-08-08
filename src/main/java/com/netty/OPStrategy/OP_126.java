package com.netty.OPStrategy;

import javafx.embed.swt.SWTFXUtils;

public class OP_126 extends OPStreategyEX {

    static  int index = 0;
    @Override
    public void doSomething(byte subCode) {
        switch (subCode)
        {

            case 0:
                System.out.println(index+"==");
                SingleSend(index+"",126,0);
                index++;
                break;

                default:

                    break;
        }
    }
}

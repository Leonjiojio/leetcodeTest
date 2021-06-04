package com.sinovoice.lib.design.stragety;

/**
 * Created by  on 2021/6/4.
 **/
public class Xiaomin {
    public void getSomeFun(People [] peoples){
        FunActivity funActivity=null;
        switch (peoples.length){
            case 2:
                funActivity=new Sauna();
                break;
            case 5:
                funActivity=new PlayDota();
                break;
            default:
                funActivity=new Karaoke();
                break;
        }
        funActivity.haveFun(peoples);
    }
}

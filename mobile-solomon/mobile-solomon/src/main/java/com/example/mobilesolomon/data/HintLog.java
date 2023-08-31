package com.example.mobilesolomon.data;

import com.example.mobilesolomon.service.HintService;

public class HintLog {

    private String hint_madeByGPT;
    /*
    HintServiceクラスで返ってきたdataを
    ここで受け取り、ここからゲッターを使ってプレゼンテーション層までもってく
     */

//    public HintLog() {
//        HintService hintService = new HintService();
//        this.hint_madeByGPT = hintService.HintService();
//
//    }

    // geter


    public String getHint_madeByGPT() {
        return hint_madeByGPT;
    }
}

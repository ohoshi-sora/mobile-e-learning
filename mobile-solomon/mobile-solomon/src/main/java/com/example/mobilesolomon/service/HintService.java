package com.example.mobilesolomon.service;

import com.example.mobilesolomon.data.HintApiReader;

public class HintService {
    private String API_KEY;
    private String prompt; // ChatGPTに送るプロンプト
    private String hint_madeByGPT; // ChatGPTから返ってきたヒント


    /*
　　ここでapiをたたく、
　　レスポンスをうけとる
 　　*/
    public String HintService() {
        HintApiReader apiReader = new HintApiReader();
        this.API_KEY = apiReader.getAPI_KEY();

        /*
        HintPromptMaker promptMaker = new HintPromptMaker();
        this.prompt = promptMaker.getPrompt();
        こんな感じで
         */

        //ここをかく　プロンプトは違うクラスで加工する？

        return hint_madeByGPT;
        // 作られたヒントをreturnすることで、hintLogクラスでこのクラスのインスタンスを使うことでデータをlogにいれて
        //そこからいろいろつかうようにする
    }




// debug用　APIキーがゲッターで呼び出せることを確認できた
//    public static void main(String[] args) {
//        HintAPIReader apiReader = new HintAPIReader();
//        System.out.println(apiReader.getAPI_KEY());
//    }


}

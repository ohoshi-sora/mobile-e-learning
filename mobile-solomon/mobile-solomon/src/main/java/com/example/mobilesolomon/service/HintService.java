package com.example.mobilesolomon.service;

import com.example.mobilesolomon.data.HintApiReader;
import com.google.gson.Gson;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import okhttp3.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class HintService {

    private String API_KEY;
    private String prompt; // ChatGPTに送るプロンプト
    private String hint_madeByGPT; // ChatGPTから返ってきたヒント


//　　ここでapiをたたく、レスポンスをうけとる
    public String HintService() {

        //　APIキーを取得している
        HintApiReader apiReader = new HintApiReader();
        String API_KEY = apiReader.getAPI_KEY();

        // ライブラリを利用して、インスタンスを生成
        final var service = new OpenAiService(API_KEY);

        // プロンプト
        String message = "やっぱり、冬の鍋はおいしいですね。";
        final var prompt = "The following is a conversation with an AI assistant. The assistant is helpful, creative, clever.\nHuman: " + message
                + "\nAI: ";

        // ここでリクエストをしている　生成された選択肢をListに格納している。
        final var completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(prompt)
                .maxTokens(256)
                .build();
        final var completionResult = service.createCompletion(completionRequest);
        final var choiceList = completionResult.getChoices();

        // 出力
        for (final CompletionChoice choice : choiceList) {
            System.out.println(choice);
        }



        return choiceList;
        // 作られたヒントをreturnすることで、hintLogクラスでこのクラスのインスタンスを使うことでデータをlogにいれて
        //そこからいろいろつかうようにする
    }


// debug用　APIキーがゲッターで呼び出せることを確認できた
//    public static void main(String[] args) {
//        HintApiReader apiReader = new HintApiReader();
//        System.out.println(apiReader.getAPI_KEY());
//    }
//
//    // debug用　コンソールにgptのレスポンスが表示されるはず
//    // できないいいいいいいいいいいいいい
//    public static void main(String[] args) {
//        HintService h = new HintService();
//        System.out.println(h.HintService());
//    }


}

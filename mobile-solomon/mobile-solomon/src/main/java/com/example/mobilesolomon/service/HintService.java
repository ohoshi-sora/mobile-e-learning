package com.example.mobilesolomon.service;

import com.example.mobilesolomon.data.HintApiReader;
import com.google.gson.Gson;
import okhttp3.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //System.out.println(API_KEY); debug


        /*
        HintPromptMaker promptMaker = new HintPromptMaker();
        this.prompt = promptMaker.getPrompt();
        こんな感じで
         */

        //ここをかく　プロンプトは違うクラスで加工する？
        this.prompt = "こんにちは、chatGPT。これはテストだよ。";

        // HTTPクライアントのやつ
        OkHttpClient client = new OkHttpClient();
        // json扱うためのインスタンス
        Gson gson = new Gson();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", this.prompt);
        requestBody.put("max_tokens", 100); //これはどうしましょう
        requestBody.put("n", 1); // これはなにかもわかんない
        requestBody.put("stop",null); // これもなんだろ
        requestBody.put("api_key", API_KEY);

        String jsonRequestBody = gson.toJson(requestBody);
        RequestBody body = RequestBody.create(jsonRequestBody, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci-codex/completions")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) {
                throw new IOException("Unexpected code" + response);
            }

            String jsonResponse = response.body().string();
            Map<String, Object> apiResponse = gson.fromJson(jsonResponse, Map.class);
            String generatedText = ((List<Map<String, Object>>) apiResponse.get("choices"))
                    .get(0)
                    .get("text")
                    .toString();
            System.out.println("Generated Text : " + generatedText);

            this.hint_madeByGPT = generatedText;

        } catch (IOException e) {
            e.printStackTrace();
        }



        return hint_madeByGPT;
        // 作られたヒントをreturnすることで、hintLogクラスでこのクラスのインスタンスを使うことでデータをlogにいれて
        //そこからいろいろつかうようにする
    }




// debug用　APIキーがゲッターで呼び出せることを確認できた
//    public static void main(String[] args) {
//        HintApiReader apiReader = new HintApiReader();
//        System.out.println(apiReader.getAPI_KEY());
//    }

    // debug用　コンソールにgptのレスポンスが表示されるはず
    // できないいいいいいいいいいいいいい
    public static void main(String[] args) {
        HintService h = new HintService();
        System.out.println(h.HintService());
    }

}

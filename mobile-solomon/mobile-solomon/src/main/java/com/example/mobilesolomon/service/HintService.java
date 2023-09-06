package com.example.mobilesolomon.service;

import com.example.mobilesolomon.data.HintApiReader;
import com.example.mobilesolomon.data.IHintLogRepository;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HintService implements IHintService {

    private IHintLogRepository hintLogRepos;

    private String API_KEY;
    private String prompt; // ChatGPTに送るプロンプト
    private String hint_madeByGPT; // ChatGPTから返ってきたヒント


//　　ここでapiをたたく、レスポンスをうけとる
    @Autowired
    public HintService(IHintLogRepository hintLogRepos) {
        this.hintLogRepos = hintLogRepos;
    }

    @Override
    public void register(int num, String question, String answer) {
        //　APIキーを取得している
        HintApiReader apiReader = new HintApiReader();
        String API_KEY = apiReader.getAPI_KEY();

        // ライブラリを利用して、インスタンスを生成
        final var service = new OpenAiService(API_KEY);

        // プロンプト
        HintPromptMaker promptMaker = new HintPromptMaker();
        this.prompt = "The following is a conversation with an AI assistant. The assistant is helpful, creative, clever.\nHuman: " + promptMaker.getPrompt()
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
            System.out.println("chatGPTが作ったヒント：" + choice.getText());
            hint_madeByGPT = choice.getText();
        }

        // データベースに保存
        int n = hintLogRepos.insert(num, question, answer, hint_madeByGPT);
        System.out.println("記録行数：" + n);
    }

//    @Override
//    public String getHint_madeByGPT() {
//        return hint_madeByGPT;
//    }

    // debug用　APIキーがゲッターで呼び出せることを確認できた
//    public static void main(String[] args) {
//        HintApiReader apiReader = new HintApiReader();
//        System.out.println(apiReader.getAPI_KEY());
//    }



}

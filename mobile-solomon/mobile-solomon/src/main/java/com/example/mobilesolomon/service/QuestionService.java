package com.example.mobilesolomon.service;

import com.example.mobilesolomon.data.ApiReader;
import com.example.mobilesolomon.data.ILogRepository;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 問題と解答、ヒントを入力したら似たような問題を自動生成してくれるシステム
@Service
public class QuestionService {

    private ILogRepository LogRepos;     // データベースを引っ張ってくる
    private String API_KEY;     // APIキー
    private String prompt;      // GPTに送信するprompt
    private String ReGPT;       // GPTから帰ってきたもの


    // 問題文と解答、ヒントをデータベースから引っ張り出す
    @Autowired
    public QuestionService(ILogRepository logRepos) {
        this.LogRepos = logRepos;
    }

    // 全体のメソッド
    public void probGene (int num, String question, String answer) {

        // APIキーの取得
        ApiReader apiReader = new ApiReader();
        String API_KEY = apiReader.getAPI_KEY();

        // ライブラリを利用して、インスタンスを生成
        final var service = new OpenAiService(API_KEY);

        // プロンプト関連をかく


        // APIを叩いているところ
        final var completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(prompt)
                .maxTokens(256)
                .build();
        final var completionResult = service.createCompletion(completionRequest);
        final var choiceList = completionResult.getChoices();

        // APIを叩いて帰ってきた文章を出力するところ
        for (final CompletionChoice choice : choiceList) {
            System.out.println("chatGPTが作った問題と解答、ヒント：" + choice.getText());
            ReGPT = choice.getText();
        }

        // データベースに出力されたものを収納
        // 複数の問題が出てきた場合の処理をどうするのか


    }

}

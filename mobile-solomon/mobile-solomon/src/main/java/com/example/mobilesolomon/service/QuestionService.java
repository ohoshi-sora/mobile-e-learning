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

    public void probGene (int num, String question, String answer) {

        // APIキーの取得
        ApiReader apiReader = new ApiReader();
        String API_KEY = apiReader.getAPI_KEY();

        // ライブラリを利用して、インスタンスを生成
        final var service = new OpenAiService(API_KEY);


    }

}

package com.example.mobilesolomon.service;

import com.example.mobilesolomon.presentation.HintMakerPage;

public class HintPromptMaker {

    private String prompt;
    private String userInput;

    public HintPromptMaker() {
        HintMakerPage hintMaker = new HintMakerPage();
        this.userInput = hintMaker.getQuestion();

        // プロンプトを変更するのはここ！
        this.prompt = "以下の問題のヒントを作成して\n" + userInput;

    }

    public String getPrompt() {
        return prompt;
    }
}

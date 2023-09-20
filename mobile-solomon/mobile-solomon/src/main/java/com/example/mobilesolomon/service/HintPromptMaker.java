package com.example.mobilesolomon.service;

import com.example.mobilesolomon.presentation.hint.HintMakerPage;

public class HintPromptMaker {

    private String prompt;


    public HintPromptMaker(String question, String option1, String option2, String option3, String option4, String answer) {

        // プロンプトを変更するのはここ！
        // 前提条件
        String dearGPT = "以下の問題は、中学生向けのプログラミングの考え方を学習する問題である。4個の選択肢があり、" +
                "その中の一つが正答である選択式の問題である。問題のヒントを三段階に分けて作成してください。なお、ヒントの三段階目は答えと解説とします。\n" +
                "フォーマットはヒント1つ目、ヒント2つ目、ヒント3つ目と表示してください。" +
                "";

        this.prompt = dearGPT +
                "問題：" + question +
                "\n選択肢：ア" + option1 +
                "\n選択肢：イ" + option2 +
                "\n選択肢：ウ" + option3 +
                "\n選択肢：エ" + option4 +
                "\n正解の選択肢：" + answer;

    }

    public String getPrompt() {
        return prompt;
    }
}

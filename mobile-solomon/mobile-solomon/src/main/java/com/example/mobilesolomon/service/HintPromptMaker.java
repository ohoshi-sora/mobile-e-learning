package com.example.mobilesolomon.service;

import com.example.mobilesolomon.presentation.hint.HintMakerPage;

public class HintPromptMaker {

    private String prompt;


    public HintPromptMaker() {
        HintMakerPage hintMaker = new HintMakerPage();
        String question = hintMaker.getQuestion();
        String option1 = hintMaker.getOption1();
        String option2 = hintMaker.getOption2();
        String option3 = hintMaker.getOption3();
        String option4 = hintMaker.getOption4();
        String answer = hintMaker.getAnswer();



        // プロンプトを変更するのはここ！
        this.prompt = "以下の問題は、中学生向けのプログラミングの考え方を学習する問題である。4個の選択肢があり、その中の一つが正答である選択式の問題である。以下の問題のヒントを三段階に分けて作成してください。なお、ヒントの三段階目は答えと解説とします。\n問題："
                + question + "\n選択肢：ア" + option1 + "\n選択肢：イ" + option2 + "\n選択肢：ウ" + option3 + "\n選択肢：エ" + option4
                + "\n正解の選択肢：" + answer;

    }

    public String getPrompt() {
        return prompt;
    }
}

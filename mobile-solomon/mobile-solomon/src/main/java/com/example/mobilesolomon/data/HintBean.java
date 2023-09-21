package com.example.mobilesolomon.data;

import java.io.Serializable;

public class HintBean implements Serializable {
    private static final long serialVersionUID = 1L;

    // メンバ変数
    private int num;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String hint;

    // 引数なしデフォルトコンストラクタ
    public HintBean(){}

    public int getNum() {
        return this.num;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }
}

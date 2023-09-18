package com.example.mobilesolomon.service;

public interface IHintService {
    public void register(String question, String opt1, String opt2, String opt3, String opt4, String answer);

    public String  selectHint();

    //String getHint_madeByGPT();
}

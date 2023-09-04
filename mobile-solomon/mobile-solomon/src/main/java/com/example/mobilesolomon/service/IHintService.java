package com.example.mobilesolomon.service;

public interface IHintService {
    public void register(int num, String question, String answer, String hint);

    String getHint_madeByGPT();
}

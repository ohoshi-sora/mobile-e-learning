package com.example.mobilesolomon.data;

public interface IHintLogRepository {
    /**
     * ユーザー名とパスワードをquestionテーブルに記録する
     *
     * @param num 通し番号
     * @param question 問題
     * @param answer 解答
     * @param hint ヒント
     * @return データベースの更新行数
     */
    public int insert(int num, String question, String answer, String hint);

}


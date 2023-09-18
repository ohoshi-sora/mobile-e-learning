package com.example.mobilesolomon.data;

public interface ILogRepository {
    /**
     * ---[questionテーブルに記録する]---
     *
     * @param num 通し番号
     * @param question 問題
     * @param answer 解答
     * @param hint ヒント
     * @return データベースの更新行数
     */
    public int insert(int num, String question, String opt1, String opt2, String opt3, String opt4,String answer, String hint);

    /**
     * ---[次に登録する通し番号を読み込む]---
     *
     * @return 通し番号の最後 + 1　の数字
     */
    public int selectMaxNum();

    /**
     *　---[削除する]---
     * @param num 通し番号
     * @return データベースの削除行数
     */
    public int delete(int num);

    /**
     * ---[ヒント修正をしたとき、更新する]---
     *
     * @param newHint 修正後のヒント
     * @param n 通し番号
     * @return ture:正常終了, false:エラー
     */
    public boolean update(String newHint, int n);

    /**
     * ---[通し番号から、カラム(question)を得る]---
     *
     * @param n 通し番号
     * @return question 問題文
     */
    //public String selectQuestion(int n);

    /**
     * ---[通し番号から、カラム（hint）を得る]---
     *
     * @param n 通し番号
     * @return hint ヒント String
     */
    public String selectHint(int n);


}


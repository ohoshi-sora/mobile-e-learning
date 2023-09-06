package com.example.mobilesolomon.data;

public interface ILogRepository {
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

    /**
     * 次に登録する通し番号を読み込む
     *
     * @return 通し番号の最後 + 1　の数字
     */
    public int selectMaxNum();

    /**
     *　削除する
     * @pram num 通し番号
     * @return データベースの削除行数
     */
    public int delete(int num);


}


package com.example.mobilesolomon.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository implements ILogRepository {

    // spring Frameworkのデータベース接続ライブラリを利用する
    private final JdbcTemplate jdbcTemplate;

    // Spring Frameworkのデータベース接続ライブラリを初期化する
    @Autowired
    public LogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(int num, String question, String opt1, String opt2, String opt3, String opt4, String answer, String hint) {
        var sql = "insert into hint values (?, ?, ?, ?, ?, ?, ?, ?)";
        var n = jdbcTemplate.update(sql, num, question, opt1, opt2, opt3, opt4, answer, hint);
        return n;
    }
    @Override
    public int selectMaxNum() {
        var sql = "select max(NUM) from hint";
        var n = jdbcTemplate.queryForObject(sql,Integer.class);
        if(n == null) {
            return 0;
        }else {
            return n;
        }
    }

    @Override
    public int delete(int num) {
        String sql = "DELETE FROM hint WHERE NUM = ?";
        int deletedRows = jdbcTemplate.update(sql, num);
        return deletedRows;
    }

    @Override
    public boolean update(String newHint, int n) {
        boolean ret = false; // 初期化
        var sql = "UPDATE SET HINT = ? WHERE NUM = ?";
        var updatedRow =jdbcTemplate.update(sql,newHint, n);
        if(updatedRow>0) ret = true;
        return ret;
    }


}

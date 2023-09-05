package com.example.mobilesolomon.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HintLogRepository implements IHintLogRepository{

    // spring Frameworkのデータベース接続ライブラリを利用する
    private final JdbcTemplate jdbcTemplate;

    // Spring Frameworkのデータベース接続ライブラリを初期化する
    @Autowired
    public HintLogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(int num, String question, String answer, String hint) {
        var sql = "insert into question values (?, ?, ?, ?)";
        var n = jdbcTemplate.update(sql, num, question,answer, hint);
        return n;
    }

}

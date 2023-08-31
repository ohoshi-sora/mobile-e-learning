package com.example.mobilesolomon.data;

import com.example.mobilesolomon.service.HintService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HintLog {

    // spring Frameworkのデータベース接続ライブラリを利用する
    private JdbcTemplate jdbcTemplate;

    // Spring Frameworkのデータベース接続ライブラリを初期化する
    public HintLog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}

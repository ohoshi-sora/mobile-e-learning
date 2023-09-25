package com.example.mobilesolomon.service;

import com.example.mobilesolomon.data.HintBean;
import com.example.mobilesolomon.data.ILogRepository;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    private static final long serialVersionUID = 1L;
    @SpringBean
    private ILogRepository logRepository;

    public List<HintBean> getData() {
        return logRepository.selectAllHintTable();
    }
}

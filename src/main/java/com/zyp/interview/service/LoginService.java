package com.zyp.interview.service;

import com.zyp.interview.mapper.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/18 14:57
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Transactional(rollbackFor = Exception.class)
    public void update() {
            loginMapper.update1();
            int i = 1 / 0;
            loginMapper.update2();
    }
}

package com.green.boardauth.application.user;

import com.green.boardauth.application.user.model.UserGetOneRes;
import com.green.boardauth.application.user.model.UserSignInReq;
import com.green.boardauth.application.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; //DI받아오기

    public int signUp(UserSignUpReq req) {
        String hashedPw = passwordEncoder.encode( req.getUpw() ); //hashPw가 날것의 pw(get으로 가져옴)를 받아서 가지고있으니
        log.info("hashedPw: {}", hashedPw);
        req.setUpw(hashedPw); //set 로 암호화된 hashPw값을 다시 req에 담아준다.
        return userMapper.signUp(req);
    }

    public int signIn(UserSignInReq req) {
        UserGetOneRes res = userMapper.findByUid( req.getUid() );
        log.info("res: {}", res);
        if (!passwordEncoder.matches( req.getUpw(), res.getUpw()) ) {
            return 0;
        }
        return 1;
    }
}
//인코더 디코더 암호화 복호화
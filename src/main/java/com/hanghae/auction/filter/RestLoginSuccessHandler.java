package com.hanghae.auction.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanghae.auction.dto.ResponseDto;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class RestLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
//        response.addHeader("JSESSIONID",httpSession.getId());
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Access-Control-Allow-Headers",
                "Date, Content-Type, Accept, X-Requested-With, Authorization, From, X-Auth-Token, Request-Id");
        response.setHeader("Access-Control-Expose-Headers", "Set-Cookie");
        response.setHeader("Access-Control-Allow-Credentials", "true");


        ResponseDto responseDto = new ResponseDto();

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            Users user = userRepository.findByUsername(username).orElse(null);

            if(user == null){
                responseDto.setResult(false);
                responseDto.setErr_msg("가입되지 않은 회원입니다");
            }else{
                responseDto.setResult(true);
                responseDto.setUsername(user.getUsername());
            }
        }

        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out, responseDto);
        out.flush();

    }
}

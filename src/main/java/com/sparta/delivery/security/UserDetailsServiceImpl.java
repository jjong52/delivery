package com.sparta.delivery.security;

import com.sparta.delivery.user.User;
import com.sparta.delivery.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 정보를 조회하여 UserDetails 객체를 반환
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + username));

        // 삭제된 유저 로그인 불가 처리
        if (user.isDeleted()) {
            throw new RuntimeException("User is deleted and cannot log in");
        }

        return new UserDetailsImpl(user);
    }
}
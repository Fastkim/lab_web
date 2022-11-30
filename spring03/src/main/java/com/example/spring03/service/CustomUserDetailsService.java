package com.example.spring03.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring03.domain.Member;
import com.example.spring03.dto.MemberSecurityDto;
import com.example.spring03.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        // DB Members 테이블에서 사용자 정보를 검색해서 UserDetails 타입의 객체 리턴.
        // -> MemberSecurityDto 타입 객체를 생성해서 리턴.
        // -> 일치하는 username(로그인 아이디)가 있으면 UserDetails 타입 (또는 하위 타입) 객체를 리턴.
        // -> 일치하는 username이 없으면 UsernameNotFoundException 예외를 발생.
        // -> 절대로 null을 리턴하면 안됨.
        
        Optional<Member> entity = memberRepository.findByUsername(username);
        if (entity.isPresent()) { // 로그인 아이디가 일치하는 엔터티가 있는 경우
            return MemberSecurityDto.fromEntity(entity.get());
        } else { // 해당 아이디 정보가 없는 경우
            throw new UsernameNotFoundException(username + ": not found!");
        }
        
    }

}

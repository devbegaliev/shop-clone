package com.example.shop_clone.configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service

public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenUtil tokenUtil;
    private final CustomUserDetailService customUserDetailService;

    public JwtTokenFilter(JwtTokenUtil tokenUtil, CustomUserDetailService customUserDetailService) {
        this.tokenUtil = tokenUtil;
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || header.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
        }

        String token = header.split(" ")[1];

        if (!tokenUtil.validate(token)) {
            filterChain.doFilter(request, response);
        }
        String username = tokenUtil.getUsername(token);
        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

    }
}

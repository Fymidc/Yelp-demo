package com.myplace.letsgo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myplace.letsgo.business.concretes.UserDetailServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserDetailServiceImp userDetailsService;

    //jwt auth mu 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            String jwtTojen = extractJwtFromRequest(request); 
            if(StringUtils.hasText(jwtTojen) && jwtTokenProvider.validateToken(jwtTojen)){
                Long id = jwtTokenProvider.getUserIdFromJwt(jwtTojen);
                UserDetails user = userDetailsService.loadUserById(id);
                if(user != null){
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    //localstorage sec bilgilerini tutar
                    SecurityContextHolder.getContext().setAuthentication(auth);

                }
            }
        }catch(Exception e){
            return;
        }
        //spring kendi filtrelerine devam edicek
        filterChain.doFilter(request, response);
        
    }

    private String extractJwtFromRequest(HttpServletRequest request){
        String bearer = request.getHeader("Authorization");
        if(StringUtils.hasText(bearer)&& bearer.startsWith("Bearer ")){
            return bearer.substring("Bearer".length()+1);
        }
        return null;
    }
    
}

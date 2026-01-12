package com.example.backQueerDataBase.Configuration;

import com.example.backQueerDataBase.Service.JwtService;
import com.example.backQueerDataBase.Service.UsersService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsersService usersService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        System.out.println("=== JWT Filter ===");
        System.out.println("Path: " + request.getRequestURI());
        System.out.println("Auth Header: " + authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String token = authHeader.substring(7);
                System.out.println("Token: " + token.substring(0, Math.min(20, token.length())) + "...");

                String email = jwtService.extractEmail(token);
                System.out.println("Email extrait: " + email);

                UserDetails user = usersService.loadUserByUsername(email);
                System.out.println("User trouvé: " + user.getUsername());

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("Auth OK!");
            } catch (Exception e) {
                System.out.println("Erreur JWT: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Pas de token Bearer");
        }

        filterChain.doFilter(request, response);
    }
}
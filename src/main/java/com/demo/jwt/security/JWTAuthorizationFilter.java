package com.demo.jwt.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ResourceProperties.Chain;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filter)
			throws ServletException, IOException {
		
		String jwt=request.getHeader(SecurityConstants.HEADER_STRING);
		 if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIXE)) {
			filter.doFilter(request, response); 
			return;
		 }
		 
		 Claims claims=Jwts.parser()
				 .setSigningKey(SecurityConstants.SECRET)
				 .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIXE, ""))
				 .getBody();
		 
		 String username=claims.getSubject();
		 ArrayList<Map<String,String>> roles = (ArrayList<Map<String,String>>)
				 claims.get("roles");
		 Collection<GrantedAuthority> authorities = new ArrayList<>();
		 roles.forEach(r->{
			 authorities.add(new SimpleGrantedAuthority(r.get("authority")));
		 });
		
		 UsernamePasswordAuthenticationToken authentificationUser=
				 new UsernamePasswordAuthenticationToken(username,null,authorities);
		 SecurityContextHolder.getContext().setAuthentication(authentificationUser);
		 filter.doFilter(request,response);
	}

	
}

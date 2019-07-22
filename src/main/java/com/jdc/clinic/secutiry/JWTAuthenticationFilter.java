package com.jdc.clinic.secutiry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jdc.clinic.secutiry.utils.SecurityParams;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*3");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requests-With, Content-Type,"
				+ "Access-Control-Request-Method, Access-Control-Request-Headers ,Authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials , Authorization");

		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			String jwtToken = request.getHeader(SecurityParams.JWT_HEADER_NAME);
			if (jwtToken == null || jwtToken.startsWith(SecurityParams.JWT_HEADER_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.JWT_SECRET)).build();
			String jwt = jwtToken.substring(SecurityParams.JWT_HEADER_PREFIX.length());
			DecodedJWT decodedJWT = verifier.verify(jwt);

			String username = decodedJWT.getSubject();
			List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(rolename -> {
				authorities.add(new SimpleGrantedAuthority(rolename));
			});
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null,
					authorities);
			SecurityContextHolder.getContext().setAuthentication(token);
			filterChain.doFilter(request, response);
		}

	}

}

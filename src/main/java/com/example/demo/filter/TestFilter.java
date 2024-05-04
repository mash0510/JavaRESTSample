package com.example.demo.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import com.example.demo.domain.BufferedServletRequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class TestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest wrappedRequest = new BufferedServletRequestWrapper((HttpServletRequest) request);
		
		BufferedReader br = new BufferedReader( new InputStreamReader(wrappedRequest.getInputStream()) );
		String jsonText = br.readLine();
		
		chain.doFilter(wrappedRequest, response);
		
	}

}

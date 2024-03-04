package com.example.practise.Filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingFilter extends OncePerRequestFilter {  /*Once per requst to get one at a time  */

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) /*to wrap my response and request and pass it through filter chain for my maintenace  */
            throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request); /*to wrap the request  */
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response); /*to wrap the response */

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(requestWrapper, responseWrapper);
        long timeTaken = System.currentTimeMillis() - startTime; /*this three lines of code is to determine the execution time */

        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
                request.getCharacterEncoding()); /*converts the bytecode to String  */

        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(), response.getCharacterEncoding()); /*converts the byte code to string */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        LOGGER.info(
            "FINISHED PROCESSING : METHOD={}; REQUESTERURI={}; REQUEST PAYLOAD={};RESPONSE CODE={};RESPONSE={};TIME TAKEN={}",
                request.getMethod(), request.getRequestURI(), requestBody, response.getStatus(), responseBody,
                timeTaken);
        responseWrapper.copyBodyToResponse();
    } /* The message to display in console is formatted in here  */

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } /* the method to convert the byte array to string  */
        return ""; /* incase the above case isnt working out an empty string is returned */
    }

}

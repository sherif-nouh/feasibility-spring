package com.feas.security.config;

/*
 * All application URI's will be added here then will be used in spring security context
 */
public interface ApplicationURI {

    // User controller URI's
    String LOGIN_RESOURCE = "/user/login";
    String REGISTER_RESOURCE = "/user/register";
    String CONTACT_US = "/dynamicContent/**";
    String MESSAGE_US = "/user/publicMessageUs";
    String ALL_LOOKUP = "/lookup/*";
    String BRANCHES="/branches/**";
    String DEPARTMENTS="/departments/**";
    String FILES="/files/**";
    String PROFILEPICURE="/user/profilePicture/**";


}

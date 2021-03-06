package forest.ori.parrot.security.config;

import forest.ori.parrot.common.annotation.AnonymousAccess;
import forest.ori.parrot.common.utils.JwtTokenUtils;
import forest.ori.parrot.security.service.SelfUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;  //  ?????????????????? JSON ???????????????????????????????????? html???

    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;  // ????????????????????? JSON ????????????????????????????????? html???

    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;  //  ????????????????????? JSON ????????????????????????????????? html???

    @Autowired
    AjaxLogoutSuccessHandler logoutSuccessHandler;  // ????????????????????? JSON ????????????????????????????????? ???????????? html???

    @Autowired
    AjaxAccessDeniedHandler accessDeniedHandler;    // ????????????????????? JSON ????????????????????????????????? 403 html ?????????

    @Autowired
    SelfUserDetailsService userDetailsService; // ?????????user

    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter; // JWT ?????????

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // ??????????????????????????????
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ?????????????????? url??? @AnonymousAccess
        RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) applicationContext.getBean("requestMappingHandlerMapping");
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        // ??????????????????
        Set<String> anonymousUrls = getAnonymousUrl(handlerMethodMap);
        // ?????? CSRF
        http
                //??????CSRF,?????????????????????
                .csrf().disable()
                //????????????
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint)
                //??????Iframe??????
                .and().headers().frameOptions().disable()
                //?????????session??????
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                //??????????????????
                .antMatchers(HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webSocket/**").permitAll()
                //????????????????????????????????????
                .antMatchers("/auth/**").permitAll()
                //??????Swagger??????
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                //??????druid?????????????????????
                .antMatchers("/druid/**").permitAll()
                // ??????OPTIONS??????
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // ??????AnonymousAccess ??????
                .antMatchers(anonymousUrls.toArray(new String[0])).permitAll()
                // ???????????????????????????
                .anyRequest().authenticated()
                .and().apply(new TokenConfigurer(jwtTokenUtils))
                //????????????
                .and().headers().cacheControl();

    }

    private Set<String> getAnonymousUrl(Map<RequestMappingInfo, HandlerMethod> handlerMethodMap) {
        Set<String> AnonymousUrls = new HashSet<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethodMap.entrySet()) {
            HandlerMethod handlerMethod = infoEntry.getValue();
            AnonymousAccess anonymousAccess = handlerMethod.getMethodAnnotation(AnonymousAccess.class);
            if (null != anonymousAccess) {
                AnonymousUrls.addAll(infoEntry.getKey().getPatternsCondition().getPatterns());
            }
        }
        return AnonymousUrls;
    }


    public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

        private final JwtTokenUtils jwtTokenUtils;

        public TokenConfigurer(JwtTokenUtils jwtTokenUtils) {

            this.jwtTokenUtils = jwtTokenUtils;
        }

        @Override
        public void configure(HttpSecurity http) {
            JwtAuthenticationTokenFilter customFilter = new JwtAuthenticationTokenFilter(jwtTokenUtils);
            http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }
}
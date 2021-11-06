package org.kpu.di.config;

import org.kpu.myweb.aop.MemberAspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
		
	@Bean
	public MemberAspect memberAspect() {
		return new MemberAspect();
	}
}
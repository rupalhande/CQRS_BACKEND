package com.Bank.BankService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtworks.xstream.XStream;
@Configuration
public class AxonConfiguration {
	@Bean
	public XStream mySecuredXStream() {
	    XStream xStream = new XStream();
	    xStream.allowTypesByWildcard(new String[]{"com.Bank.DTO.core.Events.**",
	    		                                  "com.Bank.BankService.Query.FindAllAccountsQuery",
	    		                                  "com.Bank.BankService.Entity.AccountsEntity"});
	    return xStream;
	}
}

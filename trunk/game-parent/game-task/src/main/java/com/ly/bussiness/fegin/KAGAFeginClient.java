package com.ly.bussiness.fegin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ly.bussiness.fegin.KAGAFeginClient.TestFeginClientHystrix;

@FeignClient(name = "GAME-SERVICE", fallback = TestFeginClientHystrix.class)
public interface KAGAFeginClient {
	@RequestMapping(value = "/kaga/load", method = RequestMethod.POST)
    String dataLoad();
	
	@Component
    static class TestFeginClientHystrix implements KAGAFeginClient {
		private final Logger logger =  LoggerFactory.getLogger(KAGAFeginClient.class);
    	@Override
        public String dataLoad() {
    		logger.info("服务[GAME-SERVICE]无法访问");
            return "服务[game-service test]无法访问";
        }
    }
}

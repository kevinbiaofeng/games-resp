package com.ly.service.remote;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

/**
 * AG 抓票
 * 
 * @author Administrator
 *
 */
@Service
public class AGBMEBetRemoteService extends BaseBetRemoteService {

	
	
	public String eGameFetch(String action, String billNo, String startDate, String endDate, String jsp) {
		String eGameIpPort = "def";
		String address = "http://" + eGameIpPort + "/AgReport/" + jsp + "?action=" + action + "&billno=" + billNo;
		try {
			if (startDate != null && endDate != null) {
				address += "&start=" + URLEncoder.encode(startDate, "UTF-8") + "&end="
						+ URLEncoder.encode(endDate, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = restTemplate.getForEntity(address, String.class).getBody();
		return result;
	}

}

package com.ly.service.remote.mv;

import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class ApiMW extends BaseDemo {
	
	private final static Logger logger =  LoggerFactory.getLogger(ApiMW.class);
	
	private static ApiMW instance = null;
	private static final String func_oauth = "oauth";// 授权 Oauth API
	private static final String func_domain = "domain";// domian API
	private static final String reqg_betLog = "siteUsergamelog";// 获取下注日志

	public static ApiMW getInstance() {
		if (instance == null) {
			instance = new ApiMW();
		}
		return instance;
	}
	// public static void main(String[] args) throws Exception {
	// siteId = "10007900";
	// MW_public_key =
	// "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDu8s2mNAVc3Nfb4jIZc0KCIRR5qyOj8cqE2Y1SBCB5h/3h4EdbCETeuxVfvsMhgJXPjJphNN2lovqh5GAiQLhrA5cT4KWPRaKBWDM6EJ6mw8+S0gqDUFZyRQv2AhiJYIinybfLecGkZpwQXuE70DV0IOpHK8ScIG36vy4lypCfywIDAQAB";
	// EC_private_key =
	// "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKHNzoWc9L3FjibzO+xK/DntYaqpfNGkILoNjZEJOQahpoZjxd1O9UD6ien9+Ox1OFD7KcFibxu3a9ARCx/WSeMqmAhPUAgML5b8yN8zH1MFG2oGZYX5UX+A9XqPZP/Wwf4YPT3pE/xQ+4rK/STV1aKvEd5lR2p54VcaKU/tdFn9AgMBAAECgYAck9PxB1q2lcjYmkcwIcJQnNuOH+c6w6lAExq4zg8zW6OkwsR0pPhuJJHtMP0hDkcHDoU+cZs8IvY4xnnXgqqD28jA9fvUBeh+hUaRQzaJvdg11MHyJXiegtOoCmTiFiaWCkaNLM87qwIuBCGbvBiTkNkDqpz1qYS58B6cianRxQJBANaREdKqhF88TKkxCbx15cycyyF8YPpDVlhGnf+XvhQ7QDvWUQH41AaYUdq6IpqPjMxJYPZtZxU2bVs74JSX5+sCQQDBDHQSKN1omTjQtHaFjPxUNTNdJEOvWidm3w5//XXjVSE76SNeN5xlxXbFDd2L7R4l6prElX1mbal6cTaiTXO3AkEAu8xzbhDDFVwAuSFrpSEHxkQB4sgrVUA0xcThK0GUI78MZJMbif9RDIirNCcwfFliYbdj/6wXylA9/Nl2ongmiwJAayFPFHjLDe3hwqgzEcAAk3aGj4y9ZwU/0m28bTiqAENQ0x94+iMgTrX7SDV+mdU3otEDnE5dLcdzgrhrGjyjFwJBALhSZqTNG5krPMgkOCSKKlP6i1ulCfCVUNSD1PgtK84YDwFrDToSt727KHujMGMMojlaE0+pX5aEOcfuApLz/BM=";
	// EC_public_key =
	// "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChzc6FnPS9xY4m8zvsSvw57WGqqXzRpCC6DY2RCTkGoaaGY8XdTvVA+onp/fjsdThQ+ynBYm8bt2vQEQsf1knjKpgIT1AIDC+W/MjfMx9TBRtqBmWF+VF/gPV6j2T/1sH+GD096RP8UPuKyv0k1dWirxHeZUdqeeFXGilP7XRZ/QIDAQAB";
	//
	// ApiMV api = new ApiMV();
	// api.resultType = "json";
	// api.lang = "cn";
	//
	// String url = api.domain();
	// api.oauth(url);
	// api.userInfo(url);
	// api.gameInfo(url);
	// }

	// Domain API
	public String domain() {
		long time = System.currentTimeMillis();

		// long timeTemp = thisTimeLong + timeLong;
		// if(thisTimeLong > 0 && timeTemp > time){
		// return null;
		// }else {
		// thisTimeLong = time;
		// }
		TreeMap<String, Object> data = new TreeMap<String, Object>();
		data.put("timestamp", String.valueOf(time));

		JSONObject json;
		String domainValue = "";
		try {
			json = JSONObject.parseObject(sendApi(data, func_domain, null));
			domainValue = json.getString("domain");
		} catch (Exception e) {
			String defaultDomain = "https://www.666wins.com/as-lobby/";
			domainValue = defaultDomain;
		}
		return domainValue;
	}

	// 1.授权 Oauth API
	public JSONObject oauth(String domain, String uid, String utoken, int jumpType) throws Exception {

		TreeMap<String, Object> data = new TreeMap<String, Object>();
		data.put("uid", uid);// 区分大小写，长度必须小于32个字符,(uid、utoken、merchantId,接入方自行生成與管理)
		data.put("utoken", utoken);// ec方平台用户授权码，一次授权之后不可变更，长度必须为32个字符
		if (StringUtils.isNotEmpty(merchantId)) {
			data.put("merchantId", merchantId);
		}
		data.put("timestamp", Long.toString(System.currentTimeMillis()));// 時間戳,格式是unix,精確到秒
		data.put("jumpType", jumpType);
		data.put("gameId", "");

		JSONObject json = JSONObject.parseObject(sendApi(data, domain, func_oauth));
		if (jumpType == 3) {
			appLaunchReq(domain, json.getString("interface"));
		}

		return json;
	}
	// 7.获取日志
	public JSONObject siteUsergamelog(String domain, TreeMap<String, Object> dataMap) throws Exception {
		return JSONObject.parseObject(sendApi(dataMap, domain, reqg_betLog));
	}

}

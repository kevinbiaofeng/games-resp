package com.ly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ly.game.model.FontanaBetAgbm;
import com.ly.service.business.VGService;
import com.ly.service.business.impl.AllBetServiceImpl;
import com.ly.service.business.impl.BBINServiceImpl;
import com.ly.service.business.impl.BbinFishingServiceImpl;
import com.ly.service.business.impl.CQ9ServiceImpl;
import com.ly.service.business.impl.FGServiceImpl;
import com.ly.service.business.impl.KAGAServiceImpl;
import com.ly.service.business.impl.LyLotServiceImpl;
import com.ly.service.business.impl.MWServiceImpl;
import com.ly.service.business.impl.SunBetServiceImpl;
import com.ly.service.business.impl.VGServiceImpl;
import com.ly.service.game.FontanaBetAgbmService;
import com.ly.service.remote.AllBetRemoteService;

@RestController
public class TestController {
	@Autowired
	FontanaBetAgbmService fontanaBetAgbmService;
	@Autowired
	AllBetRemoteService allBetRemoteService;
	@Autowired
	VGService vgService;
	@Autowired
	BBINServiceImpl bbinServiceImpl;
	@Autowired
	AllBetServiceImpl allbetServiceImpl;
	@Autowired
	CQ9ServiceImpl cq9ServiceImpl;
	@Autowired
	VGServiceImpl vgServiceImpl;
	@Autowired
	SunBetServiceImpl sunServiceImpl;
	@Autowired
	BbinFishingServiceImpl bbinFishingServiceImpl;
	@Autowired
	KAGAServiceImpl kagaServiceImpl;
	@Autowired
	LyLotServiceImpl lylotServiceImpl;
	@Autowired
	MWServiceImpl mvServiceImpl;
	@Autowired
	FGServiceImpl fgServiceImpl;
	@Value("${ly.games.ag.url}")
	private String agUrl;
	
	@RequestMapping(value = "/test")
    public void save(){
		System.out.println("test...aaa.bbbccc" + agUrl);
    }
	
	@RequestMapping(value = "/getdd")
	public void getdd(){
		fgServiceImpl.loadingRemoteGameData();
	}
    @RequestMapping(value = "/getById")
    public FontanaBetAgbm getById(){
        return fontanaBetAgbmService.selectByPrimaryKey(1L);
    }
}

package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetLotteryDetailMapper;
import com.ly.game.model.FontanaBetLotteryDetail;
import com.ly.service.game.FontanaBetLotteryDetailService;

@Service("fontanaBetLotteryDetailService")
public class FontanaBetLotteryDetailServiceImpl implements FontanaBetLotteryDetailService {
	@Autowired
	private FontanaBetLotteryDetailMapper fontanaBetLotteryDetailMapper;

	@Override
	public int insert(FontanaBetLotteryDetail record) {
		return fontanaBetLotteryDetailMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetLotteryDetail> list) {
		return fontanaBetLotteryDetailMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetLotteryDetail selectByPrimaryKey(Long id) {
		return fontanaBetLotteryDetailMapper.selectByPrimaryKey(id);
	}
}
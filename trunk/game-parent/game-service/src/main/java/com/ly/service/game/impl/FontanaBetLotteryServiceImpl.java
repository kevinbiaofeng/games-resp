package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetLotteryMapper;
import com.ly.game.model.FontanaBetLottery;
import com.ly.service.game.FontanaBetLotteryService;

@Service("fontanaBetLotteryService")
public class FontanaBetLotteryServiceImpl implements FontanaBetLotteryService {
	@Autowired
	private FontanaBetLotteryMapper fontanaBetLotteryMapper;

	@Override
	public int insert(FontanaBetLottery record) {
		return fontanaBetLotteryMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetLottery> list) {
		return fontanaBetLotteryMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetLottery selectByPrimaryKey(Long id) {
		return fontanaBetLotteryMapper.selectByPrimaryKey(id);
	}
}
package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetBoinlotteryMapper;
import com.ly.game.model.FontanaBetBoinlottery;
import com.ly.service.game.FontanaBetBoinlotteryService;

@Service("fontanaBetBoinlotteryService")
public class FontanaBetBoinlotteryServiceImpl implements FontanaBetBoinlotteryService {
	@Autowired
	private FontanaBetBoinlotteryMapper fontanaBetBoinlotteryMapper;

	@Override
	public int insert(FontanaBetBoinlottery record) {
		return fontanaBetBoinlotteryMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetBoinlottery> list) {
		return fontanaBetBoinlotteryMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetBoinlottery selectByPrimaryKey(Long id) {
		return fontanaBetBoinlotteryMapper.selectByPrimaryKey(id);
	}
}
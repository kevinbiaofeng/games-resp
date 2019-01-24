package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetVideoresultMapper;
import com.ly.game.model.FontanaBetVideoresult;
import com.ly.service.game.FontanaBetVideoresultService;

@Service("fontanaBetVideoresultService")
public class FontanaBetVideoresultServiceImpl implements FontanaBetVideoresultService {
	@Autowired
	private FontanaBetVideoresultMapper fontanaBetVideoresultMapper;

	@Override
	public int insert(FontanaBetVideoresult record) {
		return fontanaBetVideoresultMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetVideoresult> list) {
		return fontanaBetVideoresultMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetVideoresult selectByPrimaryKey(Long id) {
		return fontanaBetVideoresultMapper.selectByPrimaryKey(id);
	}
}
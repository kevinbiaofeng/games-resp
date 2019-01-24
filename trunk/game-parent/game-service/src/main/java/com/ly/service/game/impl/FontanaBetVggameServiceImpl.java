package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetVggameMapper;
import com.ly.game.model.FontanaBetVggame;
import com.ly.service.game.FontanaBetVggameService;

@Service("fontanaBetVggameService")
public class FontanaBetVggameServiceImpl implements FontanaBetVggameService {
	@Autowired
	private FontanaBetVggameMapper fontanaBetVggameMapper;

	@Override
	public int insert(FontanaBetVggame record) {
		return fontanaBetVggameMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetVggame> list) {
		return fontanaBetVggameMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetVggame selectByPrimaryKey(Long id) {
		return fontanaBetVggameMapper.selectByPrimaryKey(id);
	}
}
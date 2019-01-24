package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetLylotContentMapper;
import com.ly.game.model.FontanaBetLylotContent;
import com.ly.service.game.FontanaBetLylotContentService;

@Service("fontanaBetLylotContentService")
public class FontanaBetLylotContentServiceImpl implements FontanaBetLylotContentService {
	@Autowired
	private FontanaBetLylotContentMapper fontanaBetLylotContentMapper;

	@Override
	public int insert(FontanaBetLylotContent record) {
		return fontanaBetLylotContentMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetLylotContent> list) {
		return fontanaBetLylotContentMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetLylotContent selectByPrimaryKey(Long id) {
		return fontanaBetLylotContentMapper.selectByPrimaryKey(id);
	}
}
package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetBoinvideoMapper;
import com.ly.game.model.FontanaBetBoinvideo;
import com.ly.service.game.FontanaBetBoinvideoService;

@Service("fontanaBetBoinvideoService")
public class FontanaBetBoinvideoServiceImpl implements FontanaBetBoinvideoService{
	@Autowired
	private FontanaBetBoinvideoMapper fontanaBetBoinvideoMapper;

	@Override
	public int insert(FontanaBetBoinvideo record) {
		return fontanaBetBoinvideoMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetBoinvideo> list) {
		return fontanaBetBoinvideoMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetBoinvideo selectByPrimaryKey(Long id) {
		return fontanaBetBoinvideoMapper.selectByPrimaryKey(id);
	}
}
package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetPt2Mapper;
import com.ly.game.model.FontanaBetPt2;
import com.ly.service.game.FontanaBetPt2Service;

@Service("fontanaBetPt2Service")
public class FontanaBetPt2ServiceImpl implements FontanaBetPt2Service {
	@Autowired
	private FontanaBetPt2Mapper fontanaBetPt2Mapper;

	@Override
	public int insert(FontanaBetPt2 record) {
		return fontanaBetPt2Mapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetPt2> list) {
		return fontanaBetPt2Mapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetPt2 selectByPrimaryKey(Long id) {
		return fontanaBetPt2Mapper.selectByPrimaryKey(id);
	}
}
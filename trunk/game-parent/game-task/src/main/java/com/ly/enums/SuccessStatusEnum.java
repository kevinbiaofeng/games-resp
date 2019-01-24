package com.ly.enums;

import com.ly.common.enums.AbstractEnum;

public class SuccessStatusEnum extends AbstractEnum{
	/** 成功 */
	public static final EnumBean SUCCESS = new EnumBean(1, "SUCCESS.");
	/** 失败 */
	public static final EnumBean Failed = new EnumBean(0, "FAILED");
}

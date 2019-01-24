package com.ly.common.gameutil;

public enum BYType {
	BYSPORT("1","BYSPORT"){
	},
	BYLIVE("3","BYLIVE"){
	},
	BYEGAME("5","BYEGAME"){
	},
	BYLOTTERY("12", "BYLOTTERY"){
	};
	
	private String id;
	private String name;
	private BYType(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public static BYType getBYTypeById(String id){
		for(BYType r : BYType.values()){
			if(id.equals( r.getId()))
				return r;
		}
		return null;
	}
	
	
}

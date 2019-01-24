package com.ly.task.model;

import java.io.Serializable;

public class TaskJobEntity implements Serializable {
	private Integer id;

	private String name;

	private String group;

	private String cron;

	private Integer startDelay;

	private String classPath;

	private String description;

	private Integer status;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getStartDelay() {
		return startDelay;
	}

	public void setStartDelay(Integer startDelay) {
		this.startDelay = startDelay;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group == null ? null : group.trim();
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron == null ? null : cron.trim();
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath == null ? null : classPath.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status == null ? null : status;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		TaskJobEntity other = (TaskJobEntity) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getGroup() == null ? other.getGroup() == null : this.getGroup().equals(other.getGroup()))
				&& (this.getCron() == null ? other.getCron() == null : this.getCron().equals(other.getCron()))
				&& (this.getClassPath() == null ? other.getClassPath() == null
						: this.getClassPath().equals(other.getClassPath()))
				&& (this.getDescription() == null ? other.getDescription() == null
						: this.getDescription().equals(other.getDescription()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getGroup() == null) ? 0 : getGroup().hashCode());
		result = prime * result + ((getCron() == null) ? 0 : getCron().hashCode());
		result = prime * result + ((getClassPath() == null) ? 0 : getClassPath().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		return result;
	}
}
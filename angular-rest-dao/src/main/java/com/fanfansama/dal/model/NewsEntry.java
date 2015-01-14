package com.fanfansama.dal.model;

import java.util.Date;

import javax.persistence.*;

import com.fanfansama.dal.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * JPA Annotated Pojo that represents a news entry.
 */
@Entity
@Table(name = "NEWS")
public class NewsEntry
{

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date = new Date();

	@Column
	private String content;


	@JsonView(JsonViews.Admin.class)
	public Long getId()
	{
		return this.id;
	}


	@JsonView(JsonViews.User.class)
	public Date getDate()
	{
		return this.date;
	}


	public void setDate(Date date)
	{
		this.date = date;
	}


	@JsonView(JsonViews.User.class)
	public String getContent()
	{
		return this.content;
	}


	public void setContent(String content)
	{
		this.content = content;
	}


	@Override
	public String toString()
	{
		return String.format("NewsEntry[%d, %s]", this.id, this.content);
	}

}
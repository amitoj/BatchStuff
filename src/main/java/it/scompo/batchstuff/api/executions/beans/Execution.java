package it.scompo.batchstuff.api.executions.beans;

import java.io.Serializable;
import java.util.Date;

public class Execution implements Serializable {

	private static final long serialVersionUID = -3532952446234206612L;

	private Long id;

	private Date date;

	public Execution() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Execution [id=" + id + ", date=" + date + "]";
	}

}

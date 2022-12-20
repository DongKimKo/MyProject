package my.web.dgm.dto;

import java.sql.Timestamp;

public class FDto {
	int bId;
	String bCategory;
	String bTitle;
	String bName;
	Timestamp bDate;
	int bHit;
	String bContent;
	String bAccount;
	
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbAccount() {
		return bAccount;
	}

	public void setbAccount(String bAccount) {
		this.bAccount = bAccount;
	}

	public FDto(int bId, String bCategory, String bTitle, String bName, Timestamp bDate, int bHit, String bContent,
			String bAccount) {
		super();
		this.bId = bId;
		this.bCategory = bCategory;
		this.bTitle = bTitle;
		this.bName = bName;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bContent = bContent;
		this.bAccount = bAccount;
	}

	public FDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
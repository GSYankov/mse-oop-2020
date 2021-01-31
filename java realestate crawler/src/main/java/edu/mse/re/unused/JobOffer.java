package edu.mse.re.unused;

public class JobOffer {

	private String company;
	private String jobTitle;
	private String jobUrl;
	private String description;
	private String refNum;
	private String location;
	private String selary;

	public JobOffer(String company, String jobTitle, String jobUrl, String description, String refNum, String location,
			String selary) {
		this.company = company;
		this.jobTitle = jobTitle;
		this.jobUrl = jobUrl;
		this.description = description;
		this.refNum = refNum;
		this.location = location;
		this.selary = selary;
	}

	@Override
	public String toString() {
		return "JobOffer [company:" + this.company + ", jobTitle:" + jobTitle + ", jobUrl:" + jobUrl + ", description:" + description + ", refNum:"
				+ refNum + ", location:" + location + ", selary:" + selary + "]";
	}

}

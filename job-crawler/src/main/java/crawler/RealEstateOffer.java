package crawler;

public class RealEstateOffer {

	private String company;
	private String title;
	private String url;
	private String description;
	private String published;
	private String location;
	private String price;
	
	public RealEstateOffer(String company, String title, String url, String description, String published,
			String location, String price) {
		super();
		this.company = company;
		this.title = title;
		this.url = url;
		this.description = description;
		this.published = published;
		this.location = location;
		this.price = price;
	}

	@Override
	public String toString() {
		return "RealEstateOffer [company=" + company + ", title=" + title + ", url=" + url + ", description="
				+ description + ", published=" + published + ", location=" + location + ", price=" + price + "]";
	}
	
	

}

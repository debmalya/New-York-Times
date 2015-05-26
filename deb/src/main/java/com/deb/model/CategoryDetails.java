/**
 * 
 */
package com.deb.model;

/**
 * @author debmalyajash
 *
 */
public class CategoryDetails {
	private String title;
	private String created_date;
	private String published_date;
	private String per_facet;
	private String subsection;
	private String thumbnail_standard;
	private String kicker;
	private String url;
	private String[] multimedia;
	private String type;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the created_date
	 */
	public String getCreated_date() {
		return created_date;
	}
	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	/**
	 * @return the published_date
	 */
	public String getPublished_date() {
		return published_date;
	}
	/**
	 * @param published_date the published_date to set
	 */
	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}
	/**
	 * @return the per_facet
	 */
	public String getPer_facet() {
		return per_facet;
	}
	/**
	 * @param per_facet the per_facet to set
	 */
	public void setPer_facet(String per_facet) {
		this.per_facet = per_facet;
	}
	/**
	 * @return the subsection
	 */
	public String getSubsection() {
		return subsection;
	}
	/**
	 * @param subsection the subsection to set
	 */
	public void setSubsection(String subsection) {
		this.subsection = subsection;
	}
	/**
	 * @return the thumbnail_standard
	 */
	public String getThumbnail_standard() {
		return thumbnail_standard;
	}
	/**
	 * @param thumbnail_standard the thumbnail_standard to set
	 */
	public void setThumbnail_standard(String thumbnail_standard) {
		this.thumbnail_standard = thumbnail_standard;
	}
	/**
	 * @return the kicker
	 */
	public String getKicker() {
		return kicker;
	}
	/**
	 * @param kicker the kicker to set
	 */
	public void setKicker(String kicker) {
		this.kicker = kicker;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the multimedia
	 */
	public String[] getMultimedia() {
		return multimedia;
	}
	/**
	 * @param multimedia the multimedia to set
	 */
	public void setMultimedia(String[] multimedia) {
		this.multimedia = multimedia;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the org_facet
	 */
	public String getOrg_facet() {
		return org_facet;
	}
	/**
	 * @param org_facet the org_facet to set
	 */
	public void setOrg_facet(String org_facet) {
		this.org_facet = org_facet;
	}
	private String org_facet;
//	{"abstract":"Researchers are looking at modern primates\u2019 use of stones to gain an idea about how human ancestors developed simple hand axes.","created_date":"2015-05-18T06:00:13-04:00","published_date":"2015-05-18T00:00:00-04:00","geo_facet":"","per_facet":["Mangalam, Madhur","Tan, Amanda"],
//	"subsection":"",
//	"thumbnail_standard":"http://static01.nyt.com/images/2015/05/15/multimedia/science-take-monkeys/science-take-monkeys-thumbStandard.jpg",
//	"kicker":"Science Take","section":"Science",
//	"url":"http://www.nytimes.com/2015/05/18/science/monkeys-provide-clues-to-how-tool-use-developed.html",
//	"des_facet":["Monkeys and Apes","Evolution (Biology)","Research"],
//	"title":"Monkeys Provide Clues to How Tool Use Developed",
//	"multimedia":[{"height":75,"subtype":"photo","width":75,"caption":"","copyright":"","format":"Standard Thumbnail",
//	"type":"image",
//	
//	"url":"http://static01.nyt.com/images/2015/05/15/multimedia/science-take-monkeys/science-take-monkeys-thumbStandard.jpg"},{"height":143,"subtype":"photo","width":190,"caption":"","copyright":"","format":"Normal","type":"image","url":"http://static01.nyt.com/images/2015/05/15/multimedia/science-take-monkeys/science-take-monkeys-articleInline.jpg"},{"height":140,"subtype":"photo","width":210,"caption":"","copyright":"","format":"mediumThreeByTwo210","type":"image","url":"http://static01.nyt.com/images/2015/05/15/multimedia/science-take-monkeys/science-take-monkeys-mediumThreeByTwo210.jpg"},{"height":293,"subtype":"photo","width":440,"caption":"","copyright":"","format":"mediumThreeByTwo440","type":"image","url":"http://static01.nyt.com/images/2015/05/15/multimedia/science-take-monkeys/science-take-monkeys-mediumThreeByTwo440.jpg"}],"byline":"By JAMES GORMAN","updated_date":"2015-05-19T11:40:02-04:00","source":"The New York Times","org_facet":["PLoS One (Journal)","Current Biology (Journal)","University of Georgia","Nanyang Technological University"],"subheadline":"","related_urls":null,"item_type":"Article","material_type_facet":"News"}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryDetails [title=" + title + ", created_date="
				+ created_date + ", published_date=" + published_date
				+ ", per_facet=" + per_facet + ", subsection=" + subsection
				+ ", thumbnail_standard=" + thumbnail_standard + ", kicker="
				+ kicker + ", url=" + url + ", multimedia=" + multimedia
				+ ", type=" + type + ", org_facet=" + org_facet + "]";
	}

}

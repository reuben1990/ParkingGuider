package tenichalService.Pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Park implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2806608926183192600L;

	@DatabaseField(id = true)
	private String _id;
	
	@DatabaseField
	private String address;
	
	@DatabaseField
	private String create_at;
	
	@DatabaseField
	private String district;
	
	@DatabaseField
	private String end_working_time;
	
	@DatabaseField
	private int first_hour_rent;
	
	@DatabaseField
	private int next_hour_rent;
	
	@DatabaseField
	private boolean isfree;
	
	@DatabaseField
	private double lng;
	
	@DatabaseField
	private double lat;
	
	@DatabaseField
	private String parkname;
	
	@DatabaseField
	private String image_url;
	
	@DatabaseField
	private String preferential_conditions;
	
	@DatabaseField
	private boolean published;
	
	@DatabaseField
	private String start_working_time;
	
	@DatabaseField
	private String tips;
	
	@DatabaseField
	private String updated_at;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreate_at() {
		return create_at;
	}
	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getEnd_working_time() {
		return end_working_time;
	}
	public void setEnd_working_time(String end_working_time) {
		this.end_working_time = end_working_time;
	}
	public int getFirst_hour_rent() {
		return first_hour_rent;
	}
	public void setFirst_hour_rent(int first_hour_rent) {
		this.first_hour_rent = first_hour_rent;
	}
	public int getNext_hour_rent() {
		return next_hour_rent;
	}
	public void setNext_hour_rent(int next_hour_rent) {
		this.next_hour_rent = next_hour_rent;
	}
	public boolean isIsfree() {
		return isfree;
	}
	public void setIsfree(boolean isfree) {
		this.isfree = isfree;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getPreferential_conditions() {
		return preferential_conditions;
	}
	public void setPreferential_conditions(String preferential_conditions) {
		this.preferential_conditions = preferential_conditions;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public String getStart_working_time() {
		return start_working_time;
	}
	public void setStart_working_time(String start_working_time) {
		this.start_working_time = start_working_time;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
}

package zkart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity 
public class Item{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String listingName;
	private String imgUrl;
	
	@Column(unique=true)
	private String itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="SUBCATEGORYID", referencedColumnName="ID")
    })
	private SubCategory subCategory;;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name="SELLERID", referencedColumnName="ID")
    })
	private User user;
	private Integer quantity;
	private Integer price;
	private String colour;
	private String brand;
	private String manufacture_Date;
	private String description;
	private String priority;
	private Integer discount;
	private Integer bdaydiscount;

	public Integer getBdaydiscount() {
		return bdaydiscount;
	}

	public void setBdaydiscount(Integer bdaydiscount) {
		this.bdaydiscount = bdaydiscount;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getListingName() {
		return listingName;
	}

	public void setListingName(String listingName) {
		this.listingName = listingName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacture_Date() {
		return manufacture_Date;
	}

	public void setManufacture_Date(String manufacture_Date) {
		this.manufacture_Date = manufacture_Date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "FlopkartListing [id=" + id + ", listingName=" + listingName + ", imgUrl=" + imgUrl + ", itemId="
				+ itemId +  ", quantity=" + quantity
				+ ", price=" + price + ", colour=" + colour + ", brand=" + brand + ", manufacture_Date="
				+ manufacture_Date + ", description=" + description + ", priority=" + priority + ", discount="
				+ discount + ", bdaydiscount=" + bdaydiscount + "]";
	}
	
}
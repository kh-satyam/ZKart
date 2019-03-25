package zkart.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name="ITEMID", referencedColumnName="ID")
    })
	private Item item;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name="USERID", referencedColumnName="ID")
    })
	private User user;
	private Integer stars;
	private String review;
	private Integer sellerId;

	public Review() {
	}

	public Review(Integer id, Item item, User user, Integer stars, String review, Integer sellerId) {
		this.id = id;
		this.item = item;
		this.user = user;
		this.stars = stars;
		this.review = review;
		this.sellerId = sellerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", item=" + item + ", user=" + user + ", stars=" + stars + ", review=" + review
				+ ", sellerId=" + sellerId + "]";
	}
}
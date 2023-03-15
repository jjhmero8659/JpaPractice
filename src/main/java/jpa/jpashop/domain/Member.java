package jpa.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {

	@Id @GeneratedValue
	@Column(name = "member_id")
	private long id;
	
	private String userName;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public void addOrder(Order order){
		this.orders.add(order);
		order.setMember(this);
	}
}

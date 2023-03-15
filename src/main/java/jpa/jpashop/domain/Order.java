package jpa.jpashop.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
	
	@Id @GeneratedValue
	@Column(name = "order_id")
	private long id;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
	private List<OrderItem> orderitems = new ArrayList<>();
	
	@OneToOne(fetch = LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	
	private LocalDate orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public void addOrderItems(OrderItem orderItem){
		this.orderitems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery){
		this.delivery = delivery;
		delivery.setOrder(this);
	}
}

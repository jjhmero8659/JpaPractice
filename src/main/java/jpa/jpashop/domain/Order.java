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
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderitems = new ArrayList<>();
	
	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	
	private LocalDate orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

}

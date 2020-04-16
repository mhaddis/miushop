/*
 * package com.ea.miushop.domain;
 * 
 * import java.math.BigDecimal;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.FetchType; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.Lob; import javax.persistence.ManyToOne; import
 * javax.persistence.OneToOne; import javax.persistence.Table;
 * 
 * 
 * @Entity
 * 
 * @Table(name = "Purchase_Orders") public class Purchase_Order {
 * 
 * @Id @GeneratedValue(strategy=GenerationType.AUTO)
 * 
 * @Column(name = "User_Id") private Long id = null;
 * 
 * 
 * @Column(name = "Item_Price") private BigDecimal itemPrice;
 * 
 * 
 * @Column(name = "Reciept")
 * 
 * @Lob private byte[] reciept;
 * 
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "purchaser_Id") private User purchaser;
 * 
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "orderId") private Order order;
 * 
 * 
 * public BigDecimal getItemPrice() { return itemPrice; }
 * 
 * public void setItemPrice(BigDecimal itemPrice) { this.itemPrice = itemPrice;
 * }
 * 
 * public byte[] getReciept() { return reciept; }
 * 
 * public void setReciept(byte[] reciept) { this.reciept = reciept; }
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public User getPurchaser() { return purchaser; }
 * 
 * public void setPurchaser(User purchaser) { this.purchaser = purchaser; }
 * 
 * public Order getOrder() { return order; }
 * 
 * public void setOrder(Order order) { this.order = order; }
 * 
 * }
 */
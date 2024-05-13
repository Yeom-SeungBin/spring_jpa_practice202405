package com.study.jpa.chap01_basic.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long id; // 기본 타입(long)은 null 값 X , 객체 타입(Long)은 null 값 O

	@Column(name = "prod_name", nullable = false, length = 30)
	private String name;

	private int price;

	@Enumerated(EnumType.STRING)
	private Category category;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createDate;

	@UpdateTimestamp
	private LocalDateTime updateDate;

	public enum Category {
		FOOD, FASHION, ELECTRONIC
	}

}
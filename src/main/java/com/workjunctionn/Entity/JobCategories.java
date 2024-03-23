package com.workjunctionn.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "jobcategories_tb")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long jobcategoriesId;

	
	@Column(name = "Category_Name", nullable = false, length = 255)
	@NotNull(message = "Category Name can not be empty ")
	private String categoryName;

	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "Created_Time")
	private Date createdAt;

	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Updated_Time", nullable = false)
	private Date updatedAt;

	
	/*
	 * @OneToOne(mappedBy = "jobcategories",orphanRemoval = true,cascade =
	 * CascadeType.ALL) private Jobs jobs;
	 */

}

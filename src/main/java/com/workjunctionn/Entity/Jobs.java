package com.workjunctionn.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="jobs_tb")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Jobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long jobId;
	
	
	@Column(nullable = false , length = 1000,name = "Job_Description")
	@NotNull(message = "Job description can not empty")
	private String jobDescription;
	
	
	@Column(nullable = false , length = 255,name = "Job_Title")
	@NotNull(message = "Job title can not be empty")
	private String jobTitle;
	
	
	@Column(nullable = false ,updatable = true,name = "Job_Status")
	private boolean  isActive;
	
	
	@LastModifiedDate
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(nullable = false,name = "Last_Date")
	private Date lastDate;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(nullable = false,name = "Created_Time")
	private Date createdAt;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(nullable = false,name = "Updated_Time")
	private Date updatedAt;
	
	
	  @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)	  
	  @JoinColumn(name="recruiter_id") private Recruiters recruiters;
	 
	
	
		
		  @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
		  @JoinColumn(name = "jobcategories_Id") 
		  private JobCategories jobcategories;
		 

		  

}

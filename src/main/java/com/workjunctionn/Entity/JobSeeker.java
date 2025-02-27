package com.workjunctionn.Entity;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "jobseeker_tb")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobseekerId;

	@Column(nullable = false, length = 255, name = "User_Name")
	@NotNull(message = "User name must be 3 characters")
	private String username;

	@Column(nullable = false, length = 255, name = "First_Name")
	@NotNull(message = "First name must be 3 characters")
	private String firstname;

	@Column(nullable = false, length = 255, name = "Last_Name")
	@NotNull(message = "Last name must be 3 characters")
	private String lastname;

	@Column(nullable = false, length = 255, unique = true, name = "jobseeker_Email")
	@NotNull(message = "Email can not be empty")
	@Email(message = "Incorrect email format")
	private String email;

	@Column(name = "Phone_No", nullable = false, length = 255)
	@NotNull(message = "Phone number must be 10 digits")
	private Long phone;

	@Column(nullable = false, length = 255, name = "jobseeker_password")
	@NotNull(message = "Password can not be empty")
	private String password;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(nullable = false, name = "Created_Time")
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, name = "Updated_Time")
	private Date updatedAt;


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "JobSeeker_roles", joinColumns = @JoinColumn(name = "JobSeeker_id", referencedColumnName = "jobseekerId"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;


}

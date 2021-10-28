package java5.assignment.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "Staffs")
public class Staff {
	@Id
	@NotBlank(message = "Không để trống mã nhân viên!")
	@Length(min = 1, max = 10, message = "Mã nhân viên có độ dài tối đa là 10 kí tự!")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Mã nhân viên không chứa kí tự đặc biệt")
	private String id;
	
	@NotBlank(message = "Không để trống tên nhân viên")
	private String name;
	
	@NotNull(message = "Vui lòng chọn giới tính")
	private Boolean gender=true;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull(message = "Không để trống ngày sinh!")
	private Date birthday;
	
	@NotBlank(message = "Bạn chưa chọn ảnh!")
	private String photo;
	
	@NotBlank(message = "Không để trống email!")
	@Email(message = "Không đúng định dạng email")
	private String email;
	
	@NotBlank(message = "Không để trống số điện thoại!")
	@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại phải là số có 10 chữ số và bắt đầu bằng 0")
	private String phone;
	
	@NotNull(message = "Không để trống lương!")
	@DecimalMin(value = "1", message = "Lương phải lớn hơn 0!")
	private Float salary=100000f;
	
//	@NotBlank(message = "Không để trống ghi chú")
//	@Value("Không có nhận xét")
	private String notes="Chưa có nhận xét";
	
	@ManyToOne
	@JoinColumn(name = "departId")
	private Depart depart;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Record> records;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Collection<Record> getRecords() {
		return records;
	}

	public void setRecords(Collection<Record> records) {
		this.records = records;
	}
	
}

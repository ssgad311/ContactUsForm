package com.example.springboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "employees")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String custId;
 
    private String name;
    
    @Email(message = "Please enter a valid mail address")
    private String mail;
    
    @Pattern(regexp = "\\d{10}", message = "number must have exactly 10 digits")
    private String number;

    private String message;
    
    public Employee() {
        super();
    }

    public Employee(String name, String mail,String number, String message) {
        super();
        this.name = name;
        this.mail = mail;
        this.number = number;
        this.message = message;
      
    }

    // getter and setter methods

  
    public String getName() {
        return name;
    }

    public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getnumber() {
        return number;
    }

    public void setnumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


}

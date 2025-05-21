package com.musicshop.model;

public class UserModel {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private InstrumentModel instrument;
	private String imageUrl;
	private String role;

	public UserModel() {
	}

	public UserModel(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public UserModel(int id, String firstName, String lastName, String userName,
			String email, String password, String imageUrl) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
		this.role = "user"; // Default role
	}

	public UserModel(String firstName, String lastName, String userName, String email,
			String password, String imageUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
		this.role = "user"; // Default role
	}

	public UserModel(int id, String firstName, String lastName, String userName,
			String email, String password, InstrumentModel instrument, String imageUrl) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.instrument = instrument;
		this.imageUrl = imageUrl;
	}

	public UserModel(String firstName, String lastName, String userName,  String email,
			 String password, InstrumentModel instrument, String imageUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.instrument = instrument;
		this.imageUrl = imageUrl;
	}

	public UserModel(int id, String firstName, String lastName, InstrumentModel instrument, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.email = email;
	}
	
	public UserModel(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InstrumentModel getInstrument() {
		return instrument;
	}

	public void setInstrument(InstrumentModel instrument) {
		this.instrument = instrument;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

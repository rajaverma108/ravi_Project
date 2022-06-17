package com.project;
public class Passenger {


		private String PassengerID;
		private String PassengerName;
		private String Email;
		private String Password;
		private String Address;
		private String ContactNumber;

		public Passenger(String PassengerID, String PassengerName, String Email, String Password, String Address,
				String ContactNumber) {
			super();
			this.PassengerID = PassengerID;
			this.PassengerName = PassengerName;
			this.Email = Email;
			this.Password = Password;
			this.Address = Address;
			this.ContactNumber = ContactNumber;
		}

		public String getPassengerID() {
			return PassengerID;
		}

		public void setPassengerID(String passengerID) {
			PassengerID = passengerID;
		}

		public String getPassengerName() {
			return PassengerName;
		}

		public void setPassengerName(String passengerName) {
			PassengerName = passengerName;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getContactNumber() {
			return ContactNumber;
		}

		public void setContactNumber(String contactNumber) {
			ContactNumber = contactNumber;
		}

	}



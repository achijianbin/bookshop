package com.javabook.model;

public class Cuser {
		private String id;
		private String name;
		private String passWord;
		private String email;
		private String phone;
		private Float monkey;
		
		public Cuser() {
			super();
			// TODO 自动生成的构造函数存根
		}

	

		public Cuser(String id, String name, String email, String phone) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.phone = phone;
		}
	


		public Cuser(String id, String passWord) {
			super();
			this.id = id;
			this.passWord = passWord;
		}



		public Cuser(String id, String name, String passWord, String email, String phone) {
			super();
			this.id = id;
			this.name = name;
			this.passWord = passWord;
			this.email = email;
			this.phone = phone;
		}



		public Cuser(String id, Float monkey) {
			super();
			this.id = id;
			this.monkey = monkey;
		}



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

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
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

		public Float getMonkey() {
			return monkey;
		}

		public void setMonkey(Float monkey) {
			this.monkey = monkey;
		}
		
		
}

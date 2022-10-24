package pruebas.api.rest;

public class DatosUsuario {
	private String gender;
	private String email;
	private String phone;
	private String cell;
	private String nat;
	private Name name;
	private Login login;
	public DatosUsuario(String gender, String email, String phone, String cell, String nat, Name name, Login login) {
		super();
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.cell = cell;
		this.nat = nat;
		this.name = name;
		this.login = login;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return this.name+" ("+this.nat+" - "+this.gender+")\n"
				+ this.email+"\n"
				+ this.cell+"\n"
				+ this .login+"\n";
	}
	

}

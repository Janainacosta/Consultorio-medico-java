package modelo;

public class Paciente {
	private Integer id_paciente;
	private String nome_paciente;
	private String cpf_paciente;
	private String telefone_paciente;
	private String endereco_paciente;
	private String email_paciente;
	
	public Paciente() {
		
	}

	public Paciente(Integer id_paciente, String nome_paciente, String telefone_paciente,
			String endereco_paciente, String email_paciente) {
		this.id_paciente = id_paciente;
		this.nome_paciente = nome_paciente;
		this.telefone_paciente = telefone_paciente;
		this.endereco_paciente = endereco_paciente;
		this.email_paciente = email_paciente;
	}

	public Integer getIdPaciente() {
		return id_paciente;
	}

	public void setIdPaciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getNome_paciente() {
		return nome_paciente;
	}

	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}
	
	public String getCpf_paciente() {
		return cpf_paciente;
	}

	public void setCpf_paciente(String cpf_paciente) {
		this.cpf_paciente = cpf_paciente;
	}
	
	public String getTelefone_paciente() {
		return telefone_paciente;
	}

	public void setTelefone_paciente(String telefone_paciente) {
		this.telefone_paciente = telefone_paciente;
	}

	public String getEndereco_paciente() {
		return endereco_paciente;
	}

	public void setEndereco_paciente(String endereco_paciente) {
		this.endereco_paciente = endereco_paciente;
	}

	public String getEmail_paciente() {
		return email_paciente;
	}

	public void setEmail_paciente(String email_paciente) {
		this.email_paciente = email_paciente;
	}
}

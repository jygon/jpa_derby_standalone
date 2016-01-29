package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.Cores;

@Entity
@Table(name = "tbPessoas", schema="APP")
public class tbPessoas {

@Id
private int id;

private String nome;
private int idade;
private String cpf;

private Cores corOlhos;

private static final long serialVersionUID = 1L;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public int getIdade() {
	return idade;
}

public void setIdade(int idade) {
	this.idade = idade;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public Cores getCorOlhos() {
	return corOlhos;
}

public void setCorOlhos(Cores corOlhos) {
	this.corOlhos = corOlhos;
}


}
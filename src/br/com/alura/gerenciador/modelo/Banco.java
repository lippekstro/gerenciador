package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa("Alura");
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa("Caelum");
		empresa2.setId(chaveSequencial++);
		empresas.add(empresa);
		empresas.add(empresa2);
		
		
		Usuario u1 = new Usuario("fellipe", "123");
		Usuario u2 = new Usuario("nico", "321");
		usuarios.add(u1);
		usuarios.add(u2);
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.empresas.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = empresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario u : usuarios) {
			if(u.ehIgual(login, senha)) {
				return u;
			}
		}
		return null;
	}
	

}

package br.com.eleicoestransparentes.test;

import br.com.eleicoestransparentes.utils.Repository;

public class Principal {

	public static void main(String[] args) throws IllegalArgumentException,IllegalAccessException {

		for(String path:Repository.getPaths())
			System.out.println(path);
	}

}
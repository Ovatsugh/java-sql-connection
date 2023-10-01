package br.com.projetobanco.src.maven;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ConexaoDB conexao = new ConexaoDB();
		
		System.out.println("Insira o nome: ");
		String nome = sc.next();
		
		System.out.println("Insira a matricula: ");
		int matricula = sc.nextInt();
		
		System.out.println("Insira a nota: ");
		double nota = sc.nextDouble();
		
		sc.close();
		conexao.adduser(nome, matricula,nota);
	}

}

package Biblioteca;

import java.util.Scanner;

public class Interface {
	
	public void apresentarInterface() {
			
		Scanner entrada = new Scanner(System.in);
		ListaLivro lista = new ListaLivro();
		
		this.menuOpcoes();
		int opcao = entrada.nextInt();
		while(opcao != 0) {
			switch(opcao) {
				case 1:
					lista.inserirInicio(criaLivro());
					break;
					
				case 2:
					lista.inserirFim(criaLivro());
					break;
					
				case 3: 
					lista.retirarInicio();
					break;
					
				case 4:
					lista.retiraFim();
					
				case 5: 
					System.out.println("Informe o item a ser removido!");
					lista.retirar(entrada.nextInt());		


				case 6: 
					lista.quickSort(lista, 0, lista.tamanho() - 1);

					for(int i = 0; i < lista.tamanho; i++)
					{
						System.out.println(lista.get(i).getTitulo());
					}
				case 7:
					
					for(int i = 0; i < lista.tamanho; i++)
					{
						System.out.println(lista.get(i).getTitulo());
					}
				case 8:
					
				case 9:
				
			}
			
			this.menuOpcoes();
			opcao = entrada.nextInt();
		}
		
	}
	private void menuOpcoes()
	{
		System.out.println("0.Sair");
		System.out.println("1.Cadastrar um livro no inicio da lista");
		System.out.println("2.Cadastrar um livro no fim da lista");
		System.out.println("3.Excluir um livro do inicio da lista");
		System.out.println("4.Excluir um livro do fim da lista");
		System.out.println("5.Excluir um livro da lista");
		System.out.println("6.Ordenar os títulos de todos os livros cadastrados em ordem alfabética");
		System.out.println("7.Apresentar os títulos dos livros de um determinado autor");
		System.out.println("8.Apresentar os títulos dos livros publicados em um determinado intervalo de anos ");
			//(p.ex.: livros publicados entre 2010 e 2015)4.Apresentar título, autor e editora de todos o
		    //s livros que contém, no seu título, uma palavra ou frase informada pelo usuário.
	}
	
	private Livro criaLivro() {
		Scanner entrada = new Scanner(System.in);
		
		Livro inLivro = new Livro();
		Autor inAutor = new Autor();
					
		System.out.println("Informe o Titulo:");
		inLivro.setTitulo(entrada.next());
		
		System.out.println("Informe o Isbn:");
		inLivro.setIsbn(entrada.nextInt());
		
		System.out.println("Informe o Nome do Autor");
		inAutor.setNome(entrada.next());
		
		System.out.println("Informe o Pais do Autor:");
		inAutor.setPais(entrada.next());
		
		inLivro.setAutor(inAutor);
		
		System.out.println("Informe a Editora:");
		inLivro.setEditora(entrada.next());
		
		System.out.println("Informe o Ano de Publicacao:");
		inLivro.setAno(entrada.nextInt());
		
		return inLivro;
	}


}

package Biblioteca;

import java.util.Scanner;

public class Interface {
	
	public void apresentarInterface() {
			
		Scanner entrada = new Scanner(System.in);
		ListaLivro lista = new ListaLivro();
		String lsTempAutor;
		
		this.menuOpcoes();
		int opcao = Integer.parseInt(entrada.nextLine());
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
					break;
					
				case 5: 
					System.out.println("Informe o item a ser removido!");
					lista.retirar(Integer.parseInt(entrada.nextLine()));		
					break;
					
				case 6: 
					if (lista.tamanho() <= 0) {
						System.out.println("Primeiro cadastre algum livro!");
						break;
					}
					
					lista.quickSort(lista, 0, lista.tamanho() - 1);

					for(int i = 0; i < lista.tamanho; i++)
					{
						System.out.println(lista.get(i).getTitulo());
					}
					break;
				case 7:
					if (lista.tamanho() <= 0) {
						System.out.println("Primeiro cadastre algum livro!");
						break;
					}
					
					System.out.println("Informe o Autor:");
					lsTempAutor = entrada.nextLine();
					String nome;
					
					for(int i = 0; i <= lista.tamanho -1; i++)
					{
						nome = lista.get(i).getAutor().getNome().toString();

						if (nome.equals(lsTempAutor)) {
							System.out.println(lista.get(i).getTitulo());
						}
					}
					
					break;
					
				case 8:
					int liAnoInicial;
					int liAnoFinal;
					
					if (lista.tamanho() <= 0) {
						System.out.println("Primeiro cadastre algum livro!");
						break;
					}
					
					System.out.println("Informe o ano inicial:");
					liAnoInicial = Integer.parseInt(entrada.nextLine());
					System.out.println("Informe o ano final:");
					liAnoFinal = Integer.parseInt(entrada.nextLine());
					
					if(liAnoInicial > liAnoFinal) {
						System.out.println("O ano final deve ser maior que o inicial");
						break;
					}
					
					System.out.println("Livros publicados entre: " + liAnoInicial + " e " + liAnoFinal);
					
					for(int i = 0; i < lista.tamanho; i++)
					{
						if ((lista.get(i).getAno() >= liAnoInicial) && (lista.get(i).getAno() <= liAnoFinal)) {
							
						
						System.out.println(lista.get(i).getTitulo());
						}
					}
					break;
					
				case 9:
					if (lista.tamanho() <= 0) {
						System.out.println("Primeiro cadastre algum livro!");
						break;
					}
										
					System.out.println("Informe a palavra chave:");
					String lsTempChave = entrada.nextLine();
					String titulo;
					Integer cont = 0;
					
					System.out.println("Os Livros que contem a palavra " + lsTempChave + " sao:");
					for(int i = 0; i <= lista.tamanho -1; i++)
					{
						titulo = lista.get(i).getTitulo().toString();

						if (titulo.contains(lsTempChave)) {
							System.out.println(lista.get(i).getTitulo());
							cont++;
						}
						if (cont == 0) {
							System.out.println("Sem dados;");
						}
					}
					
					
			}
			
			this.menuOpcoes();
			opcao = Integer.parseInt(entrada.nextLine());
		}

	}
	private void menuOpcoes()
	{
		System.out.println("\n");
		System.out.println("###_________________BIBLIOTECA__________________###");
		System.out.println("###________________MenuPrincipal________________###");
		System.out.println("0.Sair");
		System.out.println("1.Cadastrar um livro no inicio da lista");
		System.out.println("2.Cadastrar um livro no fim da lista");
		System.out.println("3.Excluir um livro do inicio da lista");
		System.out.println("4.Excluir um livro do fim da lista");
		System.out.println("5.Excluir um livro da lista");
		System.out.println("6.Ordenar os títulos de todos os livros cadastrados em ordem alfabética");
		System.out.println("7.Apresentar os títulos dos livros de um determinado autor");
		System.out.println("8.Apresentar os títulos dos livros publicados em um determinado intervalo de anos ");
		System.out.println("9.Apresentar título, autor e editora de todos os livros que contém");

		System.out.println("\n");
	}
	
	private Livro criaLivro() {
		Scanner entrada1 = new Scanner(System.in);
		
		Livro inLivro = new Livro();
		Autor inAutor = new Autor();
					
		System.out.println("Informe o Titulo:");
			inLivro.setTitulo(entrada1.nextLine());

		System.out.println("Informe o Isbn:");
			inLivro.setIsbn(Integer.parseInt(entrada1.nextLine()));

		System.out.println("Informe o Nome do Autor:");
			inAutor.setNome(entrada1.nextLine());

		
		System.out.println("Informe o Pais do Autor:");
			inAutor.setPais(entrada1.nextLine());

		
		inLivro.setAutor(inAutor);
		
		System.out.println("Informe a Editora:");
			inLivro.setEditora(entrada1.nextLine());
		
		System.out.println("Informe o Ano de Publicacao:");
			inLivro.setAno(Integer.parseInt(entrada1.nextLine()));

		return inLivro;
		
	}
	
}

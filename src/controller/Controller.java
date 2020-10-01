package controller;

import java.util.Scanner;

import clases.Pelicula;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo(this);
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		try {
			while( !fin ){
				view.printMenu();
				int option = lector.nextInt();
				switch(option){

				case 1:
					view.printMessage("--------- \nCargar peliculas");
					modelo = new Modelo(this);
					modelo.cargarHashTable();
					view.printMessage("--------- \nLista de peliculas cargada");					
					break;

				case 2:
					modelo.cargarHashTable();
					view.printMessage("--------- \nSe cargo la lista en formato Productoras");
					view.printMessage("--------- \nEscriba el nombre de la casa productora que desea conocer");
					lector.nextLine();
					String pCasaProductora = lector.nextLine(); 
					view.printMessage("La casa productora que desea conocer es "+pCasaProductora);
					modelo.darPeliculasCasaProductora(pCasaProductora);
					break;

				case 3:

					break;

				case 4:
					modelo.cargarHashTableActores();
					view.printMessage("--------- \nSe cargo la lista en formato actores");
					view.printMessage("--------- \nEscriba el nombre del actor que desea conocer");
					lector.nextLine();
					String nombreActor = lector.nextLine(); 
					view.printMessage("El actor que quieres conocer es " + nombreActor );
					modelo.darPeliculasActorHash(nombreActor);
					break;
				
				case 5:
					modelo.cargarHashTable();
					view.printMessage("--------- \nSe cargo la lista en orden de lectura");
					view.printMessage("--------- \nEscriba el genero que desea conocer");
					String pGenero = lector.next(); 
					view.printMessage("El genero que quieres conocer es "+pGenero);
					modelo.darPeliculasGenero(pGenero);
					break;
					
				case 6:
					if(!modelo.darCarga()) {
						view.printMessage("No hay peliculas cargadas");
					}
					else {
							
					}
					break;
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}
			}
		}
		catch(Exception e) {
			view.printMessage("--------- \n Error!! \n---------");
			e.printStackTrace();
			run();
		}
	}
	
	public void ImprimirPelicula(Pelicula aImprimir) {
		if (aImprimir != null) {
			view.printMessage("----------");
			view.printMessage("ID:"+aImprimir.darIdentificador());
			view.printMessage("Nombre:"+aImprimir.darNombrePelicula());
			view.printMessage("Votos:"+(int)aImprimir.darCantidadVotos());
			view.printMessage("Promedio de Votacion:"+aImprimir.darVotosPromedio());
			view.printMessage("Genero:"+aImprimir.darGenero());
			view.printMessage("Actores:");
			String[] actores = aImprimir.darListaNombresActores();
			for (int i =0;i<5;i++) {
				view.printMessage(actores[i]);
			}
		}
		else {
			view.printMessage("Ocurrio un errror, revise que el indice dado sea menor al tamaño de la lista");
		}
	}
	
	public void printMessage(String mensaje) {
		view.printMessage(mensaje);
	}
}

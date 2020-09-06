package controller;

import java.util.Scanner;
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
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();
			int option = lector.nextInt();
			switch(option){
				
				case 1:
					view.printMessage("--------- \nCargar peliculas");
				    modelo = new Modelo();
				    modelo.cargarArreglo();
				    view.printMessage("--------- \nLista de peliculas cargada");
				    view.printMessage("--------- \nLa primera pelicula de la base de datos es: ");
				    modelo.ImprimirPelicula(0);
				    view.printMessage("--------- \nLa ultima pelicula de la base de datos es: ");
				    modelo.ImprimirPelicula(modelo.darTamano()-1);
				    view.printMessage("---------\nLa base de datos cuenta con " + modelo.darTamano() + " peliculas");						
					break;
				
				case 2:
					
					break;
				case 3:
					
					break;
					
				case 4:
					
					break;
				
				case 5:
					
					break;
					
				case 6:
					
					break;
					
				case 7:
					
					break;
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
	}	
}

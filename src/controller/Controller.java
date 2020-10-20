package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		modelo = new Modelo();
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
					view.printMessage("Cargando datos del archivo");	
					modelo.loadAccidents();
					break;

				case 2:
					view.printMessage("--------- \nEscriba la fecha a buscar con el formato AAAA-MM-DD");
					lector.nextLine();
					String fecha = lector.nextLine();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date search = df.parse(fecha);
					long startTime = System.currentTimeMillis();
					int[] ans = modelo.SearchByDateRBT(search);
					long endTime = System.currentTimeMillis();
					long duration = endTime - startTime;
					
					long startTime1 = System.currentTimeMillis();
					int[] ans1 = modelo.SearchByDateBST(search);
					long endTime1 = System.currentTimeMillis();
					long duration1 = endTime - startTime;
					
					
					if(ans[0] == 0)
					{
						view.printMessage("Fecha no encontrada, intente nuevamente");
					}
					else
					{
						view.printMessage("Accidentes encontrados por RBT: " + ans[0]);
						
						for(int i = 1; i < ans.length; i++)
						{
							view.printMessage("Accidentes de severidad " + (i) + " en RBT: " + ans[i]);
						}
						
						System.out.println("Tiempo total de búsqueda RBT: " + duration + " milisegundos");
						
						view.printMessage("Accidentes encontrados por BST: " + ans1[0]);
						
						for(int i = 1; i < ans1.length; i++)
						{
							view.printMessage("Accidentes de severidad " + (i) + " en BST: " + ans1[i]);
						}
						System.out.println("Tiempo total de búsqueda BST: " + duration1 + " milisegundos");
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
	
	public void printMessage(String mensaje) {
		view.printMessage(mensaje);
	}
}

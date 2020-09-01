package view;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("----------");
			System.out.println("1. Cargar lista de peliculas como Lista Encadenada");
			System.out.println("2. Cargar lista de peliculas como Arreglo");
			System.out.println("3. Encontrar las peores peliculas");
			System.out.println("4. Salir");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
}

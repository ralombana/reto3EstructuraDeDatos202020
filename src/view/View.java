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
			System.out.println("2. Encontrar buenas peliculas");
			System.out.println("3. Nada aun");
			System.out.println("4. Nada aun");
			System.out.println("5. Conocer a un actor");
			System.out.println("6. Entender un género cinematográfico");
			System.out.println("7. Nada aun");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
}

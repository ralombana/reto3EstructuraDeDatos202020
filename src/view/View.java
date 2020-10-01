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
			System.out.println("1. Cargar lista de peliculas");
			System.out.println("2. Conocer casa productora (Linear Probing)");
			System.out.println("3. Conocer a un director");
			System.out.println("4. Conocer a un actor");
			System.out.println("5. Entneder un genero cinematografico");
			System.out.println("6. Encontrar peliculas por pais");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
}

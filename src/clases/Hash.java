package clases;

public class Hash {
	
	public Hash() {
		
	}
	
	public int funcionHash(String llaveACambiar, int tamañoLista, int tamañoSiguientePrimo)
	{
		int rta = Math.abs(llaveACambiar.hashCode());
		rta = ((rta*darNumeroAlAzar(tamañoSiguientePrimo)+ darNumeroAlAzar(tamañoSiguientePrimo))% tamañoSiguientePrimo)%tamañoLista;
		return rta;
	}
	
	public int siguientePrimo(int num) 
	{
		num++;
		for (int i = 2; i < num; i++) 
		{
			if(num%i == 0) 
			{
				num++;
				i=2;
			} else 
			{
				continue;
			}
		}
		return num;
	}
	
	   
	public int darNumeroAlAzar(int tamañoSiguientePrimo){ 
     int max = tamañoSiguientePrimo; 
     int min = 1; 
     int range = max - min + 1; 
     int rta = 0;

     for (int i = 0; i < tamañoSiguientePrimo; i++) 
     { 
         rta = (int)(Math.random() * range) + min; 
     } 
    return rta;
 }
	
}

package clases;

public class ShellSort {

	public static void sort(Comparable[] array) {
		int salto,i,j,k;
		Comparable aux;
		salto = array.length/2;
		while(salto>0) {
			for (i=salto;i<array.length;i++) {
				j = i-salto;
				while(j>=0) {
					k = j+salto;
					if(array[j].compareTo(array[k])<0) {
						break;
					}
					else {
						aux = array[j];
						array[j]=array[k];
						array[k]=aux;
						j-=salto;
					}
				}
			}
			salto = salto/2;
		}
	}
}

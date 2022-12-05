import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Vector<Participante> participantes = new Vector();
        
        try {
        	participantes = GestionDeDatos.CargarDatos();
        }
        catch(Exception ex) {
        	System.out.println("No hay datos");
        }

    	String op = "";
        while(true) {
        	try {
        		Menu();
            	op = scan.next();
        		if(ValidarOpcion(op)==true) {
        		switch(op) {

    				case "1":
    					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
    					System.out.println("Por favor introduzca los datos del nuevo participante \nDe forma tal que cumpla con el siguiente orden");
    					System.out.println("Nombres-Apellidos-CI-Edad");
    					String nombres = scan.next();
    					String apellidos = scan.next();
    					String CI = scan.next();
    					String edadtemp = scan.next();
    		        	int edad = Integer.valueOf(edadtemp);
    		        	
    		        	participantes.add(new Participante(nombres,apellidos,CI,edad));
    		        break;
    		        
        			case "2":
        				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        				System.out.println("Por favor introduzca el numero del participante que quiere quitar");
        				VisualizarListado(participantes);
        				String posquitetemp = scan.next();
        				int posquite = Integer.valueOf(posquitetemp);
        				participantes.remove(posquite-1);
        			break;
        			
        			case "3":
        				VisualizarListado(participantes);
        			break;

        			case "4":
        				GestionDeDatos.GuardarDatos(participantes);
        				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        				System.out.println("La base datos se a guardado correctamente");
        			break;

        			case "5":
        				return;
        		}
        		}
        	}
        	catch(NumberFormatException ex1){
        		System.out.println("Ha introducido un valor incorrecto");
        	}
        	catch(Exception ex) {
        		System.out.println(ex.getMessage());
        	}

        }
	}
	
	public static void Menu() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Seleccione la opcion de su agrado que desee:");
		System.out.println("1-Agregar nuevo participante.");
		System.out.println("2-Suprimir un participante.");
		System.out.println("3-Visualizar listado.");
		System.out.println("4-Guardar datos.");
		System.out.println("5-Cerrar aplicacion.");
	}


	public static void VisualizarListado(Vector<Participante> participantes) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Listado de participante al evento");
        for(int i =0;i<participantes.size();i++) {
        	System.out.println((i+1)+"-"+participantes.get(i).nombres+" "+participantes.get(i).apellidos+
        			" "+participantes.get(i).CI+" "+participantes.get(i).edad);
        }
	}

	public static boolean ValidarOpcion(String n) {
		if(Integer.valueOf(n)>=1&&Integer.valueOf(n)<=5) {
			return true;
		}
		else {
			throw new InputMismatchException("Esa opcion no se encuentra");
		}
	}
}

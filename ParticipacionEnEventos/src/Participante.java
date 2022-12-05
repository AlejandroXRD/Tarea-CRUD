
public class Participante {
    protected String nombres;
    protected String apellidos;
    protected String CI;
    protected int edad;
    
    
    public Participante(){
    	nombres="";
        apellidos="";
        CI="";
        edad=0;
    }
    public Participante(String nombres,String apellidos,String CI,int edad){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.CI = CI;
        this.edad = edad;
    }
    
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class GestionDeDatos {
	static String direc ="C:\\basedatos.bin";

    public static void GuardarDatos(Vector<Participante> datos) throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(datos.size());
        
        for(int i =0;i<datos.size();i++){
            outStream.writeUTF(datos.get(i).nombres);
            outStream.writeUTF(datos.get(i).apellidos);
            outStream.writeUTF(datos.get(i).CI);
            outStream.writeInt(datos.get(i).edad);
        }

        outStream.flush();
        outStream.close();
    }

    public static Vector<Participante> CargarDatos() throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        Vector<Participante> participants = new Vector();
        
        for(int i =0;i<capacidad;i++){
            String nombre =InStream.readUTF();
            String apellido =InStream.readUTF();
            String CI =InStream.readUTF();
            int edad =InStream.readInt();

            participants.add(new Participante(nombre,apellido,CI,edad));
        }
        
        InStream.close();
        return participants;
    }
}

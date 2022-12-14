/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author AlejandroXRD
 */
public class BaseDeDatos {
    static String direc = "C:\\dataAlejo.bin";
    //GuardarDatos de CLIENTES
    public static void GuardarDatos(Vector<Participante> datos) throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(datos.size());
        
        for(int i =0;i<datos.size();i++){
            outStream.writeUTF(datos.get(i).getNombres());
            outStream.writeUTF(datos.get(i).getApellidos());
            outStream.writeUTF(datos.get(i).getCi());
            outStream.writeUTF(datos.get(i).getDireccion());
        }
        
        outStream.flush();
        outStream.close();
    }
    //CargarDatos de CLIENTES
    public static Vector<Participante> CargarDatos() throws FileNotFoundException,IOException,ClassNotFoundException{
        File file = new File(direc);
        Vector<Participante> participantes=new Vector<Participante>();
        
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        for(int i =0;i<capacidad;i++){
            String nombre = InStream.readUTF();
            String apellido = InStream.readUTF();
            String ci = InStream.readUTF();
            String direc = InStream.readUTF();
            Participante info =new Participante(nombre,apellido,ci,direc);
            
            participantes.add(info);
        }
        
        InStream.close();
        return participantes;
        
    }
    public static Vector<Participante> RegistrarParticipante(Participante info, Vector<Participante> participantes) throws Exception{
        for(int i =0;i<participantes.size();i++){
            if(participantes.get(i).getCi().equals(info.getCi())){
                throw new Exception("Ya se encuentra el CI del participante");
            }
        }
        participantes.add(info);
        GuardarDatos(participantes);
        return participantes;
    }
    public static Vector<Participante> BorrarParticipante(String CI,Vector<Participante> participantes)throws Exception{
        for(int i =0;i<participantes.size();i++){
            if(participantes.get(i).getCi().equals(CI)){
                participantes.remove(i);
                return participantes;
            }
        }
        throw new Exception("No se encuentra el particpante");
    }
}

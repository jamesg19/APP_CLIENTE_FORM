/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComunicacionHTTP;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JTextArea;


public class ServidorRecibe extends Conexion2 //Se hereda de conexión para hacer uso de los sockets y demás
{
    private String codigo;
    private String Respuesta;
    public ServidorRecibe() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer(JTextArea j)//Método para iniciar el servidor
    {
        //ejecuta
        
        while(true){
        try
        {

            cs2 = ss2.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            salidaCliente2 = new DataOutputStream(cs2.getOutputStream());

            DataInputStream flujo_entrada = new DataInputStream(cs2.getInputStream());
            
            while((mensajeServidor2 = flujo_entrada.readUTF()) != null) //Mientras haya mensajes desde el cliente
            {
                Respuesta=mensajeServidor2; 
                j.append(mensajeServidor2);
                //System.out.println("LLEGAAA");      
                System.out.println(mensajeServidor2);
            }

            //ss.close();//Se finaliza la conexión con el cliente
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
        }
    }
}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }

    public String getMensajeServidor2() {
        return mensajeServidor2;
    }

    public void setMensajeServidor2(String mensajeServidor2) {
        this.mensajeServidor2 = mensajeServidor2;
    }
    
    
    
}
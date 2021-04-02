/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ComunicacionHTTP;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion
{
    //http://localhost/Formularios/recibeHTTP
    private final int PUERTO = 1212; //Puerto para la conexión
    private final int PUERTO2 = 1313;
    private final String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected String mensajeServidor2; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected ServerSocket ss2; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected Socket cs2;
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
    protected DataOutputStream salidaServidor2, salidaCliente2; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            //ss2 = new ServerSocket(PUERTO2);
            cs = new Socket(); //Socket para el cliente
            //cs2 = new Socket();
        }
        else
        {
            cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
            //cs2 = new Socket(HOST, PUERTO2);
        }
    }
}
package ComunicacionHTTP;

import com.mycompany.proyecto.Editor;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author James
 */
public class EnviarHTTP implements Serializable {

    ArrayList<String> respuestServidor = new ArrayList<String>();
    private String CodigoIndigo;
    private String RespuestaServidor;
    private String respuesta;

    public EnviarHTTP(String CodigoIndigo) {
        this.CodigoIndigo = CodigoIndigo;
    }

    public void EnviarDatosServidor(String cod) {
//        try {
//            String UsuarioLogueado = "JAMES";
//            //System.out.println(peticion.GET(""));
//            HttpClient httpclient = HttpClients.createDefault();
//            HttpPost httppost = new HttpPost("http://localhost/Formularios/recibeHTTP");
//
//// Request parameters and other properties.
//            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//            params.add(new BasicNameValuePair("Usuario", "JAMES"));
//            params.add(new BasicNameValuePair("UsuarioP", "JAMES"));
//            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//
//            //Execute and get the response.
//            HttpResponse response = httpclient.execute(httppost);
//            HttpEntity entity = response.getEntity();
//
//            if (entity != null) {
//                try (InputStream instream = entity.getContent()) {
//
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR AL ENVIAR DATOS EN CLASE: \"EnviarHTTP\" metodo:\"EnviarDatosServidor\"");
//
//        }
    }
    //recibe.startServer();
    public void EnviarCodigo(String code) throws IOException{
        //ServidorRecibe recibe = new ServidorRecibe(); 
        //recibe.startServer();
        Cliente cli = new Cliente(); //Se crea el cliente
        //recibe.startServer();
        System.out.println("Iniciando cliente\n");
        cli.startClient(code); //Se inicia el cliente
        //respuesta=recibe.getRespuesta();
    }


//    ///REEECIBIR RESPUESTA
//    @Override
//    public void run() {
//        //ESPERA UNA RESPUESTA TAMBIEN
//        System.out.println("ESCUCHA");
//
//        while (true) {
//            try {
//                ServerSocket servidor = new ServerSocket(9998);
//                Socket misocket = servidor.accept();
//                DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
//                String mensaje = flujo_entrada.readUTF();
//                RespuestaServidor += mensaje;
////            mostrar.append("\n"+mensaje);
//                misocket.close();
//
//            } catch (IOException ex) {
//                Logger.getLogger(EnviarHTTP.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//
////        try {
////            String serverURL = "http://localhost/Formularios/recibeHTTP";
////            final URL url = new URL(serverURL);
////            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
////            connection.setDoOutput(true);
////            connection.setRequestMethod("POST");
////            final BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
////            
////            for(int i=0;i<4;i++){
////                System.out.println("metodo "+br.readLine());
////                
////            }
////            respuestServidor.add(br.readLine());
////        } catch (Exception e) {
////            System.out.println("EEORR EN CLASE ENVIAR HTTP EN RUN: "+e);
////        }
//    }

    public ArrayList<String> getRespuestServidor() {
        return respuestServidor;
    }

    public void setRespuestServidor(ArrayList<String> respuestServidor) {
        this.respuestServidor = respuestServidor;
    }

    public String getRespuestaServidor() {
        return RespuestaServidor;
    }

    public void setRespuestaServidor(String RespuestaServidor) {
        this.RespuestaServidor = RespuestaServidor;
    }

    public String getCodigoIndigo() {
        return CodigoIndigo;
    }

    public void setCodigoIndigo(String CodigoIndigo) {
        this.CodigoIndigo = CodigoIndigo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}

import java.net.InetAddress;
import java.net.UnknownHostException;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {


                try {
                    // 1 - Crear un socket de tipo cliente indicando IP y puerto del servidor
                    System.out.println("Estableciendo conexión con el servidor");
                    Socket cliente = new Socket("localhost", 50000);




                    // 2 - Abrir flujos de lectura y escritura
                    InputStream is = cliente.getInputStream();
                    OutputStream os = cliente.getOutputStream();

                    // 3 - Intercambiar datos con el servidor
                    // Envío de mensaje de texto al servidor
                    OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write("Soy el cliente. Envío este mensaje al servidor");
                    bw.newLine();
                    bw.flush();

                    // Leo mensajes que me envía el servidor
                    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                    BufferedReader br = new BufferedReader(isr);
                    System.out.println("El servidor me envía el siguiente mensaje: " + br.readLine());

                    // 4 - Cerrar flujos de lectura y escritura
                    br.close();
                    isr.close();
                    is.close();
                    bw.close();
                    osw.close();
                    os.close();

                    // 5 - Cerrar la conexión
                    System.out.println("Se cierra la conexión del cliente");
                    cliente.close();

                } catch (UnknownHostException e) {
                    System.err.println("No se encuentra el host especificado.");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.err.println("Se ha producido un error en la conexión con el servidor.");
                    e.printStackTrace();
                }

            }
 }

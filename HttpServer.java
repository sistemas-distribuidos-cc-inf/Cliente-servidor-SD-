import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int port = 8082;
	    ServerSocket serverSocket = new ServerSocket(port);
	    System.err.println("O server esta rodando na porta : " + port);

	    // esperando pela conexao
	    while (true) {
	        // Aceita uma nova conexao
	        Socket clientSocket = serverSocket.accept();
	        System.err.println("Um novo cliente connectou");
	        
	        //Monta os buffers de entrada e saida
	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
	        
	        //Faz a leitura do buffer de entrada
	        String s;
	        while ((s = in.readLine()) != null) {
	            System.out.println(s);
	            if (s.isEmpty()) {
	                break;
	            }
	        }
	        //Escreve a pagina de saida
	        out.write("HTTP/1.0 200 OK\r\n");
	        out.write("Date: Fri, 31 Set 2017 23:59:59 GMT\r\n");
	        out.write("Server: Apache/0.8.4\r\n");
	        out.write("Content-Type: text/html\r\n");
	        out.write("Content-Length: 59\r\n");
	        out.write("Expires: Sat, 01 Out 2017 00:59:59 GMT\r\n");
	        out.write("Last-modified: Fri, 09 Out 2017 14:21:40 GMT\r\n");
	        out.write("\r\n");
	        out.write("<TITLE>ServerHTTP</TITLE>");
	        out.write("<P>Servidor teste HTTPServer</P>");

	        //Fecha a conexão e encerra o request.
	        System.err.println("Conexão encerrada");
	        out.close();
	        in.close();
	        clientSocket.close();
	    }
	}

}


package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}

	private String OS() {
		return System.getProperty("os.name");
	}

	public void exibeDistro() {
		
		try {
			if (this.OS().equals("Linux")) {
				Process p = Runtime.getRuntime().exec("cat /etc/os-release");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader supLeitor = new BufferedReader(leitor);
				String linha = supLeitor.readLine();
				StringBuffer dados = new StringBuffer(); 
				while(linha != null) {
					if (linha.contains("PRETTY")) {
						dados.append(linha);
						dados.append("\n");
					}
					linha = supLeitor.readLine();
				}
				String[] nv = dados.toString().split("=");
				System.out.println(nv[1].replace("\"", ""));
			} else {
				System.out.println("Não é Linux :(");
			}
		}catch(Exception e) {e.printStackTrace();}
	}
}

package com.lib.system;

import com.lib.system.repositories.ClientRepository;
import com.lib.system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);


//		Transforming PDF into byte array and encoding it
//		Path pdfPath = Paths.get("C:\\Users\\steff\\Desktop\\pdfBooks\\descarca-markus-zusak-hotul-de-carti.pdf");
//		byte[] pdf = Files.readAllBytes(pdfPath);
//		byte[] pdfEncoded = java.util.Base64.getEncoder().encode(pdf);
//		System.out.println(pdfEncoded);
//		System.out.println(pdf);

//		Transforming byte array into PDF
//		OutputStream out = new FileOutputStream("C:\\Users\\steff\\Desktop\\pdfBooks\\out1.pdf");
//		out.write(pdf);
//		out.close();



	}

}

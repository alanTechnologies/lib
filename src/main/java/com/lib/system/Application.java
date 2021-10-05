package com.lib.system;

import com.lib.domain.dto.BookDTO;
import liquibase.pro.packaged.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

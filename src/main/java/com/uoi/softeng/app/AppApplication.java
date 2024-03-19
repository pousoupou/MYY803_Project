package com.uoi.softeng.app;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.uoi.softeng.app.model.Book;
import com.uoi.softeng.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppApplication {

	@Autowired
	BookRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		List<List<String>> records = new ArrayList<List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("C:/Users/steli/Desktop/Books.csv"));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				records.add(Arrays.asList(values));
			}
		} catch(FileNotFoundException e){
            throw new RuntimeException(e);
        } catch(IOException | CsvValidationException e){
            throw new RuntimeException(e);
        }

		for(int i = 0; i < records.size(); i++){
			Book book = new Book();

			List<String> list = records.get(i);
			while(!list.isEmpty()){
				book.setIsbn(Integer.valueOf(list.getFirst()));
				book.setAuthor(list.get(2));

			}
		}
    }

}

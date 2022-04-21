package com.santander.pocdistressed.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FileService {
	
	@Value("${file.upload-dir}")
	String fileDirectory;
	
	public String fileUpload(MultipartFile file1, MultipartFile file2, MultipartFile file3) throws Exception {
		
	
	/*	File myFile = new File(fileDirectory+file1.getOriginalFilename());
		myFile.createNewFile();
		FileOutputStream fos1 = new FileOutputStream(myFile);
		fos1.write(file1.getBytes());
		fos1.close();
		
		*/
		boolean isFile1Uploaded = false;
		boolean isFile2Uploaded = false;
		boolean isFile3Uploaded = false;
		
		File fileToUpload1 = new File(fileDirectory + File.separator + file1.getOriginalFilename());
		File fileToUpload2 = new File(fileDirectory + File.separator + file2.getOriginalFilename());
		File fileToUpload3 = new File(fileDirectory + File.separator + file3.getOriginalFilename());
		
		try (FileOutputStream fos = new FileOutputStream(fileToUpload1)){
			
			fos.write(file1.getBytes());
			isFile1Uploaded = true;
			log.info("Fichero 1 guardado correctamente");
		} catch (IOException e){
			log.error("Error al guardar el fichero 1");
        }
		
		try (FileOutputStream fos = new FileOutputStream(fileToUpload2)){
			fos.write(file2.getBytes());
			isFile2Uploaded = true;
			log.info("Fichero 2 guardado correctamente");
			
		} catch (IOException e){
			log.error("Error al guardar el fichero 2");
        }
		
		try (FileOutputStream fos = new FileOutputStream(fileToUpload3)){
			fos.write(file3.getBytes());
			isFile3Uploaded = true;
			log.info("Fichero 3 guardado correctamente");
			
		} catch (IOException e){
			log.error("Error al guardar el fichero 3");
        }
		
		return (isFile1Uploaded && isFile2Uploaded && isFile3Uploaded) ? "Ficheros cargados correctamente": "Error al cargar los ficheros";
	}

}

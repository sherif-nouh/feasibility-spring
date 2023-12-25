package com.feas.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.feas.service.ifc.FilesStorageService;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

	 // private String dirctory=new String("/home/ftpuser/") ;
	  private String dirctory="E:\\appdocument\\" ;

	  //private final Path root = Paths.get(dirctory.toString());
	  private Path root = Paths.get(dirctory.toString());

	
	  @Override
	  public void init() {
		  root = Paths.get(dirctory.toString());
	    try {
	   
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }

	  @Override
	  public void save(MultipartFile file) {
		  root = Paths.get(dirctory.toString());
	    try {
	      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }

	  @Override
	  public Resource load(String filename) {
		  root = Paths.get(dirctory.toString());
	    try {
	      Path file = root.resolve(filename);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	  @Override
	  public void deleteAll() {
		  root = Paths.get(dirctory.toString());
	    FileSystemUtils.deleteRecursively(root.toFile());
	  }

	  @Override
	  public Stream<Path> loadAll() {
		  root = Paths.get(dirctory.toString());
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }

	@Override
	public void saveWithName(MultipartFile file, String fileName) {
	 root = Paths.get(dirctory.toString());
	 System.err.println(root.toString());
		 try {
		      Files.copy(file.getInputStream(), this.root.resolve(fileName));
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
		
	}

	@Override
	public void setDirectory(String dir) {
      this.dirctory=dir;		
	}

	

}

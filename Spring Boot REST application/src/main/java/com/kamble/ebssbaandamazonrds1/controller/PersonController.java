package com.kamble.ebssbaandamazonrds1.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import com.kamble.ebssbaandamazonrds1.model.ImageModel;
import com.kamble.ebssbaandamazonrds1.model.Person;
import com.kamble.ebssbaandamazonrds1.repository.ImageRepo;
import com.kamble.ebssbaandamazonrds1.repository.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    ImageRepo imageRepo;

    // default url
    @GetMapping("/")
    public String hello() {
        return "Welcome to EBS deployed Spring Boot and Amazon RDS (MySQL) application";
    }

    // Create
    @PostMapping("persons")
    public Person savePerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    // @PostMapping("persons/image/{id}")
    // public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file,
    // @PathVariable("id") String id)
    // throws IOException {

    // System.out.println("Original Image Byte Size - " + file.getBytes().length);
    // ImageModel img = new ImageModel(Integer.parseInt(id),
    // file.getOriginalFilename(), file.getContentType(),
    // compressBytes(file.getBytes()));
    // imageRepo.save(img);
    // return ResponseEntity.status(HttpStatus.OK);
    // }

    // Read one
    @GetMapping("persons/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return personRepo.findById(id).get();
    }

    // Real all
    @GetMapping("persons")
    public List<Person> getPersons() {
        return personRepo.findAll();
    }

    // Update
    @PutMapping("persons")
    public Person updatePerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    // Delete
    @DeleteMapping("persons/{id}")
    public Person deletePerson(@PathVariable("id") int id) {
        Person person = personRepo.findById(id).get();

        personRepo.delete(person);
        return person;
    }

    // Services
    // compress the image bytes before storing it in the database
    // public static byte[] compressBytes(byte[] data) {
    // Deflater deflater = new Deflater();
    // deflater.setInput(data);
    // deflater.finish();

    // ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    // byte[] buffer = new byte[1024];
    // while (!deflater.finished()) {
    // int count = deflater.deflate(buffer);
    // outputStream.write(buffer, 0, count);
    // }
    // try {
    // outputStream.close();
    // } catch (IOException e) {
    // }
    // System.out.println("Compressed Image Byte Size - " +
    // outputStream.toByteArray().length);

    // return outputStream.toByteArray();
    // }

}

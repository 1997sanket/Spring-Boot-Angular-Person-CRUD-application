package com.kamble.ebssbaandamazonrds1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {

    @Id
    private int id;
    private String name;
    private String type;

    // image bytes can have large lengths so we specify a value
    // which is more than the default length for picByte column
    private byte[] picByte;
}

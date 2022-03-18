package com.hieu.backend.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
	@GetMapping(value = "/getImage/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response, @PathVariable String name) throws IOException {

		ClassPathResource imgFile = new ClassPathResource("image/" + name);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
}

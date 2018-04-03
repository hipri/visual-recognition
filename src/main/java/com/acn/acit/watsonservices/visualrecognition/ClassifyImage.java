package com.acn.acit.watsonservices.visualrecognition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class ClassifyImage {
	public static void main(String[] args) throws FileNotFoundException {
		VisualRecognition service = new VisualRecognition("2016-05-20");
		service.setApiKey("49f542b42eec9fdcb004e54c546a1b9d44fb6634");

		InputStream imagesStream = new FileInputStream("./fruitbowl.jpg");
		ClassifyOptions classifyOptions = new ClassifyOptions.Builder().imagesFile(imagesStream)
				.imagesFilename("fruitbowl.jpg").threshold((float) 0.6).owners(Arrays.asList("IBM")).build();
		ClassifiedImages result = service.classify(classifyOptions).execute();
		System.out.println(result);
	}
}

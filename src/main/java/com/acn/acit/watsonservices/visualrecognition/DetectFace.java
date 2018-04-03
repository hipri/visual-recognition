package com.acn.acit.watsonservices.visualrecognition;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;

public class DetectFace {
	public static void main(String[] args) throws FileNotFoundException {
		VisualRecognition service = new VisualRecognition("2016-05-20");
		service.setApiKey("49f542b42eec9fdcb004e54c546a1b9d44fb6634");

		DetectFacesOptions detectFacesOptions = new DetectFacesOptions.Builder()
				.imagesFile(new File("./gremlin.jpg")).build();
		DetectedFaces result = service.detectFaces(detectFacesOptions).execute();
		System.out.println(result);
	}
}

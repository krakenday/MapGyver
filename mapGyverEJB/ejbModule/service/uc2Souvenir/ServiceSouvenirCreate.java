package service.uc2Souvenir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import business.uc2Souvenir.Photo;
import business.uc2Souvenir.Souvenir;
import dao.DaoFacade;

@Singleton
@LocalBean
public class ServiceSouvenirCreate {
	
	@EJB
	private DaoFacade daoFacade;

	public void create(Souvenir souvenir) {
		System.out.println("*****service.ServiceSouvenirCreate-create");
		daoFacade.createSouvenir(souvenir);
	}
		
		
		//TODO CODE POUR SAVE SUR AMAZON S3
//		//TODO controles instance of ...
//		Photo photo;
//		byte[] byteContent;
//		InputStream fileContent;
//		Long contentLenght = null;
//		
//		
//		
//		photo = (Photo) souvenir;
//		
//		byteContent = photo.getFileContent();
//		
//		fileContent = new ByteArrayInputStream(byteContent);
//		
//		try {
//			contentLenght =(long) fileContent.available();
//		} catch (IOException e) {
//			System.out.println("ServiceSouvenirCreate-create : dans le catch");
//			e.printStackTrace();
//		}
//		
//		uploadPhotoToS3(photo.getNom(), contentLenght, fileContent);
//		
//	}
//	
//	
//	
//
//	//TODO verif Keyname est unique Ou ajouter date avec nanosec
//	private void uploadPhotoToS3(String fileObjKeyName, Long contentLength, InputStream fileContent) {
//		
//		 try {
//	    	 String clientRegion = "eu-west-3";
//	         String bucketName = "fr.mapgyver";
//	         
//	    	 AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//	    			 					.withRegion(clientRegion)
//	    			 					.withCredentials(new EnvironmentVariableCredentialsProvider())
//	    			 					.build();
//	         
//	         System.out.println("UploadObj... etape 1 ok");
//	         
//	         ObjectMetadata metadata = new ObjectMetadata();
//	         metadata.setContentType("image/jpeg");
//	         metadata.setContentLength(contentLength);
//	     
//	         // Upload a text string as a new object.
//	         //s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");
//	         
//	         // Upload a file as a new object with ContentType and title specified.
//	         PutObjectRequest 	request = new PutObjectRequest(bucketName, fileObjKeyName, fileContent, metadata);
//	         					request.setCannedAcl(CannedAccessControlList.PublicRead);
//	         					
//	         System.out.println("UploadObj... etape 2 ok");
//	         s3Client.putObject(request);
//	     }
//	     catch(AmazonServiceException e) {
//	         // The call was transmitted successfully, but Amazon S3 couldn't process 
//	         // it, so it returned an error response.
//	         e.printStackTrace();
//	     }
//	     catch(SdkClientException e) {
//	         // Amazon S3 couldn't be contacted for a response, or the client
//	         // couldn't parse the response from Amazon S3.
//	         e.printStackTrace();
//	     }
//


}

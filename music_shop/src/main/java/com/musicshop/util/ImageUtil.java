package com.musicshop.util;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class ImageUtil {
	public String getImageNameFromPart(Part part) {
		try {
			String contentDisp = part.getHeader("content-disposition");
			System.out.println("DEBUG: Content disposition: " + contentDisp);

			String[] items = contentDisp.split(";");
			String imageName = null;

			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					imageName = s.substring(s.indexOf("=") + 2, s.length() - 1);
					System.out.println("DEBUG: Found filename: " + imageName);
				}
			}

			if (imageName == null || imageName.isEmpty()) {
				System.out.println("DEBUG: No filename found, using default");
				imageName = "default.png";
			}

			return imageName;
		} catch (Exception e) {
			System.err.println("ERROR in getImageNameFromPart: " + e.getMessage());
			e.printStackTrace();
			return "default.png";
		}
	}

	/**
	 * Uploads the image file from the given {@link Part} object to a specified
	 * directory on the server.
	 * 
	 * <p>
	 * This method ensures that the directory where the file will be saved exists
	 * and creates it if necessary. It writes the uploaded file to the server's file
	 * system. Returns {@code true} if the upload is successful, and {@code false}
	 * otherwise.
	 * </p>
	 * 
	 * @param part the {@link Part} object representing the uploaded image file.
	 * @return {@code true} if the file was successfully uploaded, {@code false}
	 *         otherwise.
	 */
	public boolean uploadImage(Part part, String rootPath, String saveFolder) {
		try {
			System.out.println("DEBUG: Starting image upload process");
			
			// Get the workspace path from the rootPath parameter
			String workspacePath = rootPath;
			if (workspacePath == null || workspacePath.isEmpty()) {
				// Fallback to a known good path if rootPath is not provided
				workspacePath = "C:" + File.separator + "Users" + File.separator + "SS" + File.separator + "eclipse-workspace";
			}
			
			String projectPath = workspacePath + File.separator + "music_shop";
			String webappPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp";
			String resourcesPath = webappPath + File.separator + "resources";
			String imagesPath = resourcesPath + File.separator + "imagesuser";
			
			System.out.println("DEBUG: Using workspace path: " + workspacePath);
			System.out.println("DEBUG: Project path: " + projectPath);
			System.out.println("DEBUG: Webapp path: " + webappPath);
			System.out.println("DEBUG: Resources path: " + resourcesPath);
			System.out.println("DEBUG: Images path: " + imagesPath);
			
			// Create all necessary directories
			File resourcesDir = new File(resourcesPath);
			File imagesDir = new File(imagesPath);
			
			// Create parent directories if they don't exist
			if (!resourcesDir.exists()) {
				System.out.println("DEBUG: Creating resources directory");
				if (!resourcesDir.mkdirs()) {
					System.err.println("ERROR: Failed to create resources directory");
					System.err.println("Resources dir path: " + resourcesDir.getAbsolutePath());
					System.err.println("Parent exists: " + (resourcesDir.getParentFile() != null ? resourcesDir.getParentFile().exists() : "no parent"));
					System.err.println("Parent writable: " + (resourcesDir.getParentFile() != null ? resourcesDir.getParentFile().canWrite() : "no parent"));
					return false;
				}
			}
			
			if (!imagesDir.exists()) {
				System.out.println("DEBUG: Creating images directory");
				if (!imagesDir.mkdirs()) {
					System.err.println("ERROR: Failed to create images directory");
					System.err.println("Images dir path: " + imagesDir.getAbsolutePath());
					System.err.println("Parent exists: " + (imagesDir.getParentFile() != null ? imagesDir.getParentFile().exists() : "no parent"));
					System.err.println("Parent writable: " + (imagesDir.getParentFile() != null ? imagesDir.getParentFile().canWrite() : "no parent"));
					return false;
				}
			}
			
			// Verify directories exist and are writable
			System.out.println("DEBUG: Checking directories:");
			System.out.println("Resources dir exists: " + resourcesDir.exists());
			System.out.println("Resources dir writable: " + resourcesDir.canWrite());
			System.out.println("Images dir exists: " + imagesDir.exists());
			System.out.println("Images dir writable: " + imagesDir.canWrite());
			
			// Get the filename and create the full path
			String fileName = getImageNameFromPart(part);
			String filePath = imagesPath + File.separator + fileName;
			System.out.println("DEBUG: Will save file to: " + filePath);
			
			// Write the file
			System.out.println("DEBUG: Writing file...");
			part.write(filePath);
			
			// Verify the file was created
			File uploadedFile = new File(filePath);
			if (!uploadedFile.exists()) {
				System.err.println("ERROR: File was not created: " + filePath);
				return false;
			}
			
			System.out.println("DEBUG: Image upload successful to: " + filePath);
			return true;
			
		} catch (IOException e) {
			System.err.println("ERROR: Failed to upload image: " + e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.err.println("ERROR: Unexpected error during image upload: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}

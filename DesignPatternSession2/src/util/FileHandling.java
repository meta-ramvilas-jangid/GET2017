package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {
	private static FileHandling fileHandling;

	public static FileHandling getInstance() {
		if (fileHandling == null) {
			synchronized (FileHandling.class) {
				if (fileHandling == null) {
					fileHandling = new FileHandling();
				}
			}
		}

		return fileHandling;
	}


	public List<String> read(String filePath) {
		List<String> l = new ArrayList<String>();
		try {
			l = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
		}

		return l;
	}

	public void write(String billDetails, String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath + "'s bill.txt")));
			bw.write(billDetails);
			bw.close();
		} catch (Exception e) {
		}
	}
}

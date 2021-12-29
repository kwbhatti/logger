package com.chimpcentral.logger;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.io.FlatFile;

public class SourceFile extends FlatFile {

	public SourceFile(String resourcesDir, String filename) throws IOException {
		super(resourcesDir + "/" + filename, FileStatus.EXISTING);
	}

}

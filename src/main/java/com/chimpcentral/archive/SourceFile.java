package com.chimpcentral.archive;

import java.io.IOException;

import com.chimpcentral.io.FileStatus;
import com.chimpcentral.io.FlatFile;

class SourceFile extends FlatFile {

	SourceFile(String resourcesDir, String filename) throws IOException {
		super(resourcesDir + "/" + filename, FileStatus.EXISTING);
	}

}

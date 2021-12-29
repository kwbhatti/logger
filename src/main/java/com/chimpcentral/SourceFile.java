package com.chimpcentral;

import java.io.IOException;

public class SourceFile extends FlatFile {

	public SourceFile(String resourcesDir, String filename) throws IOException {
		super(resourcesDir + "/" + filename, FileStatus.EXISTING);
	}

}

package de.codeshelf.gitvillage;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;

/**
 * Author: Andreas Wegmann
 * Date: 27.02.17
 */
public class TemporaryTestRepository implements AutoCloseable {
  private File localPath;
  private Git gitObject;

  public TemporaryTestRepository(String dirname) throws IOException, GitAPIException {

    localPath = File.createTempFile(dirname, "");
    if (!localPath.delete()) {
      throw new IOException("error cleaning temporary directory " + localPath);
    }

    // create the directory
    gitObject = Git.init().setDirectory(localPath).call();
  }

  @Override
  public void close() throws Exception {
    FileUtils.deleteDirectory(localPath);
  }

  public Git getGitObject() {
    return gitObject;
  }


  public void createInitialCommitWithDummyFile() throws IOException, GitAPIException {
    // create the file
    File testfile = new File(localPath, "testfile");
    if (!testfile.createNewFile()) {
      throw new IOException("Could not create testfile " + testfile);
    }

    gitObject.add().addFilepattern("testfile").call();
    gitObject.commit().setMessage("Added testfile").call();
  }
}

package de.codeshelf.gitvillage.errors;

import org.eclipse.jgit.api.errors.GitAPIException;

/**
 * Author: Andreas Wegmann
 * Date: 28.02.17
 */
public class GitVillageException extends Exception {
  public GitVillageException(String msg) {
    super(msg);
  }

  public GitVillageException(String msg, Throwable throwable) {
    super(msg,throwable);
  }
}

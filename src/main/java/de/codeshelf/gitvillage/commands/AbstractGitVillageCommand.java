package de.codeshelf.gitvillage.commands;

import de.codeshelf.gitvillage.GitVillage;
import de.codeshelf.gitvillage.errors.GitVillageException;

/**
 * Author: Andreas Wegmann
 * Date: 26.02.17
 */
public abstract class AbstractGitVillageCommand {

  protected GitVillage gitVillage;

  public abstract GitVillage call() throws GitVillageException;

  protected abstract void checkPreconditions() throws GitVillageException;

  public AbstractGitVillageCommand(GitVillage gitVillage) {
    this.gitVillage = gitVillage;
  }
}

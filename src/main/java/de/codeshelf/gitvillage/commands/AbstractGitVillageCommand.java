package de.codeshelf.gitvillage.commands;

import de.codeshelf.gitvillage.GitVillage;

/**
 * Author: Andreas Wegmann
 * Date: 26.02.17
 */
public abstract class AbstractGitVillageCommand {

  protected GitVillage gitVillage;

  public abstract GitVillage call();

  public AbstractGitVillageCommand(GitVillage gitVillage) {
    this.gitVillage = gitVillage;
  }
}

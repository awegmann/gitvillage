package de.codeshelf.gitvillage.commands.maintenance;

import de.codeshelf.gitvillage.GitVillage;
import de.codeshelf.gitvillage.commands.AbstractGitVillageCommand;

/**
 * Author: Andreas Wegmann
 * Date: 26.02.17
 */
public class RenameBranchCommand extends AbstractGitVillageCommand {
  public RenameBranchCommand(GitVillage gitVillage) {
    super(gitVillage);
  }

  @Override
  public GitVillage call() {
    return gitVillage;
  }

  @Override
  protected void checkPreconditions() {

  }
}

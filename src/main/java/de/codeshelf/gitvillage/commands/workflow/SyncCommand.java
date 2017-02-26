package de.codeshelf.gitvillage.commands.workflow;

import de.codeshelf.gitvillage.GitVillage;
import de.codeshelf.gitvillage.commands.AbstractGitVillageCommand;

/**
 * Author: Andreas Wegmann
 * Date: 26.02.17
 */
public class SyncCommand extends AbstractGitVillageCommand {
  public SyncCommand(GitVillage gitVillage) {
    super(gitVillage);
  }

  @Override
  public GitVillage call() {
    return gitVillage;
  }
}

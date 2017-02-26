package de.codeshelf.gitvillage.commands.workflow;

import de.codeshelf.gitvillage.GitVillage;
import de.codeshelf.gitvillage.commands.AbstractGitVillageCommand;

/**
 * Author: Andreas Wegmann
 * Date: 26.02.17
 */
public class HackCommand extends AbstractGitVillageCommand {
  private String name;

  public HackCommand(GitVillage gitVillage) {
    super(gitVillage);
  }

  @Override
  public GitVillage call() {
    return gitVillage;
  }

  public HackCommand setName(String name) {
    this.name = name;
    return this;
  }

  public HackCommand abortHack() {
    return this;
  }

  public HackCommand continueHack() {
    return this;
  }
}

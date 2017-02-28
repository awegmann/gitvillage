package de.codeshelf.gitvillage.commands.workflow;

import de.codeshelf.gitvillage.GitVillage;
import de.codeshelf.gitvillage.commands.AbstractGitVillageCommand;
import de.codeshelf.gitvillage.errors.GitVillageException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

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
  public GitVillage call() throws GitVillageException {
    checkPreconditions();
    return gitVillage;
  }

  @Override
  protected void checkPreconditions() throws GitVillageException {
    if (name == null) {
      throw new GitVillageException("no name given for git hack command.");
    }

    Git gitObject = gitVillage.getGitRepo();
    try {
      gitObject.fetch().setCheckFetchedObjects(true).call();
      gitObject.rebase().setUpstream("origin/master").call();
      gitObject.checkout().setName(name).call();
      
    } catch (GitAPIException e) {
      throw new GitVillageException("",e);
    }

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

/*
➜  gitvillage git:(master) git town-hack ahack

[master] git fetch --prune

[master] git rebase origin/master
Current branch master is up to date.

[master] git checkout -b ahack master
Switched to a new branch 'ahack'

[ahack] git push -u origin ahack
Total 0 (delta 0), reused 0 (delta 0)
To https://github.com/awegmann/gitvillage.git
 * [new branch]      ahack -> ahack
Branch ahack set up to track remote branch ahack from origin.

 */
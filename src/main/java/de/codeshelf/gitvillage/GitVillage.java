package de.codeshelf.gitvillage;

import de.codeshelf.gitvillage.commands.maintenance.*;
import de.codeshelf.gitvillage.commands.workflow.HackCommand;
import de.codeshelf.gitvillage.commands.workflow.NewPullRequestCommand;
import de.codeshelf.gitvillage.commands.workflow.ShipCommand;
import de.codeshelf.gitvillage.commands.workflow.SyncCommand;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;

/**
 * Author: Andreas Wegmann
 * Date: 26.02.17
 */
public class GitVillage {

  private Git gitRepo;

  private GitVillage(File gitRepoDir) throws IOException {
    gitRepo = Git.open(gitRepoDir);
  }

  private GitVillage(Git gitRepo) {
    this.gitRepo = gitRepo;
  }

  AppendCommand append() {
    return new AppendCommand(this);
  }

  KillCommand kill() {
    return new KillCommand(this);
  }

  PrependCommand prepend() {
    return new PrependCommand(this);
  }

  PruneBranchesCommand pruneBranches() {
    return new PruneBranchesCommand(this);
  }

  RenameBranchCommand renameBranch() {
    return new RenameBranchCommand(this);
  }

  HackCommand hack() {
    return new HackCommand(this);
  }

  NewPullRequestCommand newPullRequest() {
    return new NewPullRequestCommand(this);
  }

  ShipCommand ship() {
    return new ShipCommand(this);
  }

  SyncCommand sync() {
    return new SyncCommand(this);
  }

  public static GitVillage createVillage(Git gitObject) {
    return new GitVillage(gitObject);
  }
}

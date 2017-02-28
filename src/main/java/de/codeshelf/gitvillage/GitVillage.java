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

  public Git getGitRepo() {
    return gitRepo;
  }

  private Git gitRepo;

  private GitVillage(File gitRepoDir) throws IOException {
    gitRepo = Git.open(gitRepoDir);
  }

  private GitVillage(Git gitRepo) {
    this.gitRepo = gitRepo;
  }

  public AppendCommand append() {
    return new AppendCommand(this);
  }

  public KillCommand kill() {
    return new KillCommand(this);
  }

  public PrependCommand prepend() {
    return new PrependCommand(this);
  }

  public PruneBranchesCommand pruneBranches() {
    return new PruneBranchesCommand(this);
  }

  public RenameBranchCommand renameBranch() {
    return new RenameBranchCommand(this);
  }

  public HackCommand hack() {
    return new HackCommand(this);
  }

  public NewPullRequestCommand newPullRequest() {
    return new NewPullRequestCommand(this);
  }

  public ShipCommand ship() {
    return new ShipCommand(this);
  }

  public SyncCommand sync() {
    return new SyncCommand(this);
  }

  public static GitVillage createVillage(Git gitObject) {
    return new GitVillage(gitObject);
  }
}

package de.codeshelf.gitvillage.commands.workflow;

import de.codeshelf.gitvillage.GitVillage;
import de.codeshelf.gitvillage.TemporaryTestRepository;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

/**
 * Author: Andreas Wegmann
 * Date: 28.02.17
 */
public class HackCommandTest {
  Logger logger = LoggerFactory.getLogger(getClass());

  @Test
  public void testStartHack() {
    try (TemporaryTestRepository testRepository = new TemporaryTestRepository("testrepo")) {
      Git gitObject = testRepository.getGitObject();
      testRepository.createInitialCommitWithDummyFile();

      GitVillage gitVillage = GitVillage.createVillage(gitObject);
      gitVillage.hack().setName("ahack").call();
      assertEquals("ahack", gitObject.getRepository().getBranch());

      List<String> branches = gitObject.branchList().call().stream().map(n -> n.getName()).collect(Collectors.toList());
      assertThat(branches, hasItem("master"));
      assertThat(branches, hasItem("ahack"));

    } catch (GitAPIException e) {
      logger.error("", e);
    } catch (IOException e) {
      logger.error("", e);
    } catch (Exception e) {
      logger.error("", e);
    }
  }
}
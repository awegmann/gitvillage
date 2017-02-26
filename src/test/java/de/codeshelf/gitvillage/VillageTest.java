package de.codeshelf.gitvillage;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Author: Andreas Wegmann
 * Date: 27.02.17
 */
public class VillageTest {
  Logger logger = LoggerFactory.getLogger(getClass());
  
  @Test
  public void testCreateTempGitRepo() {
    try (TemporaryTestRepository testRepository = new TemporaryTestRepository("testrepo")) {
      File directory = testRepository.getGitObject().getRepository().getDirectory();
      logger.info("got directory "+directory);
      assertTrue(directory.isDirectory());
    } catch (GitAPIException e) {
      logger.error("",e);
    } catch (IOException e) {
      logger.error("",e);
    } catch (Exception e) {
      logger.error("",e);
    }
  }


  @Test
  public void testStartHack() {
    try (TemporaryTestRepository testRepository = new TemporaryTestRepository("testrepo")) {
      Git gitObject = testRepository.getGitObject();
      testRepository.createInitialCommitWithDummyFile();

      GitVillage gitVillage = GitVillage.createVillage(gitObject);
      gitVillage.hack().setName("ahack").call();
      assertEquals(gitObject.getRepository().getBranch(),"ahack");

      gitObject.branchList().call().forEach(b -> System.out.println(b.getName()));
      List<String> branches = gitObject.branchList().call().stream().map(n -> n.getName()).collect(Collectors.toList());
      assertThat(branches, hasItem("master"));

    } catch (GitAPIException e) {
      logger.error("",e);
    } catch (IOException e) {
      logger.error("",e);
    } catch (Exception e) {
      logger.error("",e);
    }
  }
}
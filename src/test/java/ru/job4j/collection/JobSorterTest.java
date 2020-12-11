package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobSorterTest {

    @Test
    public void whenSortByPriorityUp() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(new Job("X task", 0));
        expectedJobs.add(new Job("Fix bug", 1));
        expectedJobs.add(new Job("Fix bug", 2));
        expectedJobs.add(new Job("Fix bug", 4));
        Collections.sort(jobs, new JobSortByPriority());
        assertThat(jobs, is(expectedJobs));
    }

    @Test
    public void whenSortByPriorityDown() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(new Job("Fix bug", 4));
        expectedJobs.add(new Job("Fix bug", 2));
        expectedJobs.add(new Job("Fix bug", 1));
        expectedJobs.add(new Job("X task", 0));
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs, is(expectedJobs));
    }

    @Test
    public void whenSortByNameUp() {
        List<Job> jobs = Arrays.asList(
                new Job("A bug", 1),
                new Job("O bug", 4),
                new Job("D bug", 2),
                new Job("X task", 0)
        );
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(new Job("A bug", 1));
        expectedJobs.add(new Job("D bug", 2));
        expectedJobs.add(new Job("O bug", 4));
        expectedJobs.add(new Job("X task", 0));
        Collections.sort(jobs, new JobSortByName());
        assertThat(jobs, is(expectedJobs));
    }

    @Test
    public void whenSortByNameDown() {
        List<Job> jobs = Arrays.asList(
                new Job("A bug", 1),
                new Job("O bug", 4),
                new Job("D bug", 2),
                new Job("X task", 0)
        );
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(new Job("X task", 0));
        expectedJobs.add(new Job("O bug", 4));
        expectedJobs.add(new Job("D bug", 2));
        expectedJobs.add(new Job("A bug", 1));
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs, is(expectedJobs));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        System.out.println(rsl);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityUp() {
        Comparator<Job> cmpNamePriority = new JobSortByName()
                .thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)

        );
        System.out.println(rsl);
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityUpToSeconAction() {
        Comparator<Job> cmpNamePriority = new JobSortByName().
                thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Impl task", 1)

        );
        System.out.println(rsl);
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityDownToSeconAction() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Impl task", 1)

        );
        System.out.println(rsl);
        assertThat(rsl, lessThan(0));
    }

}
package edu.bo.app.asteroid_multiplayer_common;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class ListManagerTest {

    @Test
    public void AddingItemWithoutConductingAddingResultWithListWithZeroItems() {
        ListManager<Integer> listManager = new ListManager<>();

        listManager.add(12);
        assertThat(listManager.getList()
                              .size(),
                Matchers.comparesEqualTo(0));
    }

    @Test
    public void AddingItemAndConductingAddingResultWithListWithOneItems() {
        ListManager<Integer> listManager = new ListManager<>();

        listManager.add(12);
        listManager.conductAdding();
        assertThat(listManager.getList()
                              .size(),
                Matchers.comparesEqualTo(1));
    }

    @Test
    public void RemovingItemWithoutConductingRemovingShouldMakeNoChangesToList() {
        ListManager<Integer> listManager = new ListManager<>();

        listManager.add(12);
        listManager.conductAdding();

        listManager.remove(12);

        assertThat(listManager.getList()
                              .size(),
                Matchers.comparesEqualTo(1));
    }

    @Test
    public void RemovingItemAndConductingRemovingShouldRemomoveItemFromList() {
        ListManager<Integer> listManager = new ListManager<>();

        listManager.add(12);
        listManager.conductAdding();

        listManager.remove(12);
        listManager.conductRemoving();

        assertThat(listManager.getList()
                              .size(),
                Matchers.comparesEqualTo(0));
    }
}

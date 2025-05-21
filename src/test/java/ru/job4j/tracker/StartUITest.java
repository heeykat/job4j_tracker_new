package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StartUITest {

    @Test
    void whenFindItemByNameItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("test"));
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0", "test", "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        String info = item.toString();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show items by name" + ln
                        + "1. Finish the program" + ln
                        + "=== Showing items by name ===" + ln
                        + info + ln
                        + "Menu:" + ln
                        + "0. Show items by name" + ln
                        + "1. Finish the program" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void findItemById() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("test"));
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(item.getId()), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        String info = item.toString();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show the item by id" + ln
                        + "1. Finish the program" + ln
                        + "=== Showing the item by id ===" + ln
                        + info + ln
                        + "Menu:" + ln
                        + "0. Show the item by id" + ln
                        + "1. Finish the program" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(item.getId()), "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        assertThat(memTracker.findById(item.getId())).isNull();
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("test"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(item.getId()), replaceName, "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Change the item" + ln
                        + "1. Finish the program" + ln
                        + "=== Changing the item ===" + ln
                        + "Item has been changed successfully." + ln
                        + "Menu:" + ln
                        + "0. Change the item" + ln
                        + "1. Finish the program" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void whenFindAllItems() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("test"));
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0", "1"))
        );
        List<UserAction> actions = Arrays.asList(
                new FindAllAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        String info = item.toString();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Finish the program" + ln
                        + "=== Showing all items ===" + ln
                        + info + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Finish the program" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0", "Item name", "1"))
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("0"))
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "0. Finish the program" + System.lineSeparator()
                        + "=== The program has been finished ===" + System.lineSeparator()
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new ArrayList<>(Arrays.asList("1", "0"))
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Finish the program" + ln
                        + "Incorrect input, you can select actions from 0 to 0" + ln
                        + "Menu:" + ln
                        + "0. Finish the program" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input input = new ValidateInput(output,
                new MockInput(
                        new ArrayList<>(Arrays.asList("abc", "0")))
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Finish the program" + ln
                        + "Please, enter valid data" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input input = new ValidateInput(output,
                new MockInput(
                        new ArrayList<>(Arrays.asList("0")))
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction(output)
        );
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Finish the program" + ln
                        + "=== The program has been finished ===" + ln
        );
    }

    @Test
    void whenInvalidValidateInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new ArrayList<>(Arrays.asList("one", "1"))
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidValidateInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new ArrayList<>(Arrays.asList("1"))
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidValidateInputNegativeNumber() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new ArrayList<>(Arrays.asList("-4"))
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-4);
    }

    @Test
    void whenValidValidateInputMultiple() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new ArrayList<>(Arrays.asList("1", "2", "3"))
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }
}
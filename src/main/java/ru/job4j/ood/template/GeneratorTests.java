package ru.job4j.ood.template;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

@Disabled
public class GeneratorTests {
    Generator generator = new GeneratorImpl();

    @Test
    public void whenAllKeysProvidedThenTemplateIsFilled() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );

        String result = generator.produce(template, args);
        AssertionsForClassTypes.assertThat(result).isEqualTo("I am a Petr Arsentev, Who are you?");
    }

    @Test
    public void whenOneOfTheKeysIsMissingThenException() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev"
        );
        String result = generator.produce(template, args);
        AssertionsForClassTypes.assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenContainsExtraKeysThenException() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "extra", "value"
        );
        String result = generator.produce(template, args);
        AssertionsForClassTypes.assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMapIsEmptyThenException() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of();
        String result = generator.produce(template, args);
        AssertionsForClassTypes.assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

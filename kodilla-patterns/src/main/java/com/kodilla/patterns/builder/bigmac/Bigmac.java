package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private Bun bun;
    private int burgers;
    private Sauce sauce;
    private List<Ingredients> ingrediens;

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingrediens) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingrediens = ingrediens;
    }

    public static class BurgerBuilder {

        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredients> ingrediens = new ArrayList<>();

        public BurgerBuilder(Bun bun, int burgers) {
            this.bun = bun;
            this.burgers = burgers;
        }

        public BurgerBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BurgerBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BurgerBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BurgerBuilder ingredient(Ingredients ingredient) {
            ingrediens.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingrediens);

        }
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingrediens=" + ingrediens +
                '}';
    }

    public List<Ingredients> getIngrediens() {
        return ingrediens;
    }
}

package com.poopaises.paises.entity;

public enum ContinentEntity {
    AFRICA, ASIA, EUROPA, AMERICA_NORTE, AMERICA_SUL, OCEANIA;

    @Override
    public String toString() {

        String formatted = name().replace("_", " ").toLowerCase();


        String[] words = formatted.split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return capitalized.toString().trim();
    }
}
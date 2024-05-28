
package workingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long enter = Long.parseLong(scanner.nextLine());
        String[] seif = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < seif.length; i += 2) {
            String name = seif[i];
            long number = Long.parseLong(seif[i + 1]);

            String subject = "";

            if (name.length() == 3) {
                subject = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                subject = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                subject = "Gold";
            }

            if (subject.equals("")) {
                continue;
            } else if (enter < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + number) {
                continue;
            }

            switch (subject) {
                case "Gem":
                    if (!bag.containsKey(subject)) {
                        if (bag.containsKey("Gold")) {
                            if (number > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(subject).values().stream().mapToLong(e -> e).sum() + number > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(subject)) {
                        if (bag.containsKey("Gem")) {
                            if (number > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(subject).values().stream().mapToLong(e -> e).sum() + number > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(subject)) {
                bag.put((subject), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(subject).containsKey(name)) {
                bag.get(subject).put(name, 0L);
            }


            bag.get(subject).put(name, bag.get(subject).get(name) + number);

            if (subject.equals("Gold")) {
                gold += number;
            } else if (subject.equals("Gem")) {
                gem += number;
            } else if (subject.equals("Cash")) {
                cash += number;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}
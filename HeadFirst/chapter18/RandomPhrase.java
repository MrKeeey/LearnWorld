package HeadFirst.chapter18;

public class RandomPhrase {
    public static String makePhrase() {

        String[] wordListOne = {"круглосуточный", "трехзвенный", "30000-фунтовый", "взаимный", "обюдный выигрыш",
                "фронтэнд", "на основе вебтехнологий", "проникающий", "умный", "шесть сигм",
                "метод критического пути", "динамичный"};
        String[] wordListTwo = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный",
                "распределенный", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный",
                "сетевой", "сфокусированный", "использованный с выгодой", "выровненный",
                "нацеленный на", "общий", "совместный", "ускореный"};
        String[] wordListThree = {"процесс", "пункт разгрузки", "выход из приложения", "тип структуры", "талант",
                "подход", "уровень завоеванного внимания", "портал", "период времени", "обзор",
                "образец", "пункт следования"};

        int rand1 = (int) (Math.random() * wordListOne.length);
        int rand2 = (int) (Math.random() * wordListTwo.length);
        int rand3 = (int) (Math.random() * wordListThree.length);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        return ("Все что вам нужно, - это " + phrase);
    }
}

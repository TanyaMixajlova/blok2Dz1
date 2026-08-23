package org.skypro.skyshop.product;

import org.skypro.skyshop.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchBar) throws BestResultNotFound {
        // проверка на null
        //if (searchBar == null || searchables == null) {
        //   throw new IllegalArgumentException("Параметры не должны быть null");
        //}
        // карте Set<Searchable> с именем results создается стрим с объектами searchables
        Set<Searchable> results = searchables.stream()
                // фильтрация ненулевых элементов. Гарантирует, что мы работаем только с ненулевыми элементами в потоке.
                .filter(Objects::nonNull)
                // применяется метод, в котором фильтруются элементы в соответствии с условием лямбды-выражением
                //создается элемент searchableItem в который присваиваются элементы из карты Searchable и после -> к этому же текущему элементу searchableItem
                // применяется метод searchTerm() из интерфейса и имя этого объекта проверяется на null и на равенство с входящим объектом searchBar
                .filter(searchableItem -> searchableItem.searchTerm() != null &&
                        searchableItem.searchTerm().contains(searchBar))
                // применяется термальная операция collect завершающий метод(указывает как будут храниться элементы)
                // до знака -> мы обобщаем, что это будет коллекция, но не указываем какая именно. В параметры коллекции используется
                // функциональный интерфейс Supplier<T>, который возвращает объект типа Т (в этом случае возвращаемый объект это коллекция), а именно
                // создается новый TreeSet с заданным компаратором.
                // Код записываем в виде лямбды-выражения не принимающего аргументы, что соответствует сигнатуре метода get() интерфейса Supplier.
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
        if (results.isEmpty()) {
            throw new BestResultNotFound("Нет подходящего объекта");
        }
        return results;
    }
    public void add(Searchable newSearchable) {
        searchables.add(newSearchable);
    }
}









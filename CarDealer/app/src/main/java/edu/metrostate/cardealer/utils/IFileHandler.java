package edu.metrostate.cardealer.utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IFileHandler {

    public <T> Optional<List<T>> importDataFromFile(String filePath);

    public <T, U> Collection<U> parse(T data);

    <T> void exportDataToFile(List<T> dataList);
}

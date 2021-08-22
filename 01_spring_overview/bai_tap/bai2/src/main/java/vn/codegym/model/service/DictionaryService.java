package vn.codegym.model.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    public Map<String, String> list = new HashMap<>();

    @Override
    public String findWord(String word) {
        list.put("mèo", "cat");
        list.put("chó", "dog");
        list.put("cá", "fish");
        String string = list.get(word);
        if (string != null) {
            return string;
        } else {
            return "Not found";
        }
    }
}
